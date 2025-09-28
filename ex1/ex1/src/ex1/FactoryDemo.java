/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1;

/**
 *
 * @author HP
 */
// Product Interface
interface Notification {
    void notifyUser();
}

// Concrete Products
class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS Notification...");
    }
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification...");
    }
}

// Factory
class NotificationFactory {
    public Notification createNotification(String type) {
        if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        return null;
    }
}

// Demo
public class FactoryDemo {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification n1 = factory.createNotification("SMS");
        n1.notifyUser();

        Notification n2 = factory.createNotification("EMAIL");
        n2.notifyUser();
    }
}

