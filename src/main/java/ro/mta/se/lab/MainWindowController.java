package ro.mta.se.lab;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import com.google.gson.JsonParser;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ro.mta.se.lab.API.openWeatherMap;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class MainWindowController {
    @FXML
    Button selectButton;
    @FXML
    ComboBox country_list_combo;
    @FXML
    ComboBox city_list_combo;

    boolean button_pressed;

    private static openWeatherMap wapi;
    private static File locationsNameList;

    public MainWindowController()
    {
        locationsNameList = null;
        wapi = null;
    }

    @FXML
    public void initialize() {
        country_list_combo.setVisible(false);
        city_list_combo.setVisible(false);
        button_pressed = false;
    }

    public static void StartWeatherAPI()
    {
        wapi = new openWeatherMap();
        locationsNameList = new File("./src/main/java/ro/mta/se/lab/locationsData.txt");

        if (locationsNameList == null)
        {
            System.out.println("File not found");
        }

        try{
            Scanner reader = new Scanner(locationsNameList);
            String data;
           while (reader.hasNextLine())
           {
               data = reader.nextLine();
           }

            reader.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    public void onClickSelectButton(MouseEvent mouseEvent) {
        if (button_pressed == true)
        {
            button_pressed = false;
            selectButton.setText("Select");
            country_list_combo.setVisible(false);
            city_list_combo.setVisible(false);

        }
        else{
            button_pressed = true;
            selectButton.setText("OK");
            country_list_combo.setVisible(true);
            city_list_combo.setVisible(true);
        }

        //wapi.fetchWeatherData("London", "uk");


    }
}
