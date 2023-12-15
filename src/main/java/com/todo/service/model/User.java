package com.todo.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User{
	
	@Id
	@GeneratedValue
	private long id;
	
	private String username;

	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Todo> todos=new ArrayList<>();

	public User() {
		
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void addTodo(Todo todo) {
		this.todos.add(todo);
	}
	
	public void removeTodo(Todo todo) {
		this.todos.remove(todo);
	}
	
	public List<Todo> getTodos(){
		return this.todos;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
