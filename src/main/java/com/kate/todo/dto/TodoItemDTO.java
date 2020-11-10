package com.kate.todo.dto;

import com.kate.todo.entity.TodoItem;

/**
 * @author Oleg Z. (cornknight@gmail.com)
 */
public class TodoItemDTO {
	private Long id;
	private String title;

	public TodoItemDTO() {}

	public TodoItemDTO(Long id, String title) {
		this.id = id;
		this.title = title;
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

	public TodoItem toEntity() {
		return new TodoItem(title);
	}

}
