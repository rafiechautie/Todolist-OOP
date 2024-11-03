package service;

import model.Task;
import repository.TaskRepository;

import java.util.List;

public class TaskService {
    private TaskRepository repository;

    public  TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(String description) {
        int id = repository.getAllTasks().size() + 1;
        Task newTask = new Task(id, description);
        repository.addTask(newTask);
    }

    public List<Task> getAllTasks() {
        return repository.getAllTasks();
    }

    public Task getTask(int id) {
        return repository.getTask(id);
    }

    public void completedTask(int id) {
        Task task = repository.getTask(id);
        if (task != null) {
            task.setCompleted(true);
        }
    }

    public void deleteTask(int id) {
        repository.deletedTask(id);
    }
}
