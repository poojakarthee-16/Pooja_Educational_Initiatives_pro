/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex1;

/**
 *
 * @author HP
 */
import java.util.*;

// Observer Interface
interface Observer {
    void update(float temperature);
}

// Subject
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void setTemperature(float temp) {
        this.temperature = temp;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(temperature);
        }
    }
}

// Concrete Observers
class MobileDisplay implements Observer {
    public void update(float temperature) {
        System.out.println("Mobile Display: Temperature is " + temperature + "°C");
    }
}

class WebDisplay implements Observer {
    public void update(float temperature) {
        System.out.println("Web Display: Temperature is " + temperature + "°C");
    }
}

// Demo
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        station.addObserver(new MobileDisplay());
        station.addObserver(new WebDisplay());

        station.setTemperature(28.5f);
        station.setTemperature(31.0f);
    }
}
