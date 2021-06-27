module org.meteofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.meteofx to javafx.fxml;
    exports org.meteofx;
}