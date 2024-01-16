package com.pedro.simplify.application;

import com.pedro.simplify.application.dto.TaskInputDTO;
import com.pedro.simplify.application.dto.TaskOutputDTO;
import com.pedro.simplify.infrastructure.entities.Task;
import com.pedro.simplify.infrastructure.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createTask(@RequestBody TaskInputDTO data){
        repository.save(new Task(data));

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllTask(){
        var listTasks = repository.findAll().stream().map(TaskOutputDTO::new).toList();

        return ResponseEntity.ok(listTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneTask(@PathVariable String id){
        var task = repository.getReferenceById(Long.parseLong(id));

        return ResponseEntity.ok(new TaskOutputDTO(task));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTask(@PathVariable String id){
        repository.deleteById(Long.parseLong(id));

        return ResponseEntity.noContent().build();
    }
}
