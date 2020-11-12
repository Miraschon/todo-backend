package com.kate.todo.entity;

import com.kate.todo.dto.TodoItemDTO;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

/**
 * @author Oleg Z. (cornknight@gmail.com)
 */
@Entity
@Table(name = "todo_item")
public class TodoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	private Instant createdAt;

	public TodoItem() {}

	public TodoItem(String title) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TodoItem todoItem = (TodoItem) o;
		return Objects.equals(id, todoItem.id) && Objects.equals(title, todoItem.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	public TodoItemDTO toDTO() {
		return new TodoItemDTO(id,title);
	}
}
