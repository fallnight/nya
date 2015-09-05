package com.nyu.service;

import java.util.List;

import com.nyu.entity.Video;

public interface VideoService {

	/**
	 * 保存视频
	 * @param video
	 */
	public void saveVideo(Video video);
	/**
	 * 更新视频
	 * @param video
	 */
	public void updateVideo(Video video);
	/**
	 * 删除视频
	 * @param video
	 */
	public void deleteVideo(Video video);
	/**
	 * 查询全部视频
	 * @return
	 */
	public List<Video> findTopVideoList(Integer num);
	/**
	 * 根据ID查询视频
	 * @param id
	 * @return
	 */
	public Video getVideoById(int id);
}
