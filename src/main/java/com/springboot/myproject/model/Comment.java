package com.springboot.myproject.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	@Column(name = "message")
	private String message;
	@Column(name = "commentdatetime")
	private LocalDateTime commentDateTime;
	@ManyToOne
	@JoinColumn(name = "posted_by_user_id")
	private User postedByUser;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(Long commentId, String message, LocalDateTime commentDateTime, User postedByUser) {
		super();
		this.commentId = commentId;
		this.message = message;
		this.commentDateTime = commentDateTime;
		this.postedByUser = postedByUser;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getCommentDateTime() {
		return commentDateTime;
	}
	public void setCommentDateTime(LocalDateTime commentDateTime) {
		this.commentDateTime = commentDateTime;
	}
	public User getPostedByUser() {
		return postedByUser;
	}
	public void setPostedByUser(User postedByUser) {
		this.postedByUser = postedByUser;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", message=" + message + ", commentDateTime=" + commentDateTime
				+ ", postedByUser=" + postedByUser + "]";
	}
	
}
