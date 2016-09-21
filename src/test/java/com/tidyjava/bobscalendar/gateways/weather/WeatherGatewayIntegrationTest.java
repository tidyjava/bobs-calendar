package com.tidyjava.bobscalendar.gateways.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherGatewayIntegrationTest {

    @Autowired
    private WeatherGateway weatherGateway;

    @Test
    public void shouldBeSuccessful() throws Exception {
        weatherGateway.getTemperature();
    }
}
