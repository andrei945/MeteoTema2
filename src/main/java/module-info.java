module org.meteofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.junit.jupiter.api;

    opens ro.mta.se.lab to javafx.fxml;
    exports ro.mta.se.lab;
}