package org.example.web.controller;

import org.example.domain.Task;
import org.example.domain.TaskRepository;
import org.example.web.exception.TaskNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository){
        this.taskRepository=taskRepository;

    }

    @RequestMapping
    public String getTasks(Model model){
        List<Task> tasks=taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/{id}")
    public String taskWithID(@PathVariable Long id, Model model){
        Task task =taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
        model.addAttribute("task", task);
        return "details";
    }

    @GetMapping("/search")
    public String searchWithPriority(@RequestParam String priority, Model model){
        List<Task> tasks = taskRepository.findByPriority( priority);
        model.addAttribute("tasks", tasks);
        model.addAttribute("priority", priority);
        return "tasks";
    }
}
