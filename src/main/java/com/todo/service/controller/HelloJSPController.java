package com.todo.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloJSPController {

	@RequestMapping("/hellojsp")
	public String helloJSP() {
		return "hellojsp";
	}
}
