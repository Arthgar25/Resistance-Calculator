module com.example.resistancecalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.resistancecalculator to javafx.fxml;
    exports com.example.resistancecalculator;
}