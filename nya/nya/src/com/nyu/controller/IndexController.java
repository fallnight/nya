package com.nyu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nyu.entity.Video;
import com.nyu.service.VideoService;

@Controller
public class IndexController {

	@Resource
	private VideoService videoService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		List<Video> videos = videoService.findTopVideoList(10);
		mav.addObject("videos", videos);
		return mav;
	}
	
}
