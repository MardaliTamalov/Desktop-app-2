module com.example.desktopapp2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.desktopapp2 to javafx.fxml;
    exports com.example.desktopapp2;
}