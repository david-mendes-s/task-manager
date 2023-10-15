package edu.tasksproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import edu.tasksproject.modal.TodoList;

@EnableJpaRepositories
public interface TodoListRepository extends JpaRepository<TodoList, String> {
    public void deleteById(String id);

    @Query("FROM TodoList t WHERE t.task_id = :task_id")
    List<TodoList> findByTodoListTaskId(@Param("task_id") String taskId);

}
