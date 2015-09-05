package com.nyu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nyu.dao.BaseDAO;
import com.nyu.entity.User;
import com.nyu.model.UserModel;
import com.nyu.service.UserService;
import com.nyu.util.Util;
import com.nyu.util.page.Page;
import com.nyu.util.page.PageResultSet;



@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Resource
	private BaseDAO<User> userDao;
	
	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public List<User> findAllUserList() {

		return userDao.find("from User u order by u.createTime desc");
	}

	@Override
	public List<User> findUserListByCondition(UserModel userModel) {
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<>();
		if(!Util.isNull(userModel.getUsername())){
			hql.append(" and u.username = ?");
			paramList.add(userModel.getUsername());
		}
			
		if(!Util.isNull(userModel.getPassword())){
			hql.append(" and u.password = ?");
			paramList.add(userModel.getPassword());
		} 
		if(!Util.isNull(userModel.getEmail())){
			hql.append(" and u.email = ?");
			paramList.add(userModel.getEmail());
		} 
		

		if (userModel.getSex() != null) {
			hql.append(" and u.sex = ?");
			paramList.add(userModel.getSex());
		}
		return userDao.find(hql.toString(), paramList);
	}

	@Override
	public User findUserByByCondition(UserModel userModel) {
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<>();
		if(!Util.isNull(userModel.getUsername())){
			hql.append(" and u.username = ?");
			paramList.add(userModel.getUsername());
		}
			
		if(!Util.isNull(userModel.getPassword())){
			hql.append(" and u.password = ?");
			paramList.add(userModel.getPassword());
		} 
		if(!Util.isNull(userModel.getEmail())){
			hql.append(" and u.email = ?");
			paramList.add(userModel.getEmail());
		} 
		

		if (userModel.getSex() != null) {
			hql.append(" and u.sex = ?");
			paramList.add(userModel.getSex());
		}
		if (paramList.size() == 0) {
			return null;
		}
		return userDao.get(hql.toString(), paramList.toArray());
	}

	@Override
	public User getUserById(int id) {
		return userDao.get(User.class, id);
	}

	@Override
	public PageResultSet<User> findPageUserList(UserModel userModel, int page,
			int pageSize) {
		
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<>();
		if(!Util.isNull(userModel.getUsername())){
			hql.append(" and u.username = ?");
			paramList.add(userModel.getUsername());
		}
			
		if(!Util.isNull(userModel.getPassword())){
			hql.append(" and u.password = ?");
			paramList.add(userModel.getPassword());
		} 
		if(!Util.isNull(userModel.getEmail())){
			hql.append(" and u.email = ?");
			paramList.add(userModel.getEmail());
		} 
		

		if (userModel.getSex() != null) {
			hql.append(" and u.sex = ?");
			paramList.add(userModel.getSex());
		}
		hql.append(" order by u.createTime desc");
		
		Long totalRow = userDao.count(hql.toString(), paramList); 
		
		Page pages = new Page(totalRow.intValue(), pageSize, page);
		//这里用到了Page类中的获取首页和分页大小的方�?
		List<User> list = userDao.find(hql.toString(), paramList, page, pageSize);

		//把取出来的结果放到list�?
		PageResultSet<User> pageResultSet = new PageResultSet<User>();

		pageResultSet.setList(list);

		pageResultSet.setPage(pages);

		return pageResultSet;
	}

	@Override
	public boolean register(UserModel userModel) {
		//1 查找是否有相同的用户名
		UserModel temp = new UserModel();
		temp.setUsername(userModel.getUsername());
		User user = findUserByByCondition(temp);
		if(user == null) {
//			user = new User();
//			user.setUsername(userModel.getUsername());
//			user.setPassword(Util.encryptMD5(userModel.getPassword()));
//			user.setEmail(userModel.getEmail());
//			user.setSex(1);
//			user.setCreateTime(new Date());
//			user.setUpdateTime(new Date());
//			user.setCreateUser("admin");
//			user.setUpdateUser("user");
			//FIXME 发送邮件验证
//			logger.info("-- register :" + .getUsername());
//			userDao.add(user);
			return true;
		}
		logger.error("-- register: " + user.getUsername() + " is alredy exist");
		return false;
	}

}
