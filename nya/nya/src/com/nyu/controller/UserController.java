package com.nyu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nyu.entity.User;
import com.nyu.model.UserModel;
import com.nyu.service.UserService;
import com.nyu.util.Constants;
import com.nyu.util.Util;
import com.nyu.util.page.PageResultSet;

/**
 * 控制器怎么解析
 * @author amazing
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/userLogin")
	public String userLogin(UserModel userModel, Model model){
		userModel.setPassword(Util.encryptMD5(userModel.getPassword()));
		User user = userService.findUserByByCondition(userModel);
		if (user == null) {
			model.addAttribute("errorInfo", "you password is error!");
			return "login";
		}
		
		Constants.LOGIN_USER = user.getUsername();
		return "redirect:/user/index";
	}
	@RequestMapping("/addUser")
	public String addUser(UserModel userModel){
		Date date = new Date();
		User user = new User();
		BeanUtils.copyProperties(userModel, user); //实体属�?复制，将userModel中的属�?值复制到User�?
		user.setPassword(Util.encryptMD5(userModel.getPassword()));
		user.setCreateTime(date);
		userService.saveUser(user);
		return "redirect:/user/index";
	}
	@RequestMapping("/index")
	public ModelAndView index(UserModel userModel, HttpServletRequest request) {  
		if(Util.isNull(Constants.LOGIN_USER)){
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("errorInfo", "user is overdue!");
			return mav;
		}
	    return new ModelAndView("userList");  
	 }  
	
	@RequestMapping("/getUser")
	public void getUser(HttpServletRequest request, HttpServletResponse response, Model model) {  
	    int id = Integer.parseInt(request.getParameter("userId"));
	    User user = userService.getUserById(id);
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("user", user);
	    model.addAttribute("user", user);
	 }  
	
	@RequestMapping("/updateUser")
	public String updateUser(UserModel userModel){
		Date date = new Date();
		User user = userService.getUserById(userModel.getId());
		if (Util.isNull(userModel.getPassword())) {
			userModel.setPassword(user.getPassword());
		}else {
			userModel.setPassword(Util.encryptMD5(userModel.getPassword()));
		}
		userModel.setCreateTime(user.getCreateTime());
		BeanUtils.copyProperties(userModel, user);
		userService.updateUser(user);
		return "redirect:/user/index";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request){
		  int id = Integer.parseInt(request.getParameter("userId"));
		  User user = userService.getUserById(id);
		  userService.deleteUser(user);
		  return "redirect:/user/index";
	}
	
	@RequestMapping("/exit")
	public String exit(){
		Constants.LOGIN_USER = null;
		return "redirect:/";
	}
	//返回json
	@RequestMapping("/getJsonUserList")
	@ResponseBody
	public ModelMap getJsonUserList(UserModel userModel, HttpServletRequest request, HttpServletResponse response) {
		ModelMap modelMap = new ModelMap();
		response.setHeader("Access-Control-Allow-Origin", "*");
		String sPage = request.getParameter("page");
		int page = 1;
		if (!Util.isNull(sPage)) {
			page = Integer.parseInt(sPage);
		}
		PageResultSet<User> userPageResult = userService.findPageUserList(userModel, page, Constants.PAGE_SIZE);
		
		modelMap.addAttribute("event",userPageResult.getList());
		modelMap.addAttribute("pageBean", userPageResult.getPage());
		modelMap.addAttribute("pageCount",userPageResult.getPage().getTotalPage());
		return modelMap;
	}
	
	/**
	 * 用户注册界面
	 * @return
	 * @author amazing
	 */
	@RequestMapping("/userRegisterUI")
	public ModelAndView userRegisterUI() {
		return new ModelAndView("userRegisterUI");
	}
	
	/**
	 * 用户登陆界面
	 * @return
	 * @author amazing
	 */
	@RequestMapping("/userLoginUI")
	public ModelAndView userLoginUI() {
		return new ModelAndView("login");
	}
	
	/**
	 * 处理用户的注册业务
	 * @return
	 * @author amazing
	 */
	@RequestMapping("/userRegister")
	public String userRegister(UserModel userModel, Model model) {
		//1 先做判断空值处理,检验输入合法性
		String str = isUserInfo(userModel);
		if(Constants.REGISTER_INFO.equals(str)) {
			//合法，开始注册的业务员逻辑处理
			if(!userService.register(userModel)) {
				model.addAttribute("errorInfo", userModel.getUsername() + " has register");
				return "userRegisterUI";
			}
			//添加用户
			Date date = new Date();
			User user = new User();
			BeanUtils.copyProperties(userModel, user); //
			user.setPassword(Util.encryptMD5(userModel.getPassword()));
			user.setCreateTime(date);
			userService.saveUser(user);
			return "redirect:/user/userLoginUI";
		}else {
			//不合法，返回错误信息
			model.addAttribute("errorInfo", str);
			return "userRegisterUI";
		}
	}
	
	//----------------------------------------
	/**
	 * 对用户的信息进行校验
	 * @param userModel
	 * @author amazing
	 * @return
	 */
	public String isUserInfo(UserModel userModel) {
		if(Util.isNull(userModel.getUsername())) {
			return "username is null";
		}
		if(Util.isNull(userModel.getPassword())) {
			return "password is null";
		}
		if(Util.isNull(userModel.getEmail())) {
			return "email is null";
		}
		return Constants.REGISTER_INFO;
	}
	  
}
