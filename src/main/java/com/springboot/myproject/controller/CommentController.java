package com.springboot.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myproject.dto.CommentRequest;
import com.springboot.myproject.model.Comment;
import com.springboot.myproject.model.User;
import com.springboot.myproject.repository.CommentRepository;
import com.springboot.myproject.repository.UserRepository;
import com.springboot.myproject.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addComment(@RequestBody CommentRequest request) {
		 // Validate user names
        if (!isValidUserName(request.getCommentFrom()) || !isValidUserName(request.getCommentTo())) {
            return ResponseEntity.badRequest().body("Invalid Request: User names should not contain special characters, numbers, or symbols.");
        }

        // Validate user names are not empty or blank
        if (isBlankOrEmpty(request.getCommentFrom()) || isBlankOrEmpty(request.getCommentTo())) {
            return ResponseEntity.badRequest().body("Invalid Request: User names should not be empty or blank.");
        }
		try {
            String result = commentService.addComment(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding comment");
        }
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Comment>> getComments(@RequestParam("commentTo") String commentTo) {
		// Basic validation
        if (commentTo == null || commentTo.trim().isEmpty()) {
        	// Return an empty list for bad requests
            return ResponseEntity.badRequest().body(List.of()); 
        }
     // Check if the user exists
        User user = userRepository.findByCommentTo(commentTo);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        // Retrieve comments for the user
        List<Comment> comments = commentRepository.findByPostedByUser(user);

        return ResponseEntity.ok(comments);
	}
	private boolean isValidUserName(String userName) {
        // Regular expression to match names containing only letters and spaces
        String regex = "^[a-zA-Z ]+$";
        return userName.matches(regex);
    }

    private boolean isBlankOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
