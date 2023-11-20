package com.springboot.myproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.myproject.model.Comment;
import com.springboot.myproject.model.User;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByPostedByUser(User user);
}
