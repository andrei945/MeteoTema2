package ro.mta.se.lab.Test;

import org.junit.jupiter.api.Test;
import ro.mta.se.lab.DataModel.ForecastObject;
import ro.mta.se.lab.openWeatherMap;

import static org.junit.jupiter.api.Assertions.*;

class openWeatherMapTest {



    @Test
    void getWeather() {
        openWeatherMap api = new openWeatherMap();
        api.fetchWeatherData("RO", "Bucharest");

        ForecastObject testWeather = new ForecastObject("0.89","45.0", "33.12","clear sky","75","RO");
        assertEquals(testWeather.getHumidity(), api.getWeather().getHumidity());
        assertEquals(testWeather.getWeatherStatus(), api.getWeather().getWeatherStatus());
        assertEquals(testWeather.getTemperature(), api.getWeather().getTemperature());
    }


}