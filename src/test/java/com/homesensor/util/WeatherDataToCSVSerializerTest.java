package com.homesensor.util;

import com.homesensor.model.WeatherData;
import org.junit.Test;

import static com.homesensor.builder.MainBuilder.main;
import static com.homesensor.builder.WeatherDataBuilder.data;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WeatherDataToCSVSerializerTest {

    @Test
    public void shouldTransformWeatherDataToCSV() {
        WeatherDataToCSVSerializer weatherDataToCsvSerializer = new WeatherDataToCSVSerializer();

        String weatherDataAsCSV = weatherDataToCsvSerializer.serialize(testWeatherData());

        assertThat(weatherDataAsCSV, is("London,20.66,1018,56,19,22"));
    }

    private WeatherData testWeatherData() {
        return data()
                .withName("London")
                .withMain(main()
                        .withTemperature(20.66F)
                        .withPressure(1018)
                        .withHumidity(56)
                        .withTemperatureMinimum(19)
                        .withTemperatureMaximum(22)
                        .build())
                .build();
    }
}
