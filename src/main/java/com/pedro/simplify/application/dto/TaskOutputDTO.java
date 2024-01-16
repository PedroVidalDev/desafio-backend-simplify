package com.pedro.simplify.application.dto;

import com.pedro.simplify.infrastructure.entities.Task;

public record TaskOutputDTO(Long id, String name, String description, boolean realized, int priority) {
    public TaskOutputDTO(Task data){
        this(data.getId(), data.getName(), data.getDescription(), data.isRealized(), data.getPriority());
    }
}
