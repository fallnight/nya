package com.nyu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nyu.dao.BaseDAO;
import com.nyu.entity.Video;
import com.nyu.service.VideoService;


@Service("videoService")
public class VideoServiceImpl implements VideoService{

	@Resource
	private BaseDAO<Video> videoDao;
	
	@Override
	public void saveVideo(Video video) {
		videoDao.save(video);
		
	}

	@Override
	public void updateVideo(Video video) {
		videoDao.update(video);
		
	}

	@Override
	public void deleteVideo(Video video) {
		videoDao.delete(video);
		
	}

	@Override
	public List<Video> findTopVideoList(Integer num) {
		return videoDao.find("from Video v order by v.playnum desc",num);
	}

	@Override
	public Video getVideoById(int videoId) {
		return videoDao.get(Video.class, videoId);
	}

}
