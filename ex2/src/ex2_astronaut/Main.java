/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2_astronaut;

/**
 *
 * @author HP
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();

        // Observer to notify conflicts
        manager.addObserver((existing, newTask) ->
                System.out.println("Error: Task conflicts with existing task \"" +
                        existing.getDescription() + "\"."));

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Astronaut Daily Schedule Organizer ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Mark Task Completed");
            System.out.println("5. View Tasks by Priority");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter start time (HH:mm): ");
                        String start = sc.nextLine();
                        System.out.print("Enter end time (HH:mm): ");
                        String end = sc.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = sc.nextLine();
                        Task task = TaskFactory.createTask(desc, start, end, priority);
                        manager.addTask(task);
                        break;
                    case "2":
                        System.out.print("Enter task description to remove: ");
                        manager.removeTask(sc.nextLine());
                        break;
                    case "3":
                        manager.viewTasks();
                        break;
                    case "4":
                        System.out.print("Enter task description to mark completed: ");
                        manager.markTaskCompleted(sc.nextLine());
                        break;
                    case "5":
                        System.out.print("Enter priority level to filter: ");
                        manager.viewByPriority(sc.nextLine());
                        break;
                    case "6":
                        System.out.println("Exiting application. Goodbye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (ValidationException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}

