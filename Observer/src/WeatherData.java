import java.util.ArrayList;

public class WeatherData implements Subject {

	private ArrayList<Observer> observers;
	private float temp, humidity, pressure;

	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(o);
		}

	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer ob = observers.get(i);
			ob.update(temp, humidity, pressure);
		}
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		this.humidity = humidity;
		this.temp = temp;
		this.pressure = pressure;
		measurementsChanged();
	}

}
