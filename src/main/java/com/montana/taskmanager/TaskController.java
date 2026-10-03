package com.montana.taskmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @GetMapping("/tasks")
    public List<String> getTasks() {
        return List.of("Studiare Java", "Fare la spesa", "Allenamento");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}