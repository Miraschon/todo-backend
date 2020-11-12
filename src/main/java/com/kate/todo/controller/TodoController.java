package com.kate.todo.controller;

import com.kate.todo.dto.TodoItemDTO;
import com.kate.todo.entity.TodoItem;
import com.kate.todo.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

	@GetMapping("/{id}")
	public TodoItemDTO get(@PathVariable Long id) throws Exception {
		Optional<TodoItem> itemOpt = repo.findById(id);
		if(itemOpt.isPresent()) {
			TodoItem item = itemOpt.get();
			return item.toDTO();
		} else {
			throw new Exception("No such object");
		}
	}

	@GetMapping("/list")
	public List<TodoItemDTO> getTodoList() {
		return repo.findAll().stream()
		            .map(TodoItem::toDTO)
		            .collect(Collectors.toList());
	}

	@PostMapping(value = "/add")
	public TodoItemDTO add(@RequestBody TodoItemDTO dto) {
		dto.setCreatedAt(Instant.now());
		TodoItem item = dto.toEntity();
		return repo.save(item).toDTO();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}

	@PutMapping(value = "/update")
	public TodoItemDTO update(@RequestBody TodoItemDTO dto) throws Exception {
		Optional<TodoItem> itemOpt = repo.findById(dto.getId());
		if(itemOpt.isPresent()) {
			TodoItem item = itemOpt.get();
			item.setTitle(dto.getTitle());
			return repo.save(item).toDTO();
		} else {
			throw new Exception("No such object");
		}
	}
}
