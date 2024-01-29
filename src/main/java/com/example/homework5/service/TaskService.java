package com.example.homework5.service;

import com.example.homework5.model.Task;
import com.example.homework5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Task updateStatusTask(Long id, Task.Status status) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(status);
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Задача с id = " + id + " не найдена");
        }
    }

    /**
     * Найти задачи по статусу.
     */
    public List<Task> getTasksByStatus(Task.Status status) {
        return taskRepository.getTasksByStatus(status);
    }
}