package edu.tasksproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tasksproject.modal.Task;
import edu.tasksproject.repositories.TaskRepository;
import edu.tasksproject.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;


    @GetMapping("/tasks-all")
    public ResponseEntity<List<Task>> getAllTasks(){
        //Todo-List: retornar método de criação dos servições de task
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @PostMapping("/create/tasks")
    public ResponseEntity<Task> createTasks(@RequestBody Task task){
        //Todo-List: retornar método de criação dos servições de task

        taskService.create(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable("id") String id){
        //Todo-List: retornar método de criação dos servições de task

        taskService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-task")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        //Todo-List: retornar método de criação dos servições de task
        taskService.update(task);
        return ResponseEntity.ok().build();
    }
}
