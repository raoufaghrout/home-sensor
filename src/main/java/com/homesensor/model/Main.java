package com.homesensor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    @JsonProperty("temp")
    private Float temperature;
    private Integer pressure;
    private Integer humidity;
    @JsonProperty("temp_min")
    private Integer temperatureMinimum;
    @JsonProperty("temp_max")
    private Integer temperatureMaximum;

    public Main() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Main main = (Main) o;

        if (temperature != null ? !temperature.equals(main.temperature) : main.temperature != null) return false;
        if (pressure != null ? !pressure.equals(main.pressure) : main.pressure != null) return false;
        if (humidity != null ? !humidity.equals(main.humidity) : main.humidity != null) return false;
        if (temperatureMinimum != null ? !temperatureMinimum.equals(main.temperatureMinimum) : main.temperatureMinimum != null)
            return false;
        return temperatureMaximum != null ? temperatureMaximum.equals(main.temperatureMaximum) : main.temperatureMaximum == null;
    }

    @Override
    public int hashCode() {
        int result = temperature != null ? temperature.hashCode() : 0;
        result = 31 * result + (pressure != null ? pressure.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (temperatureMinimum != null ? temperatureMinimum.hashCode() : 0);
        result = 31 * result + (temperatureMaximum != null ? temperatureMaximum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", temperatureMinimum=" + temperatureMinimum +
                ", temperatureMaximum=" + temperatureMaximum +
                '}';
    }
}
