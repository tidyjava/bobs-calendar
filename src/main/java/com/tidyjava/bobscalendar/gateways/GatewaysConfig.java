package com.tidyjava.bobscalendar.gateways;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewaysConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
