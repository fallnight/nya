package com.nyu.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.nyu.entity.Comment;
import com.nyu.entity.Danmu;
import com.nyu.entity.User;

public class VideoModel {

	private Integer id;
	private User user;
	private String videoname;
	private String videoinr;
	private Integer playnum;
	private Integer collectnum;
	private String img;
	private Date createtime;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Danmu> danmus = new HashSet<Danmu>(0);
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getPlaynum() {
		return playnum;
	}
	public void setPlaynum(Integer playnum) {
		this.playnum = playnum;
	}
	public Integer getCollectnum() {
		return collectnum;
	}
	public void setCollectnum(Integer collectnum) {
		this.collectnum = collectnum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}
	public String getVideoinr() {
		return videoinr;
	}
	public void setVideoinr(String videoinr) {
		this.videoinr = videoinr;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Set<Danmu> getDanmus() {
		return danmus;
	}
	public void setDanmus(Set<Danmu> danmus) {
		this.danmus = danmus;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
