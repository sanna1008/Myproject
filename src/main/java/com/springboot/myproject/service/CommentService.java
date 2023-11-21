package com.springboot.myproject.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.myproject.dto.CommentRequest;
import com.springboot.myproject.model.Comment;
import com.springboot.myproject.model.User;
import com.springboot.myproject.repository.CommentRepository;
import com.springboot.myproject.repository.UserRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public String addComment(CommentRequest request) {
		// Basic validation
		if (request == null || request.getCommentFrom() == null || request.getCommentTo() == null
				|| request.getMessage() == null) {
			return "Invalid request";
		}

		// Check if the user to whom the comment is being commented is present in the
		// user table
		User toUser = userRepository.findByCommentTo(request.getCommentTo());
		if (toUser == null) {
			// If not present, create the user
			toUser = new User();
			toUser.setCommentTo(request.getCommentTo());
			toUser.setCommentFrom(request.getCommentFrom());
			userRepository.save(toUser);
		}
		// Create and save the comment
		Comment comment = new Comment();
		comment.setMessage(request.getMessage());
		comment.setCommentDateTime(LocalDateTime.now());
		comment.setPostedByUser(userRepository.findByCommentFrom(request.getCommentFrom()));
		commentRepository.save(comment);

		// Validate if the user is present in the user table
		if (comment.getPostedByUser() == null) {
			return "Invalid Request: The user who posted the comment is not present in the user table.";
		}

		return "Comment added successfully";
	}
}
