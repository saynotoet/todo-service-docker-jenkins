package com.todo.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.service.model.User;
import com.todo.service.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
	private UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
