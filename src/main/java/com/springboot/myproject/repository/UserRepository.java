package com.springboot.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.myproject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByCommentTo(String commentTo);
	User findByCommentFrom(String commentFrom);
}
