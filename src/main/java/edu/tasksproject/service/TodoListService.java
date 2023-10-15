package edu.tasksproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tasksproject.handler.BusinessException;
import edu.tasksproject.modal.TodoList;
import edu.tasksproject.repositories.TodoListRepository;

@Service
public class TodoListService {
    @Autowired
    TodoListRepository todoListRepository;

    public void create(TodoList todoList){

         if (todoList.getDescription().isBlank()) {
            throw new BusinessException("Insira um nome a sua Task!");
        }

        if (todoList.getTask_id() == null) {
            throw new BusinessException("Task não existe!");
        }
        
        todoListRepository.save(todoList);
    }

    public void update(TodoList todoList){
        
    }
}
