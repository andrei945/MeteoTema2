package ro.mta.se.lab;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;
import ro.mta.se.lab.DataModel.CityObject;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Double.parseDouble;


public class MainWindowController {

    //- - - - - - - - - - - - - - - - - - Properties - - - - - - - - - - - - - - - - - - - -
    //Containers
    @FXML
    GridPane grid;
    @FXML
    GridPane grid2;

    //Buttons
    @FXML
    Button selectButton;
    @FXML
    ImageView celsius_button;
    @FXML
    ImageView faren_button;

    //country and city list + display text
    @FXML
    ComboBox country_list_combo;
    @FXML
    ComboBox city_list_combo;
    @FXML
    Label city_label;
    @FXML
    Label country_label;

    //weather image + display text (for status)
    @FXML
    ImageView weatherIcon;
    @FXML
    Label weatherText;

    //data labels for weather
    @FXML
    Label temperature_label;
    @FXML
    Label humidity_label;
    @FXML
    Label windspeed_label;
    @FXML
    Label sun_label;

    //Date label
    @FXML
    Label date_label;

    //status variables
    boolean button_pressed;
    boolean celsius;

    //Controller General Purpose Variables
    private static openWeatherMap wapi;
    private static File locationsNameList;
    private static List<CityObject> cities;
    private static Set<String> countries;


    //- - - - - - - - - - - - - - - - - - Behaviour - - - - - - - - - - - - - - - - - - - -
    public MainWindowController()
    {
        locationsNameList = null;
        wapi = null;
        cities = null;
    }

    //- - - - - - - - - - - - - - - - - - - - - Internal Update an Modify GUI
    @FXML
    public void initialize() {
        country_list_combo.setVisible(false);
        city_list_combo.setVisible(false);
        button_pressed = false;
        celsius = true;

        grid.setHalignment(city_label, HPos.RIGHT);
        grid.setHalignment(country_label, HPos.RIGHT);
        grid2.setHalignment(weatherText, HPos.CENTER);

        grid.setFillWidth(city_label, true);
        grid.setFillWidth(country_label, true);
        grid2.setFillWidth(weatherText, true);

        city_label.setAlignment(Pos.CENTER_RIGHT);
        country_label.setAlignment(Pos.CENTER_RIGHT);
        weatherText.setAlignment(Pos.CENTER);

        country_list_combo.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                city_list_combo.getItems().clear();
                String countryCode = stringParser.revert(country_list_combo.getValue().toString());
                System.out.println(countryCode);

                for (CityObject temp : cities)
                {

                    if (temp.getCountryCode().equals(countryCode))
                    {
                        System.out.println(temp.getCountryCode());
                        city_list_combo.getItems().add(temp.getName());
                    }
                }


            }
        });

    }

    public static void StartWeatherAPI()
    {
        cities = new LinkedList<CityObject>();
        wapi = new openWeatherMap();
        locationsNameList = new File("./src/main/java/ro/mta/se/lab/locationsData.txt");

        if (locationsNameList == null)
        {
            System.out.println("File not found");
        }

        try{
            List<String> UniqueCountriesCodes = new LinkedList<String>();
            Scanner reader = new Scanner(locationsNameList);
            String data;
           while (reader.hasNextLine())
           {
               data = reader.nextLine();
               String[] splitter = data.split("\\s+");

               CityObject city = new CityObject(splitter[0], splitter[1], splitter[2], splitter[3], splitter[4]);
               cities.add(city);
               UniqueCountriesCodes.add(city.getCountryCode());

           }

            countries = new LinkedHashSet<String>(UniqueCountriesCodes);
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadInterface()
    {
        country_list_combo.getItems().clear();
        city_list_combo.getItems().clear();

        if (countries != null)
        {
            for (String temp : countries)
            {
                String country = stringParser.parse(temp);
                country_list_combo.getItems().add(country);
            }
        }


    }

    private void updateInterface(){



        city_label.setText(city_list_combo.getValue().toString());
        country_label.setText(country_list_combo.getValue().toString());

        temperature_label.setText(wapi.weather.getTemperature() + " ˚C");
        humidity_label.setText(wapi.weather.getHumidity()+"%");
        windspeed_label.setText(wapi.weather.getWindSpeed()+" MPH");
        sun_label.setText(wapi.weather.getSun() + "%");

        date_label.setText(wapi.weather.getDate());

        weatherText.setText(wapi.weather.getWeatherStatus());

        URI uri;
        if (weatherText.toString().contains("clear"))
        {
            uri = new File("./src/main/resources/ro/mta/se/lab/images/sunrise.png").toURI();
            weatherIcon.setImage(new Image(uri.toString()));
        }

        if (weatherText.toString().contains("broken"))
        {
            uri = new File("./src/main/resources/ro/mta/se/lab/images/broken.png").toURI();
            weatherIcon.setImage(new Image(uri.toString()));
        }

        if (weatherText.toString().contains("scatter") || weatherText.toString().contains("few"))
        {
            uri = new File("./src/main/resources/ro/mta/se/lab/images/cloud.png").toURI();
            weatherIcon.setImage(new Image(uri.toString()));
        }

        if (weatherText.toString().contains("overcast") || weatherText.toString().contains("rain"))
        {
            uri = new File("./src/main/resources/ro/mta/se/lab/images/rain.png").toURI();
            weatherIcon.setImage(new Image(uri.toString()));
        }

    }




    //- - - - - - - - - - - - - - - - - - - - - Event Listeners
    public void onClickSelectButton(MouseEvent mouseEvent) {
        if (button_pressed == true)
        {
            button_pressed = false;
            selectButton.setText("Select");
            country_list_combo.setVisible(false);
            city_list_combo.setVisible(false);

            wapi.fetchWeatherData(stringParser.revert(country_list_combo.getValue().toString()), city_list_combo.getValue().toString());

            updateInterface();
        }
        else{
            button_pressed = true;
            selectButton.setText("OK");
            country_list_combo.setVisible(true);
            country_list_combo.setPromptText("Select Country");
            city_list_combo.setVisible(true);
            city_list_combo.setPromptText("Select City");
            loadInterface();

        }

        //wapi.fetchWeatherData("London", "uk");


    }

    public void onActionCountryBox(ActionEvent actionEvent) {

    }

    public void onMouseClickCelsius(MouseEvent mouseEvent) {
        if (celsius == false)
        {
            celsius = true;
            temperature_label.setText(wapi.weather.getTemperature()+" ˚C");
        }

    }

    public void onMouseClickFaren(MouseEvent mouseEvent) {
        if (celsius == true)
        {
            double celsiusd = parseDouble(wapi.weather.getTemperature());

            celsius = false;
            double faren =  (celsiusd*9/5)+32;

            DecimalFormat df = new DecimalFormat("#.##");

            temperature_label.setText(df.format(faren)+" ˚F");
        }
    }
}
