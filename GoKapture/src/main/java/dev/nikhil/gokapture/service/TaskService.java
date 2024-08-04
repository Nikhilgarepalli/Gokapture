package dev.nikhil.gokapture.service;

import dev.nikhil.gokapture.dto.TaskDTO;
import dev.nikhil.gokapture.model.Task;
import dev.nikhil.gokapture.model.User;
import dev.nikhil.gokapture.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        task.setUser(new User());
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> filterTasks(String status, String priority, LocalDateTime dueDate) {
        // Implement filtering logic
        return null;
    }

    public List<Task> searchTasks(String title, String description) {
        return taskRepository.findByTitleContainingOrDescriptionContaining(title, description);
    }
}
