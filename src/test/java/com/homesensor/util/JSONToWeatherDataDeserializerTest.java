package com.homesensor.util;

import com.homesensor.model.WeatherData;
import org.junit.Test;

import static com.homesensor.builder.MainBuilder.main;
import static com.homesensor.builder.WeatherDataBuilder.data;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JSONToWeatherDataDeserializerTest {

    @Test
    public void shouldDeserializeJSONToWeatherData() {
        JSONToWeatherDataDeserializer jsonToWeatherDataDeserializer = new JSONToWeatherDataDeserializer();

        WeatherData actualWeatherData = jsonToWeatherDataDeserializer.deserialize(jsonWeatherData());

        assertThat(actualWeatherData, is(expectedWeatherData()));
    }

    private String jsonWeatherData() {
        return "{" +
                "  \"name\": \"London\"," +
                "  \"main\": {" +
                "    \"temp\": 18.08," +
                "    \"pressure\": 1025," +
                "    \"humidity\": 72," +
                "    \"temp_min\": 16," +
                "    \"temp_max\": 20" +
                "  }" +
                "}";
    }

    private WeatherData expectedWeatherData() {
        return data()
                .withName("London")
                .withMain(main()
                        .withTemperature(18.08F)
                        .withPressure(1025)
                        .withHumidity(72)
                        .withTemperatureMinimum(16)
                        .withTemperatureMaximum(20)
                        .build())
                .build();
    }
}
