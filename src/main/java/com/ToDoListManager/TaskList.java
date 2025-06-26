//Name: Khoa Pham
//Project: Midterm Sprint (To-Do List Manager)
//Date: 06/26/2025

package src.main.java.com.ToDoListManager;
public class TaskList {
    private class Node {
        Task data;
        Node next;

        public Node(Task task) {
            this.data = task;
            this.next = null;
        }
    }

    private Node start;

    public TaskList() {
        start = null;
    }

    public void add(Task task) {
        Node node = new Node(task);
        if (start == null) {
            start = node;
        } else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void completeTaskByNumber(int taskNumber) {
        if (taskNumber <= 0) {
            System.out.println("Invalid task number. Must be 1 or higher.");
            return;
        }
        Node temp = start;
        int currentIndex = 1;
        while (temp != null) {
            if (currentIndex == taskNumber) {
                temp.data.markAsCompleted();
                System.out.println("Marked task as completed: " + temp.data.getDescription());
                return;
            }
            temp = temp.next;
            currentIndex++;
        }
        System.out.println("No task found at number " + taskNumber);
    }

    public void printAllTasks() {
        if (start == null) {
            System.out.println("No tasks available.");
            return;
        }
        Node current = start;
        int count = 1;
        while (current != null) {
            System.out.println(count + ") " + current.data);
            current = current.next;
            count++;
        }
    }

    public int getTaskCount() {
        int count = 0;
        Node temp = start;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return start == null;
    }
}
