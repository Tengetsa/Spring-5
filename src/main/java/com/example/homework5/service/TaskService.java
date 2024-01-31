package com.example.homework5.service;

import com.example.homework5.model.Task;
import com.example.homework5.repository.TaskRepository;
import com.example.homework5.status.TaskStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    /**
     * добавить задачу.
     */
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * список всех задач.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * сведенич задачи по id.
     */
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    /**
     * удаления задач по id.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * обновления задачи.
     */
    public Task updateStatusTask(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setStatus(task.getStatus());
            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }

    /**
     * Найти задачи по статусу.
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.getTasksByStatus(status);
    }
}