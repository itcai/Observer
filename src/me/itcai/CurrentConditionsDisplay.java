package me.itcai;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	/**
	 * <p>Title:</p>
	 * <p>Description:</p>
	 * @param weatherData
	 */
	public CurrentConditionsDisplay(Subject weatherData) {
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
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
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
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

}
