/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2_astronaut;

/**
 *
 * @author HP
 */


import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {

    public static Task createTask(String description, String start, String end, String priority)
            throws ValidationException {
        try {
            LocalTime startTime = LocalTime.parse(start);
            LocalTime endTime = LocalTime.parse(end);
            if (endTime.isBefore(startTime) || endTime.equals(startTime)) {
                throw new ValidationException("End time must be after start time.");
            }
            return new Task(description, startTime, endTime, priority);
        } catch (DateTimeParseException e) {
            throw new ValidationException("Invalid time format. Use HH:mm (e.g., 07:30).");
        }
    }
}

