package com.example.citask.service;


import com.example.citask.entity.Task;
import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    List<Task> findAll();

    Task getById(Long id);

    Task updateTask(Long id, Task task);

    void deleteById(Long id);
}