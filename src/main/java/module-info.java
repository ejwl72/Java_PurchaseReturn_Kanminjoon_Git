module com.example.demo4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ControllerAndApplication to javafx.fxml;
    exports ControllerAndApplication;
}