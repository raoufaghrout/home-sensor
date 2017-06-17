package com.homesensor;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.homesensor.util.JSONToWeatherDataDeserializer;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Optional;

public class WeatherDataHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = Logger.getLogger(WeatherDataHandler.class);

    private JSONToWeatherDataDeserializer jsonToWeatherDataDeserializer = new JSONToWeatherDataDeserializer();

    // Zero args constructor needed for serverless.
    public WeatherDataHandler() {}

    public WeatherDataHandler(JSONToWeatherDataDeserializer jsonToWeatherDataDeserializer) {
        this.jsonToWeatherDataDeserializer = jsonToWeatherDataDeserializer;
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        LOG.info("Received: " + input);
        Optional<String> optionalBody = Optional.ofNullable((String) input.get("body"));

        if (!optionalBody.isPresent()) {
            return returnBadRequestResponse(input);
        }

        jsonToWeatherDataDeserializer.deserialize(optionalBody.get());

        return returnOkResponse(input);
    }

    private ApiGatewayResponse returnBadRequestResponse(Map<String, Object> input) {
        Response responseBody = new Response("Bad Request - No body present in request.", input);
        return ApiGatewayResponse.builder()
                .setStatusCode(400)
                .setObjectBody(responseBody)
                .build();
    }

    private ApiGatewayResponse returnOkResponse(Map<String, Object> input) {
        Response responseBody = new Response("OK - Weather data processed.", input);
        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(responseBody)
                .build();
    }
}
