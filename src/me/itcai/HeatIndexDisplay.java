/**
 * @Title:HeatIndexDisplay.java
 * @Package:me.itcai
 * @Description:TODO
 * @Author Jason
 * @Email caihaiboy@gmail.com
 * @Date 2012-5-28 下午09:30:16
 * @Version V1.0
 */
package me.itcai;

/**
 * @ClassName:HeatIndexDisplay
 * @Description:TODO 
 * @Author Jason
 * @Email caihaiboy@gmail.com
 * @Date 2012-5-28 下午09:30:16
 *
 */
public class HeatIndexDisplay implements Observer, DisplayElement{
	float heatIndex = 0.0f;
	private WeatherData weatherData;
	
	public HeatIndexDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	private float computeHeatIndex(float t, float rh) {
        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
            (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
            (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
            (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *  
            (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
            (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +     
            0.000000000843296 * (t * t * rh * rh * rh)) -
            (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }

	/* (non-Javadoc)
	 * <p>Title:display</p>
	 * <p>Description:</p>
	 * @see me.itcai.DisplayElement#display()
	 */
	@Override
	public void display() {
		System.out.println("Heat index is " + heatIndex);
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
		heatIndex = computeHeatIndex(temperature, humidity);
		display();
	}
}
