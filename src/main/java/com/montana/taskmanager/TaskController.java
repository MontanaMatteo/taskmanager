package com.montana.taskmanager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private final List<Task> tasks = new ArrayList<>(List.of(
            new Task(1, "Studiare Java", false),
            new Task(2, "Fare la spesa", true),
            new Task(3, "Allenamento", false),
            new Task(4, "Titolo a tua scelta", true)
    ));

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable long id) {
        return tasks.stream()
                .filter(task -> task.id() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Task non trovato"));
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody CreateTaskRequest request) {
        long newId = tasks.stream().mapToLong(Task::id).max().orElse(0) + 1;
        Task task = new Task(newId, request.title(), false);
        tasks.add(task);
        return task;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}