package com.homesensor.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homesensor.model.WeatherData;

import java.io.IOException;

public class JSONToWeatherDataDeserializer {

    public WeatherData deserialize(String jsonWeatherData) {
        ObjectMapper objectMapper = new ObjectMapper();

        WeatherData weatherData = null;

        try {
            weatherData = objectMapper.readValue(jsonWeatherData, WeatherData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherData;
    }
}
