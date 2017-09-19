package com.qgzx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgzx.dto.Result;
import com.qgzx.entity.User;
import com.qgzx.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;

	/**
	 * 登录 login
	 * @author zhangzhengan
	 * @return
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result<String> login(@RequestBody User user, HttpSession session) {

		String result;
		try {
			result = userService.login(user);
		} catch (Exception e) {
			return new Result<String>(false, "登录失败", null);
		}
		if (!"success".equals(result)) {
			return new Result<String>(false, result, null);
		} else {
			logger.info("登录成功：" + user);
			session.setAttribute("user", user);
			return new Result<String>(true, "登录成功", null);
		}
	}

	/**
	 * 登录界面 
	 * @author zhangzhengan
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value="/",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String index() {
		return "login";
	}

	@RequestMapping(value="/index",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String home(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "login";
		}
		return "index";
	}
	@RequestMapping(value = "/exit", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String exit(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	@RequestMapping(value="/admin-left", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String adminLeft() {
		return "admin-left";
	}
	@RequestMapping(value="/insertBringInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String insertBringInfo() {
		return "insertBringInfo";
	}
	@RequestMapping(value="/manage", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String manage() {
		return "manage";
	}
	@RequestMapping(value="/list", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String read() {
		return "list";
	}
	@RequestMapping(value="/back", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String back() {
		return "back";
	}
	@RequestMapping(value="/getBringInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String getBringInfo() {
		return "bringInfo";
	}
}
