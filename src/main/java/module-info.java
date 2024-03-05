module com.example.main1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.main1 to javafx.fxml;
    exports com.example.main1;
}