package com.pedro.simplify.domain;

import com.pedro.simplify.application.dto.TaskInputDTO;
import com.pedro.simplify.infrastructure.entities.Task;
import com.pedro.simplify.infrastructure.exceptions.TaskValidation;
import com.pedro.simplify.infrastructure.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task createNewTaskVerify(TaskInputDTO dto){
        if(repository.existsByName(dto.name())){
            throw new TaskValidation("That task already exists.");
        }
        else{
            Task task = new Task(dto);
            repository.save(task);
            return task;
        }
    }

    public void deleteTaskVerify(String id) {
        if(!repository.existsById(Long.parseLong(id))){
            throw new EntityNotFoundException();
        }
        else{
            repository.deleteById(Long.parseLong(id));
        }
    }
}
