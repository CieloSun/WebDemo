package com.cielo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cielo.service.TbUserService;

@Controller
@RequestMapping("/Main")
public class MainController {
	@Autowired
	TbUserService tbUserService;
	@RequestMapping("/add")
	public String add() {
		return "add";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request) {
		boolean success = tbUserService.addAUserByNameAndPassword(
				request.getParameter("name"), request.getParameter("password"));
		if (success)
			return "edit";
		return "error";
	}

	public TbUserService getTbUserService() {
		return tbUserService;
	}

	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}
}
