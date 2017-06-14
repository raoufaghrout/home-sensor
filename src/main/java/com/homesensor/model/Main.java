package com.homesensor.model;

public class Main {

    private final Float temperature;
    private final Integer pressure;
    private final Integer humidity;
    private final Integer temperatureMinimum;
    private final Integer temperatureMaximum;

    public Main(Float temperature, Integer pressure, Integer humidity, Integer temperatureMinimum, Integer temperatureMaximum) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temperatureMinimum = temperatureMinimum;
        this.temperatureMaximum = temperatureMaximum;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getTemperatureMinimum() {
        return temperatureMinimum;
    }

    public Integer getTemperatureMaximum() {
        return temperatureMaximum;
    }
}
