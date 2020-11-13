package com.kate.todo.dto;

import com.kate.todo.entity.TodoItem;

import java.time.Instant;

/**
 * @author Oleg Z. (cornknight@gmail.com)
 */
public class TodoItemDTO {
	private Long id;
	private String title;
	private Instant createdAt;

	public TodoItemDTO() {}

	public TodoItemDTO(Long id, String title, Instant createdAt) {
		this.id = id;
		this.title = title;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public TodoItem toEntity() {
		return new TodoItem(title, createdAt);
	}


}
