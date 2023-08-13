module com.example.javafinalproj {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.javafinalproj to javafx.fxml;
    exports com.example.javafinalproj;
}