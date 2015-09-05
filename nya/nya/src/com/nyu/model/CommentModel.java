package com.nyu.model;

import java.util.HashSet;
import java.util.Set;

import com.nyu.entity.Comments;
import com.nyu.entity.User;
import com.nyu.entity.Video;

public class CommentModel {

	private Integer id;
	private User user;
	private Video video;
	private String content;
	private Set<Comments> commentses = new HashSet<Comments>(0);
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Set<Comments> getCommentses() {
		return commentses;
	}
	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}

	
	
}
