package com.nyu.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.nyu.entity.Comment;
import com.nyu.entity.Comments;
import com.nyu.entity.Danmu;
import com.nyu.entity.Video;

public class UserModel implements Serializable {
	
	private static final long serialVersionUID = 3833817133782807122L;
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Integer sex;
	private Date createTime;
	private Set<Video> videos = new HashSet<Video>(0);
	private Set<Danmu> danmus = new HashSet<Danmu>(0);
	private Set<Comments> commentses = new HashSet<Comments>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	
	public Set<Danmu> getDanmus() {
		return danmus;
	}
	public void setDanmus(Set<Danmu> danmus) {
		this.danmus = danmus;
	}
	public Set<Comments> getCommentses() {
		return commentses;
	}
	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Set<Video> getVideos() {
		return videos;
	}
	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
