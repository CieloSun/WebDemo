package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.TbUserService;

@Controller
@RequestMapping("/Main")
public class MainController {
	@RequestMapping("/add")
	public String add() {
		return "add";
	}

	@SuppressWarnings("resource")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		TbUserService tbUserService = applicationContext.getBean("userService",TbUserService.class);
		boolean success = tbUserService.addAUserByNameAndPassword(
				request.getParameter("name"), request.getParameter("password"));
		if (success)
			return "edit";
		return "error";
	}
}
