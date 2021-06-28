package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.API.openWeatherMap;

import java.io.IOException;

public class Main extends Application {
    private static Scene scene;
    private MainWindowController controller;


    @Override
    public void start(Stage stage) throws IOException {


        scene = new Scene(loadFXML("MainWindow"));

        openWeatherMap wapi = new openWeatherMap();
        MainWindowController.setWeatherAPI(wapi);

        stage.setScene(scene);

        stage.setTitle("Meteo App");
        stage.setResizable(false); // fixed size

        stage.show();


    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        //handler = new FXMLLoader(fxmlLoader);
        return fxmlLoader.load();
    }




    public static void main(String[] args) throws IOException {
        launch(args);
       // setRoot("MainWindow");
    }

}
