import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class TaskManager {
    private final List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String taskName) {
        tasks.add(new Task(taskName));
        System.out.println("Task added: " + taskName);
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removed = tasks.remove(index);
            System.out.println("Task deleted: " + removed.getName());
        } else {
            System.out.println("Invalid Task Index");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void saveToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Task task : tasks) {
                writer.write(task.getName() + "\n");
            }
            System.out.println("Tasks saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error while saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            tasks.clear();
            while ((line = reader.readLine()) != null) {
                addTask(line);
            }
            System.out.println("Tasks loaded from file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error while loading file: " + e.getMessage());
        }
    }
}
