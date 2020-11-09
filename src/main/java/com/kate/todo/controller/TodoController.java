package com.kate.todo.controller;

import com.kate.todo.dto.Todo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Z. (cornknight@gmail.com)
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

	@GetMapping("/list")
	public List<Todo> getTodoList() {
		List<Todo> todos = new ArrayList<>();
		todos.add(new Todo(1,"title1"));
		todos.add(new Todo(2,"title2"));
		todos.add(new Todo(2,"title3"));
		return todos;
	}
}
