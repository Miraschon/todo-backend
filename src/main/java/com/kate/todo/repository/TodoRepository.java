package com.kate.todo.repository;

import com.kate.todo.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Oleg Z. (cornknight@gmail.com)
 */
public interface TodoRepository extends JpaRepository<TodoItem,Long> {
}
