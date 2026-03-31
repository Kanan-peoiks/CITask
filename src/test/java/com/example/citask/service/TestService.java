package com.example.citask.service;


import com.example.citask.entity.Task;
import com.example.citask.repo.TaskRepo;
import com.example.citask.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestService {

    private final TaskRepo taskRepository = Mockito.mock(TaskRepo.class);
    private final TaskService taskService = new TaskServiceImpl(taskRepository);

    @Test
    void testCreateAndGetTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");

        Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(task);
        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task created = taskService.createTask(task);
        Task found = taskService.getById(1L);

        assertEquals("Test Task", created.getTitle());
        assertEquals(1L, found.getId());
    }
}
