package com.tidyjava.bobscalendar.usecases.planfortoday;

import com.tidyjava.bobscalendar.domain.Code;
import com.tidyjava.bobscalendar.domain.CodeRepository;
import com.tidyjava.bobscalendar.gateways.weather.WeatherGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanForTodayUseCaseIntegrationTest {

    @Autowired
    private CodeRepository codeRepository;
    @MockBean
    private WeatherGateway weatherGateway;
    @Autowired
    private PlanForTodayUseCase planForTodayUseCase;

    @Test
    public void shouldBeCleaningWhenCodeIsMessy() throws Exception {
        codeRepository.store(Code.totalMess());

        assertEquals(Activity.CLEAN_CODE, planForTodayUseCase.get());
    }

    @Test
    public void shouldBeRestingWhenCodeIsCleanAndItsWarm() throws Exception {
        codeRepository.store(Code.beauty());
        given(weatherGateway.getTemperature()).willReturn(21);

        assertEquals(Activity.REST_ON_THE_BEACH, planForTodayUseCase.get());
    }

    @Test
    public void shouldBeLearningWhenCodeIsCleanAndItsCold() throws Exception {
        codeRepository.store(Code.beauty());
        given(weatherGateway.getTemperature()).willReturn(20);

        assertEquals(Activity.LEARN, planForTodayUseCase.get());
    }
}