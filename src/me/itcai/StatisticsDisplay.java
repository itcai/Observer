package me.itcai;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	private WeatherData weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	/* (non-Javadoc)
	 * <p>Title:display</p>
	 * <p>Description:</p>
	 * @see me.itcai.DisplayElement#display()
	 */
	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}

	/* (non-Javadoc)
	 * <p>Title:update</p>
	 * <p>Description:</p>
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 * @see me.itcai.Observer#update(float, float, float)
	 */
	@Override
	public void update(float temperature, float humidity, float pressure) {
		tempSum += temperature;
		numReadings++;

		if (temperature > maxTemp) {
			maxTemp = temperature;
		}
 
		if (temperature < minTemp) {
			minTemp = temperature;
		}

		display();
	}
}
