import model.Task;
import repository.TaskRepository;
import service.TaskService;

public class Main {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        // Add Tasks
        service.addTask("Buy groceries");
        service.addTask("Complete Java project");

        // print all tasks
        System.out.println("All tasks: ");
        for (Task task : service.getAllTasks()) {
            System.out.println(task.getId() + ": " + task.getDescription() + " - " + (task.isCompleted() ? "Completed" : "Not Completed"));
        }

        // complete a task
        service.completedTask(1);
        System.out.println("\nAfter Completing task 1");
        Task task = service.getTask(1);
        System.out.println(task.getId() + ": " + task.getDescription() + " - " + (task.isCompleted() ? "Completed" : "Not Completed"));

        // Delete a task
        service.deleteTask(2);
        System.out.println("\nAfter deleting task 2:");
        for (Task t : service.getAllTasks()) {
            System.out.println(t.getId() + ": " + t.getDescription() + " - " + (t.isCompleted() ? "Completed" : "Not Completed"));
        }
    }
}