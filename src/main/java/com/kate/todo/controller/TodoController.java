package com.kate.todo.controller;

import com.kate.todo.dto.TodoItemDTO;
import com.kate.todo.entity.TodoItem;
import com.kate.todo.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oleg Z. (cornknight@gmail.com)
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

	private final TodoRepository repo;

	public TodoController(TodoRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/list")
	public List<TodoItemDTO> getTodoList() {
		return repo.findAll().stream()
		            .map(TodoItem::toDTO)
		            .collect(Collectors.toList());
	}

	@PostMapping(value = "/add")
	public TodoItemDTO add(@RequestBody TodoItemDTO dto) {
		TodoItem item = dto.toEntity();
		return repo.save(item).toDTO();
	}
}
