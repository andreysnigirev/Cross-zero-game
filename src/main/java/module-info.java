module com.example.crosszero {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.crosszero to javafx.fxml;
    exports com.example.crosszero;
}