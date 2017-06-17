package com.homesensor.util;

import com.homesensor.model.WeatherData;

public class WeatherDataToCSVSerializer {

    public String serialize(WeatherData weatherData) {
        return weatherData.getName() + "," +
                weatherData.getMain().getTemperature() + "," +
                weatherData.getMain().getPressure() + "," +
                weatherData.getMain().getHumidity() + "," +
                weatherData.getMain().getTemperatureMinimum() + "," +
                weatherData.getMain().getTemperatureMaximum();
    }
}
