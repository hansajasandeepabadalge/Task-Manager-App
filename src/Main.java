import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. List Task");
            System.out.println("4. Save Task");
            System.out.println("5. Load Task");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    manager.addTask(taskName);
                    break;
                case 2:
                    System.out.print("Enter task id: ");
                    int index = scanner.nextInt() - 1;
                    manager.deleteTask(index);
                    break;
                case 3:
                    manager.listTasks();
                    break;
                case 4:
                    System.out.print("Enter file to save: ");
                    String saveFile = scanner.nextLine();
                    manager.saveToFile(saveFile);
                    break;
                case 5:
                    System.out.print("Enter file to load: ");
                    String loadFile = scanner.nextLine();
                    manager.loadFromFile(loadFile);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}