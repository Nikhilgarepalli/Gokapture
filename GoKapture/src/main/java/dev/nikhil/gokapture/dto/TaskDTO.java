package dev.nikhil.gokapture.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime dueDate;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
