package com.app.todo_app.repository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todo_app.repository.entities.Task;
import com.app.todo_app.repository.services.TaskService;

@Controller
@RequestMapping("/")
public class TaskController {
	
	@Autowired
	private final TaskService taskService;
	
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public String getTasks(Model model) {
		List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
		return "tasks"; // returns the view name
	}
	
	@PostMapping
	public String createTask(@RequestParam String title) {
		taskService.createTask(title);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable int id) {
		taskService.deleteTask(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable int id) {
		taskService.toggleTask(id);
		return "redirect:/";
	}
	

}
