package com.todo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTodo {

	@GetMapping("/test-todo")
	public String testTodo() {
		return "Todo working Fine !!!";
	}
}