package com.tidyjava.bobscalendar.usecases.planfortoday;

import com.tidyjava.bobscalendar.domain.Code;
import com.tidyjava.bobscalendar.domain.CodeRepository;
import com.tidyjava.bobscalendar.gateways.weather.WeatherGateway;
import org.springframework.stereotype.Service;

@Service
public class PlanForTodayUseCase {
    private final CodeRepository codeRepository;
    private final WeatherGateway weatherGateway;

    public PlanForTodayUseCase(CodeRepository codeRepository, WeatherGateway weatherGateway) {
        this.codeRepository = codeRepository;
        this.weatherGateway = weatherGateway;
    }

    public Activity get() {
        Code code = codeRepository.get();

        if (code.isMessy()) {
            return Activity.CLEAN_CODE;
        } else if (itsWarmEnoughForBob()) {
            return Activity.REST_ON_THE_BEACH;
        } else {
            return Activity.LEARN;
        }
    }

    private boolean itsWarmEnoughForBob() {
        return weatherGateway.getTemperature() > 20;
    }
}
