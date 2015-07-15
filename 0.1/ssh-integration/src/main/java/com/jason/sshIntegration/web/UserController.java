/**
 * 
 */
package com.jason.sshIntegration.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.sshIntegration.entity.User;
import com.jason.sshIntegration.service.UserService;

/**
 * @author jasonzhang
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("userController")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("userList")
	public String userList(HttpServletRequest request) {
		request.setAttribute("userList", userService.getAllUser());
		return "/com/jason/sshIntegration/userList";
	}

	@RequestMapping("addorupdate")
	public String addorupdate(User user, HttpServletRequest request) {
		if (user.getId() != null) {
			user = userService.getUser(user.getId());
			request.setAttribute("userPage", user);
		}
		return "/com/jason/sshIntegration/user";
	}

	@RequestMapping("save")
	public String save(User user, HttpServletRequest request) {
		System.out.println("用户名是======" + user.getUserName());
		if (user.getId() != null && !user.getId().equals("")) {
			this.userService.updateUser(user);
		} else {
			userService.saveUser(user);
		}
		return "redirect:userList.do";
	}

	@RequestMapping("delUser")
	public void delUser(String id, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (userService.delUser(id)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");  
	    try {  
	        PrintWriter out = response.getWriter();  
	        out.write(result);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}
}
