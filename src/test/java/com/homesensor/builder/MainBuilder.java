package com.homesensor.builder;

import com.homesensor.model.Main;

public class MainBuilder {

    private Float temperature = 0f;
    private Integer pressure = 0;
    private Integer humidity = 0;
    private Integer temperatureMinimum = 0;
    private Integer temperatureMaximum = 0;

    public static MainBuilder main() {
        return new MainBuilder();
    }

    public MainBuilder withTemperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    public MainBuilder withPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public MainBuilder withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public MainBuilder withTemperatureMinimum(Integer temperatureMinimum) {
        this.temperatureMinimum = temperatureMinimum;
        return this;
    }

    public MainBuilder withTemperatureMaximum(Integer temperatureMaximum) {
        this.temperatureMaximum = temperatureMaximum;
        return this;
    }

    public Main build() {
        return new Main(temperature, pressure, humidity, temperatureMinimum, temperatureMaximum);
    }
}
