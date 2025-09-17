/**
 * Module definition for the Fast Writing Game application.
 * Defines required modules and exported packages for JavaFX functionality.
 */
module fastwritinggame {
    requires javafx.controls;
    requires javafx.fxml;

    // Export packages for FXML reflection access
    exports com.fastwriting.app;
    exports com.fastwriting.controller;
    exports com.fastwriting.model;

    // Open packages for FXML reflection
    opens com.fastwriting.controller to javafx.fxml;
    opens com.fastwriting.app to javafx.fxml;
}