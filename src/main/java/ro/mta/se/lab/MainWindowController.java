package ro.mta.se.lab;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import com.google.gson.JsonParser;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ro.mta.se.lab.API.openWeatherMap;

import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowController {
    @FXML
    ChoiceBox country_list;
    @FXML
    ChoiceBox city_list;
    @FXML
    Button selectButton;

    boolean button_pressed;

    private static openWeatherMap wapi;

    public MainWindowController()
    {

    }

    @FXML
    public void initialize() {
        country_list.setVisible(false);
        city_list.setVisible(false);
        button_pressed = false;
    }

    public static void setWeatherAPI(openWeatherMap api)
    {
        wapi = api;
        wapi.fetchWeatherData("uk","London");
    }



    public void onClickSelectButton(MouseEvent mouseEvent) {
        if (button_pressed == true)
        {
            button_pressed = false;
            selectButton.setText("Select");
            country_list.setVisible(false);
            city_list.setVisible(false);

        }
        else{
            button_pressed = true;
            selectButton.setText("OK");
            country_list.setVisible(true);
            city_list.setVisible(true);
        }

        wapi.fetchWeatherData("London", "uk");


    }
}
