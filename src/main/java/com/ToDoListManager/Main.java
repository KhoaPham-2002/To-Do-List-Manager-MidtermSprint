//Name: Khoa Pham
//Project: Midterm Sprint (To-Do List Manager)
//Date: 06/26/2025

package src.main.java.com.ToDoListManager;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Create new user");
            System.out.println("2. Add task to user");
            System.out.println("3. Mark task as completed");
            System.out.println("4. View user tasks");
            System.out.println("5. View all users");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = getIntInput();

            switch (choice) {
                case 1 -> createUser();
                case 2 -> addTaskToUser();
                case 3 -> completeUserTask();
                case 4 -> viewUserTasks();
                case 5 -> listAllUsers();
                case 6 -> {
                    System.out.println("Goodbye! Thank you for using the To-Do List Manager.");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void createUser() {
        System.out.print("Enter new user name: ");
        scanner.nextLine(); 
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("User name cannot be empty.");
            return;
        }
        if (findUserByName(name) != null) {
            System.out.println("A user with that name already exists.");
            return;
        }
        users.add(new User(name));
        System.out.println("User \"" + name + "\" created.");
    }

    private static void addTaskToUser() {
        User user = selectUser();
        if (user == null) return;
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();
        if (description.isEmpty()) {
            System.out.println("Task cannot be empty.");
            return;
        }
        user.addTask(description);
        System.out.println("Task added to " + user.getName() + "'s list.");
    }

    private static void completeUserTask() {
        User user = selectUser();
        if (user == null) 
            return;
        if (user.hasNoTasks()) {
            System.out.println("No tasks to complete.");
            return;
        }
        user.printTasks();
        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = getIntInput();
        user.markTaskAsCompleted(taskNumber);
    }

    private static void viewUserTasks() {
        User user = selectUser();
        if (user != null) {
            user.printTasks();
        }
    }

    private static void listAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users created yet.");
            return;
        }
        System.out.println("List of users:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getName());
        }
    }

    private static User selectUser() {
        System.out.print("Enter user name: ");
        scanner.nextLine(); 
        String name = scanner.nextLine().trim();
        User user = findUserByName(name);
        if (user == null) {
            System.out.println("User not found.");
        }
        return user;
    }

    private static User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}
