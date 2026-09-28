package org.example.web.controller;

import org.example.domain.Task;
import org.example.domain.TaskRepository;
import org.example.web.exception.TaskNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/new")
    public String createTask(Model model){
        return "create-task";
    }

    @PostMapping("/new")
    public String createTask(@RequestParam("title") String title,
                             @RequestParam("priority") String priority,
                             @RequestParam(value = "completed", defaultValue = "false") boolean completed, Model model){


        Task newTask = new Task(null,title,priority,completed);
        taskRepository.save(newTask);

        model.addAttribute("task", newTask);
        return "task-success";
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
