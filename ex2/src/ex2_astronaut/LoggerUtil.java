/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2_astronaut;

/**
 *
 * @author HP
 */


import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    public static Logger getLogger(String className) {
        Logger logger = Logger.getLogger(className);
        try {
            FileHandler handler = new FileHandler("schedule.log", true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            logger.setUseParentHandlers(true);
        } catch (IOException e) {
            System.err.println("Logger initialization failed: " + e.getMessage());
        }
        return logger;
    }
}
