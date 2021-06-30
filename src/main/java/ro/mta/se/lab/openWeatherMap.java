package ro.mta.se.lab;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ro.mta.se.lab.DataModel.ForecastObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class openWeatherMap {
    //- - - - - - - - - - - - - - - - - - Properties - - - - - - - - - - - - - - - - - - - -
    private String apiKey = "c9dcebae7c4eac089ab15fcf2c1fad09";
    private String apiURL = "https://api.openweathermap.org/data/2.5/weather?q=";

    private Map<String, Object> map;
    private Map<String, Object> mainMap;
    private Map<String, Object> windMap;
    private Map<String, Object> cloudsMap;
    private Map<String, Object> weatherMap;

    public ForecastObject weather;
    //private Map<String, Object>

    //- - - - - - - - - - - - - - - - - - Behaviour - - - - - - - - - - - - - - - - - - - -

    //- - - - - - - - - - - - - - - - - - - - - Internal Clean and ParseJSON (using Gson)
    private Map<String, Object> jsonToMap(String str)
    {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }

    private void cleanData()
    {
        map.clear();
        mainMap.clear();
        windMap.clear();
        cloudsMap.clear();
        weatherMap.clear();
    }

    //- - - - - - - - - - - - - - - - - - - - - extracting API data
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

            map = jsonToMap(result.toString());
            this.mainMap = jsonToMap(map.get("main").toString());
            this.windMap = jsonToMap(map.get("wind").toString());
            this.cloudsMap = jsonToMap(map.get("clouds").toString());


            String jsonText = map.get("weather").toString();
            String[] weatherString = jsonText.substring(2,jsonText.length()-2).split(",");

            weatherMap = new HashMap<String, Object>();
            for (String temp : weatherString)
            {
                String[] mapEntry = temp.split("=");

                mapEntry[0].replaceAll("\\s+","");

                weatherMap.put(mapEntry[0], mapEntry[1]);
            }


        this.weather = new ForecastObject(windMap.get("speed").toString(), mainMap.get("humidity").toString(), mainMap.get("temp").toString(), weatherMap.get(" description").toString(), cloudsMap.get("all").toString(), CountryCode);
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        cleanData();
    }

    //- - - - - - - - - - - - - - - - - - - - - Constructor
    public openWeatherMap()
    {
        map = new HashMap<String, Object>();
    }

    public ForecastObject getWeather()
    {
        return weather;
    }
}
