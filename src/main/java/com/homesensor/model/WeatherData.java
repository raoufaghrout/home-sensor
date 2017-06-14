package com.homesensor.model;

public class WeatherData {

    private final String name;
    private final Main main;

    public WeatherData(String name, Main main) {
        this.name = name;
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }
}
