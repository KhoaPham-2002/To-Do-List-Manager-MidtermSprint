//Name: Khoa Pham
//Project: Midterm Sprint (To-Do List Manager)
//Date: 06/26/2025

package src.main.java.com.ToDoListManager;
public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        taskList.add(newTask);
    }

    public void markTaskAsCompleted(int taskNumber) {
        taskList.completeTaskByNumber(taskNumber);
    }

    public void printTasks() {
        System.out.println("Tasks for user: " + name);
        taskList.printAllTasks();
    }

    public int getTaskCount() {
        return taskList.getTaskCount();
    }

    public boolean hasNoTasks() {
        return taskList.isEmpty();
    }
}
