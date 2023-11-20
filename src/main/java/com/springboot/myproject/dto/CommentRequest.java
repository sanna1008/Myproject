package com.springboot.myproject.dto;

public class CommentRequest {
	private String commentFrom;
	private String commentTo;
	private String message;

	public CommentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentRequest(String commentFrom, String commentTo, String message) {
		super();
		this.commentFrom = commentFrom;
		this.commentTo = commentTo;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommentRequest [commentFrom=" + commentFrom + ", commentTo=" + commentTo + ", message=" + message + "]";
	}

}
