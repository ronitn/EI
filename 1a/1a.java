import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature);
}

// Concrete Observer - Display
class TemperatureDisplay implements Observer {
    private String displayName;

    public TemperatureDisplay(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void update(float temperature) {
        System.out.println(displayName + " Display: Temperature updated to " + temperature + "°C");
    }
}

// Subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject - WeatherStation
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// The main class (without the public keyword)
class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        
        TemperatureDisplay display1 = new TemperatureDisplay("Display 1");
        TemperatureDisplay display2 = new TemperatureDisplay("Display 2");
        
        station.addObserver(display1);
        station.addObserver(display2);

        // Set temperatures and observe updates
        station.setTemperature(25.5f);
        station.setTemperature(28.3f);
        
        // Remove one display and update again
        station.removeObserver(display1);
        station.setTemperature(30.0f);
    }
}
