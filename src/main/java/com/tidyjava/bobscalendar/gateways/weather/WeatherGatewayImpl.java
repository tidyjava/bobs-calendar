package com.tidyjava.bobscalendar.gateways.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherGatewayImpl implements WeatherGateway {
    private final RestTemplate restTemplate;
    private final String weatherApiUrl;

    public WeatherGatewayImpl(RestTemplate restTemplate, @Value("${weather.api.url}") String weatherApiUrl) {
        this.restTemplate = restTemplate;
        this.weatherApiUrl = weatherApiUrl;
    }

    @Override
    public int getTemperature() {
        return restTemplate.getForObject(weatherApiUrl + "/weather", Weather.class).getTemperature();
    }
}
