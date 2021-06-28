package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowController {
    @FXML
    ChoiceBox country_list;
    @FXML
    ChoiceBox city_list;

    public MainWindowController()
    {

    }

    @FXML
    public void initialize() {
        country_list.setVisible(false);
        city_list.setVisible(false);
    }


}
