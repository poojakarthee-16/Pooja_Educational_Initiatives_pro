/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2_astronaut;

/**
 *
 * @author HP
 */


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String priority;
    private boolean completed;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public Task(String description, LocalTime startTime, LocalTime endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void markCompleted() { this.completed = true; }

    @Override
    public int compareTo(Task other) {
        return this.startTime.compareTo(other.startTime);
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]%s",
                startTime.format(TIME_FORMATTER),
                endTime.format(TIME_FORMATTER),
                description,
                priority,
                completed ? " [Done]" : "");
    }
}
