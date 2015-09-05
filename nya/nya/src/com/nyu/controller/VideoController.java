package com.nyu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nyu.entity.Video;
import com.nyu.service.VideoService;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Resource
	private VideoService videoService;
	
	@RequestMapping(value="/{videoId}")
	public ModelAndView getVideo(@PathVariable(value="videoId") String videoId) {
		ModelAndView mav = new ModelAndView("video");
		String vid = videoId.substring(3);
		Video video = videoService.getVideoById(Integer.parseInt(vid));
		mav.addObject("video", video);
		return mav;
	}
	
	
}
