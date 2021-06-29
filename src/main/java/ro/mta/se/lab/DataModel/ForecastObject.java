package ro.mta.se.lab.DataModel;

import java.lang.invoke.CallSite;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ForecastObject {
    public String windSpeed;

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherStatus() {
        return weatherStatus;
    }

    public void setWeatherStatus(String weatherStatus) {
        this.weatherStatus = weatherStatus;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String humidity;
    public String temperature;
    public String weatherStatus;
    public String countryCode;
    public String date;
    public String time;
    public String dayOfWeek;

    public double cloudiness;
    public double sun;

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getSun() {
        return sun;
    }

    public void setSun(double sun) {
        this.sun = sun;
    }

    public ForecastObject(String windSpeed, String humidity, String temperature, String weatherStatus, String cloudsData, String countryCode)
    {
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.temperature = temperature;
        this.weatherStatus = weatherStatus;
        this.countryCode = countryCode;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEEE dd MMMMM yyyy", new Locale("en", countryCode));
        date = simpleDateFormat.format(new Date());

        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        dayOfWeek = new SimpleDateFormat("EEEE").format(d);


        cloudiness = Double.parseDouble(cloudsData);
        sun = 100 - cloudiness;

    }

}
