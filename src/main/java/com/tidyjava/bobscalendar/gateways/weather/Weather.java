package com.tidyjava.bobscalendar.gateways.weather;

public class Weather {
    private int temperature;
    private boolean rain;

    public Weather() {
    }

    public Weather(int temperature, boolean rain) {
        this.temperature = temperature;
        this.rain = rain;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isRain() {
        return rain;
    }

    public void setRain(boolean rain) {
        this.rain = rain;
    }
}
