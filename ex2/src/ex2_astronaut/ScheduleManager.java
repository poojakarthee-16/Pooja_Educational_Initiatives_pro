/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2_astronaut;

/**
 *
 * @author HP
 */


import java.util.*;
import java.util.logging.Logger;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<ConflictObserver> observers;
    private static final Logger logger = LoggerUtil.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(ConflictObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Task existing, Task newTask) {
        for (ConflictObserver obs : observers) {
            obs.onConflict(existing, newTask);
        }
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (task.getStartTime().isBefore(t.getEndTime()) &&
                task.getEndTime().isAfter(t.getStartTime())) {
                logger.warning("Task conflict detected.");
                notifyObservers(t, task);
                return;
            }
        }
        tasks.add(task);
        Collections.sort(tasks);
        logger.info("Task added: " + task.getDescription());
        System.out.println("Task added successfully. No conflicts.");
    }

    public void removeTask(String description) {
        Task toRemove = null;
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                toRemove = t;
                break;
            }
        }
        if (toRemove != null) {
            tasks.remove(toRemove);
            logger.info("Task removed: " + description);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.forEach(System.out::println);
    }

    public void markTaskCompleted(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                t.markCompleted();
                logger.info("Task marked completed: " + description);
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    public void viewByPriority(String priority) {
        boolean found = false;
        for (Task t : tasks) {
            if (t.getPriority().equalsIgnoreCase(priority)) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("No tasks found with priority: " + priority);
    }
}
