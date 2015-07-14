/**
 * 
 */
package com.jason.sshIntegration.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
			request.setAttribute("user", userService.getUser(user.getId()));
		}
		return "/com/jason/sshIntegration/user";
	}

	@RequestMapping("save")
	public String save(User user, HttpServletRequest request) {
		System.out.println("ÓÃ»§Ãû£º======" + user.getUserName());
		if (user.getId() != null) {
			this.userService.updateUser(user);
		} else {
			userService.saveUser(user);
		}
		return "redirect:/userController.do?userList";
	}

	@RequestMapping("delUser")
	@ResponseBody
	public String delUser(String id, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (userService.delUser(id)) {
			result = "{\"result\":\"success\"}";
		}
		return result;
	}
}
