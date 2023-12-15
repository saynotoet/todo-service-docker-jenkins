package com.todo.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todo.service.model.User;
import com.todo.service.service.UserService;


@Controller
@SessionAttributes("user")
public class WelcomeController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService; 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		 
		return "welcome";
	}
	@RequestMapping(value = "/todo/{username}", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model,@PathVariable String username) {
		
		User user = userService.findByUsername(username);
		
		model.put("user",  user);
		return "welcome";
	}
	

	
}
