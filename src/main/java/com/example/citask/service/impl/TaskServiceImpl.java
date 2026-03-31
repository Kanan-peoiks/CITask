package com.example.citask.service.impl;

import com.example.citask.entity.Task;

import java.util.List;

public interface TaskServiceImpl {

    Task createTask(Task task);

    List<Task> findAll();

    Task getById(Long id);

    Task updateTask(Long id, Task task);



    void deleteById(Long id);
}
