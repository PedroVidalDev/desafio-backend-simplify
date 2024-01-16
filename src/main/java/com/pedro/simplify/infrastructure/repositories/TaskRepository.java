package com.pedro.simplify.infrastructure.repositories;

import com.pedro.simplify.infrastructure.entities.Task;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    boolean existsByName(String name);

    List<Task> findAllByPriority(int i);

    List<Task> findAllByRealized(boolean b);
}
