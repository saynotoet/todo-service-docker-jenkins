package com.todo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.service.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	public List<Todo> findByUserUsername(String username);
	public Todo findById(long id);

}