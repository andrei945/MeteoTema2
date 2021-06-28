package ro.mta.se.lab.API;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class openWeatherMap {
    private String apiKey = "c9dcebae7c4eac089ab15fcf2c1fad09";
    private String apiURL = "https://api.openweathermap.org/data/2.5/weather?q=";

    private Map<String, Object> map;


    public void fetchWeatherData(String CountryCode, String City)
    {
        apiURL = "https://api.openweathermap.org/data/2.5/weather?q=";
        apiURL += City + "," + CountryCode + "&appid=" + apiKey + "&units=metric";

        try{
            StringBuilder result = new StringBuilder();
            URL url = new URL(apiURL);
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String data;
            while((data=reader.readLine()) != null)
            {
                result.append(data);
            }

            reader.close();


        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public openWeatherMap()
    {
        map = new HashMap<String, Object>();
    }

    public void initAPI() {
    }
}
