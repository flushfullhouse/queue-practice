import java.util.Scanner;

public class TaskScheduler {
    public static void main(String[] args) {
        QueueADT queue = new QueueADT(10); // max 10 tasks
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task");
            System.out.println("2. Run Next Task");
            System.out.println("3. View Next Task");
            System.out.println("4. View Queue Size");
            System.out.println("5. Display All Tasks");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID (number): ");
                    int task = sc.nextInt();
                    queue.enqueue(task);
                    System.out.println("Task " + task + " added.");
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        System.out.println("Running Task: " + queue.dequeue());
                    } else {
                        System.out.println("No tasks to run.");
                    }
                    break;
                case 3:
                    if (!queue.isEmpty()) {
                        System.out.println("Next Task: " + queue.peek());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Tasks in queue: " + queue.size());
                    break;
                case 5:
                    queue.display();
                    break;
                case 0:
                    System.out.println("Exiting Task Scheduler.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}