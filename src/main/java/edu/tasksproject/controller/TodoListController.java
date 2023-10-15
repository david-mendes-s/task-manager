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

import edu.tasksproject.dto.IRequestBodyTodoList;
import edu.tasksproject.modal.TodoList;
import edu.tasksproject.repositories.TodoListRepository;
import edu.tasksproject.service.TodoListService;

@RestController
@RequestMapping("/todo-list")
public class TodoListController {

    @Autowired
    TodoListService todoListService;

    @Autowired
    TodoListRepository todoListRepository;

    @GetMapping("/todo-list-all")
    public ResponseEntity<List<TodoList>> getAllTodoListOfOneTask(@RequestBody IRequestBodyTodoList task) {
        // Todo-List: retornar método de criação dos servições de todolist

        return ResponseEntity.ok(todoListRepository.findByTodoListTaskId(task.getId()));
    }

    @PostMapping("/create/todo-list-task")
    public ResponseEntity<TodoList> createTodoList(@RequestBody TodoList todoList) {
        // Todo-List: retornar método de criação dos servições de todolist

        todoListService.create(todoList);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-todo-list/{id}")
    public ResponseEntity<TodoList> deleteTodoList(@PathVariable("id") String id) {
        // Todo-List: retornar método de criação dos servições de todolist
        todoListService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-todo-list")
    public ResponseEntity<TodoList> updateTodoList(@RequestBody TodoList todolist) {
        // Todo-List: retornar método de criação dos servições de todolist
        todoListService.update(todolist);
        return ResponseEntity.ok().build();
    }
}
