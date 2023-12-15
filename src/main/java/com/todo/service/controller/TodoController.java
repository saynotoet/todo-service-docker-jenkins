package com.todo.service.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todo.service.model.Todo;
import com.todo.service.model.User;
import com.todo.service.service.TodoService;

@Controller
@SessionAttributes("user")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	@RequestMapping(value="/todo/listTodos", method=RequestMethod.GET)
	public String listTodos(ModelMap model) {
		User user=(User) model.get("user");
		
		model.addAttribute("todos", todoService.findByUserUsername(user.getUsername()));
		return "listTodos";
	}

	@RequestMapping(value = "/todo/addTodo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		User user=(User) model.get("user");

 		Todo todo = new Todo( "",user , LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/todo/addTodo", method = RequestMethod.POST)
	public String addNewTodo( ModelMap model, @Valid Todo todo, BindingResult result) {
		User user=(User) model.get("user");

		if(result.hasErrors()) {
			return "todo";
		}
		
		todoService.save(new Todo( todo.getDescription(), user, todo.getTargetDate(), false));
		return "redirect:/todo/listTodos";
	}
	
	@RequestMapping("/todo/deleteTodo")
	public String deleteTodo(@RequestParam int id) {
		
		todoService.deleteById((long)id);
		return "redirect:/todo/listTodos";
		
	}
	@RequestMapping(value="/todo/updateTodo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById((long)id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value="/todo/updateTodo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		User user=(User) model.get("user");

		if(result.hasErrors()) {
			return "todo";
		}
		
		logger.info("update todo: "+user.toString());
		
 		todo.setUser(user);
		todoService.save(todo);
		return "redirect:/todo/listTodos";
	}
	 
	
}
