public class CurrentConditionDisplay implements Observer, DisplayElement {
	private float temp, humidity;

	private Subject weatherData;

	public CurrentConditionDisplay(Subject weather) {
		weatherData = weather;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Conditicion Temp " + temp + " f degrees and "
				+ humidity + "% humidity");

	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		display();

	}

}
