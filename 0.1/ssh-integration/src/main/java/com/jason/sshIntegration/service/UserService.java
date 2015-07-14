/**
 * 
 */
package com.jason.sshIntegration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.sshIntegration.dao.UserDao;
import com.jason.sshIntegration.entity.User;

/**
 * @author jasonzhang
 *
 */
@Service("userService")
@Transactional
public class UserService {

	@Resource
	private UserDao userDao;  

	public User getUser(String id) {  
	    return userDao.getUser(id);  
	}  

	public List<User> getAllUser() {  
	    return userDao.getAllUser();  
	}  

	public void saveUser(User user) {  
	    userDao.saveUser(user);  
	}  

	public boolean delUser(String id) {  

	    return userDao.delUser(id);  
	}  

	public boolean updateUser(User user) {  
	    return userDao.updateUser(user);  
	}
}
