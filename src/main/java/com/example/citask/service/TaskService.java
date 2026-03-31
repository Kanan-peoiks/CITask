package com.example.citask.service;


import com.example.citask.entity.Task;
import com.example.citask.repo.TaskRepo;
import com.example.citask.service.impl.TaskServiceImpl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
@Getter
@Setter
public class TaskService implements TaskServiceImpl {

    private final TaskRepo taskRepo;


    @Override
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepo.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public Task getById(Long id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task existingTask = getById(id);

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.isCompleted());

        return taskRepo.save(existingTask);
    }


    @Override
    public void deleteById(Long id) {
        Task task = getById(id);
        taskRepo.delete(task);
    }
}
