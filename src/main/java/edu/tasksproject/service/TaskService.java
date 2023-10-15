package edu.tasksproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.tasksproject.handler.BusinessException;
import edu.tasksproject.modal.Task;
import edu.tasksproject.modal.TodoList;
import edu.tasksproject.repositories.TaskRepository;
import edu.tasksproject.repositories.TodoListRepository;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TodoListRepository todoListRepository;

    public ResponseEntity<List<Task>> index() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    public void create(Task task) {

        if(task.getName().isBlank()){
            throw new BusinessException("Insira um nome a sua Task!");
        }

        taskRepository.save(task);
    }

    public void update(Task task) {
        var verifyId = taskRepository.findById(task.getId());

        if (!verifyId.isPresent()) {
            throw new BusinessException("Task não existe");
        }

        if(task.getName() != null){
            verifyId.get().setName(task.getName());
        }

        if(task.getDescription() != null){
            verifyId.get().setDescription(task.getDescription());
        }

        taskRepository.save(verifyId.get());

    }

    public void delete(String id) {
        var verifyId = taskRepository.findById(id);

        if (!verifyId.isPresent()) {
            throw new BusinessException("Task não existe");
        }

        taskRepository.deleteById(id);

        for (TodoList todo : todoListRepository.findAll()) {
            if (todo.getTask_id().equals(id)) {
                todoListRepository.deleteById(todo.getId());
            }
        }
    }
}
