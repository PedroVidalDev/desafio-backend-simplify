package com.pedro.simplify.infrastructure.entities;

import com.pedro.simplify.application.dto.TaskInputDTO;
import com.pedro.simplify.application.dto.TaskInputUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="tasks")
@Entity(name="task")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean realized;
    private int priority;

    public Task(TaskInputDTO dto){
        this.name = dto.name();
        this.description = dto.description();
        this.realized = dto.realized();
        this.priority = dto.priority();
    }

    public void update(TaskInputUpdateDTO data) {
        this.description = data.description();
        this.realized = data.realized();
        this.priority = data.priority();
    }
}
