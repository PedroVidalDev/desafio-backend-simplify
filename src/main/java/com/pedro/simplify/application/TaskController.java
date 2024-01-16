package com.pedro.simplify.application;

import com.pedro.simplify.application.dto.TaskInputDTO;
import com.pedro.simplify.infrastructure.entities.Task;
import com.pedro.simplify.infrastructure.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createTask(@RequestBody TaskInputDTO data){
        repository.save(new Task(data));

        return ResponseEntity.ok().build();
    }
}
