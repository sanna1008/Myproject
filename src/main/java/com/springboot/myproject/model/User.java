package com.springboot.myproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(name = "commentfrom")
	private String commentFrom;
	@Column(name = "commentto")
	private String commentTo;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId, String commentFrom, String commentTo) {
		super();
		this.userId = userId;
		this.commentFrom = commentFrom;
		this.commentTo = commentTo;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCommentFrom() {
		return commentFrom;
	}
	public void setCommentFrom(String commentFrom) {
		this.commentFrom = commentFrom;
	}
	public String getCommentTo() {
		return commentTo;
	}
	public void setCommentTo(String commentTo) {
		this.commentTo = commentTo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", commentFrom=" + commentFrom + ", commentTo=" + commentTo + "]";
	}
	
}