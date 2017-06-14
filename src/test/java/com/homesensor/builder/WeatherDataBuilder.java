package com.homesensor.builder;

import com.homesensor.model.WeatherData;
import com.homesensor.model.Main;

import static com.homesensor.builder.MainBuilder.main;

public class WeatherDataBuilder {

    private String name = "";
    private Main main = main().build();

    public static WeatherDataBuilder data() {
        return new WeatherDataBuilder();
    }

    public WeatherDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public WeatherDataBuilder withMain(Main main) {
        this.main = main;
        return this;
    }

    public WeatherData build() {
        return new WeatherData(name, main);
    }
}
