package edu.tasksproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.tasksproject.modal.Task;

public interface TaskRepository extends JpaRepository<Task, String> {
    public void deleteById(String id);
    public Optional<Task> findById(String id);
}
