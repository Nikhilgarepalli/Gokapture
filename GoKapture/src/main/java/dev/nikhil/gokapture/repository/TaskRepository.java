package dev.nikhil.gokapture.repository;



import dev.nikhil.gokapture.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);
    List<Task> findByPriority(String priority);
    List<Task> findByDueDate(LocalDateTime dueDate);
    List<Task> findByTitleContainingOrDescriptionContaining(String title, String description);
}
