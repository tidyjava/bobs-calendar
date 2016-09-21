package com.tidyjava.bobscalendar.gateways.weather;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class WeatherGatewayImplTest {
    private static final String BASE_URL = "http://endpoint";
    private static final String WEATHER_ENDPOINT = "http://endpoint/weather";
    private static final int TEMPERATURE = 82;

    private RestTemplate restTemplate = mock(RestTemplate.class);
    private WeatherGateway weatherGateway = new WeatherGatewayImpl(restTemplate, BASE_URL);

    @Before
    public void setUp() throws Exception {
        given(restTemplate.getForObject(WEATHER_ENDPOINT, Weather.class)).willReturn(new Weather(TEMPERATURE, true));
    }

    @Test
    public void shouldReturnCorrectTemperature() throws Exception {
        assertEquals(TEMPERATURE, weatherGateway.getTemperature());
    }

    @Test
    public void shouldQueryCorrectEndpoint() throws Exception {
        weatherGateway.getTemperature();
        verify(restTemplate, times(1)).getForObject(WEATHER_ENDPOINT, Weather.class);
    }
}