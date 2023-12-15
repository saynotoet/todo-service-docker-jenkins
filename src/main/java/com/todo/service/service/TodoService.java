package com.todo.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.service.model.Todo;
import com.todo.service.repository.TodoRepository;
 
@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> findByUserUsername(String username) {
		return todoRepository.findByUserUsername(username);
	}

	public void save(Todo todo) {
		todoRepository.save(todo);
	}

	public void deleteById(long id) {
		todoRepository.deleteById(id);
	}

	public Todo findById(long id) {
		return todoRepository.findById(id);
	}
	
	
	
	

}
