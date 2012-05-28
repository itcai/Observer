package me.itcai;

public class ForecastDisplay implements Observer, DisplayElement{
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherData weatherData;
	
	public ForecastDisplay(WeatherData weatherData) {
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
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
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
		lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}
}
