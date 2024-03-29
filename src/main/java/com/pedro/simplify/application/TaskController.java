package com.pedro.simplify.application;

import com.pedro.simplify.application.dto.TaskInputDTO;
import com.pedro.simplify.application.dto.TaskInputUpdateDTO;
import com.pedro.simplify.application.dto.TaskOutputDTO;
import com.pedro.simplify.domain.TaskService;
import com.pedro.simplify.infrastructure.entities.Task;
import com.pedro.simplify.infrastructure.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskService service;

    @PostMapping
    @Transactional
    public ResponseEntity createTask(@RequestBody @Valid TaskInputDTO data, UriComponentsBuilder uriBuild){

        var task = service.createNewTaskVerify(data);

        var uri = uriBuild.path("/tasks/{id}").buildAndExpand(task.getId()).toUri();

        return ResponseEntity.created(uri).body(new TaskOutputDTO(task));
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
        service.deleteTaskVerify(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateTask(@PathVariable String id, @RequestBody @Valid TaskInputUpdateDTO data){
        Task task = repository.findById(Long.parseLong(id)).get();

        task.update(data);

        return ResponseEntity.ok(task);
    }

    @GetMapping("/byPriority/{priority}")
    public ResponseEntity getByPriority(@PathVariable String priority){
        var tasks = repository.findAllByPriority(Integer.parseInt(priority)).stream().map(TaskOutputDTO::new).toList();

        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/byRealized/{realized}")
    public ResponseEntity getByRealized(@PathVariable String realized){
        var tasks = repository.findAllByRealized(Boolean.parseBoolean(realized)).stream().map(TaskOutputDTO::new).toList();

        return ResponseEntity.ok(tasks);
    }
}
