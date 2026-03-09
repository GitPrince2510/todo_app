package com.app.todo_app.repository.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todo_app.repository.TaskRepository;
import com.app.todo_app.repository.entities.Task;

@Service
public class TaskService {
	
	@Autowired
	private final TaskRepository taskRepository;
	
	private TaskService (TaskRepository taskRepository) {
		this.taskRepository = taskRepository; 
	}
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public void createTask(String title) {
		Task task = new Task();
		task.setTitle(title);
		task.setCompleted(false);
		taskRepository.save(task);
	}
	
	public void deleteTask(int id) {
		taskRepository.deleteById(id);
	}

	public void toggleTask(int id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
		task.setCompleted(!task.isCompleted());
		taskRepository.save(task);
		
	}

}
