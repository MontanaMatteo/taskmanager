package com.montana.taskmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return List.of(
                new Task(1, "Studiare Java", false),
                new Task(2, "Fare la spesa", true),
                new Task(3, "Allenamento", false),
                new Task(4, "Titolo a tua scelta", true)
        );
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable long id) {
        return getTasks().stream()
                .filter(task -> task.id() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}