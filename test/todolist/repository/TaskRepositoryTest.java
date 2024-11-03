package todolist.repository;

import model.Task;
import org.junit.jupiter.api.Test;
import repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {
    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
    }

    void testAddAndRetrieveTask() {
        Task task = new Task(1, "Sample task");
        repository.addTask(task);
        Task retrieved = repository.getTask(1);
        assertEquals("Sample task", retrieved.getDescription());
    }

    @Test
    void testGetAllTasks() {
        repository.addTask(new Task(1, "Task 1"));
        repository.addTask(new Task(2, "Task 2"));
        assertEquals(2, repository.getAllTasks().size());
    }

    @Test
    void testDeleteTask() {
        Task task = new Task(1, "Task to delete");
        repository.addTask(task);
        repository.deletedTask(1);
        assertNull(repository.getTask(1));
    }
}
