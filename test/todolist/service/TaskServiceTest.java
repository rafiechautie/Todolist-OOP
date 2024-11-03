package todolist.service;

import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TaskRepository;
import service.TaskService;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService service;
    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
        service = new TaskService(repository);
    }

    @Test
    void testAddTask() {
        service.addTask("Test task");
        assertEquals(1, repository.getAllTasks().size());
    }

    @Test
    void testCompleteTask() {
        service.addTask("Complete this task");
        service.completedTask(1);
        Task task = repository.getTask(1);
        assertTrue(task.isCompleted());
    }

    @Test
    void testDeleteTask() {
        service.addTask("Delete this task");
        service.deleteTask(1);
        assertNull(repository.getTask(1));
    }
}
