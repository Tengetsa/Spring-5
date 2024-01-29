package com.example.homework5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks") // наименование созданой таблицы.
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private TaskStatus status;
    @Column
    private LocalDateTime local_date_time = LocalDateTime.now();

    public enum TaskStatus {
        TEMP, NOT_STARTED, IN_PROGRESS, COMPLETED, DEAD // меньше 4 выкидывает ошибку java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    }
}