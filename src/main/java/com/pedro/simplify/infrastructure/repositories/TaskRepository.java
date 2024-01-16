package com.pedro.simplify.infrastructure.repositories;

import com.pedro.simplify.infrastructure.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
