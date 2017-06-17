package com.homesensor;

import com.amazonaws.services.lambda.runtime.Context;
import com.homesensor.model.ApiGatewayResponse;
import com.homesensor.model.Response;
import com.homesensor.util.JSONToWeatherDataDeserializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherDataHandlerTest {

    @Mock private JSONToWeatherDataDeserializer jsonToWeatherDataDeserializer;

    @Mock private Context context;

    @InjectMocks
    private WeatherDataHandler weatherDataHandler = new WeatherDataHandler(jsonToWeatherDataDeserializer);

    @Test
    public void shouldReturn400BadRequestWhenNoRequestBodyIsPresent() {
        Map<String, Object> request = new HashMap<>();
        ApiGatewayResponse expectedResponse = buildResponse(400, "Bad Request - No body present in request.", request);

        ApiGatewayResponse actualResponse = weatherDataHandler.handleRequest(request, context);

        assertThat(actualResponse, is(expectedResponse));
    }

    @Test
    public void shouldNotDeserializeJSONToWeatherDataWhenNoRequestBodyIsPresent() {
        Map<String, Object> request = new HashMap<>();

        weatherDataHandler.handleRequest(request, context);

        verify(jsonToWeatherDataDeserializer, times(0)).deserialize(any());
    }

    @Test
    public void shouldReturn200OkWhenRequestBodyIsPresent() {
        String requestBody = "{}";
        Map<String, Object> request = new HashMap<>();
        request.put("body", requestBody);
        ApiGatewayResponse expectedResponse = buildResponse(200, "OK - Weather data processed.", request);

        ApiGatewayResponse actualResponse = weatherDataHandler.handleRequest(request, context);

        assertThat(actualResponse, is(expectedResponse));
    }

    @Test
    public void shouldDeserializeJSONToWeatherDataWhenRequestBodyIsPresent() {
        String requestBody = "{}";
        Map<String, Object> request = new HashMap<>();
        request.put("body", requestBody);

        weatherDataHandler.handleRequest(request, context);

        verify(jsonToWeatherDataDeserializer, times(1)).deserialize(requestBody);
    }

    private ApiGatewayResponse buildResponse(int httpStatusCode, String message, Map<String, Object> map) {
        return ApiGatewayResponse.builder()
                .setStatusCode(httpStatusCode)
                .setObjectBody(new Response(message, map))
                .build();
    }
}
