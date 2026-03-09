package com.app.todo_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.todo_app.repository.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
