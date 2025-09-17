package com.fastwriting.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class for the Fast Writing game.
 * This class extends Application and serves as the entry point for the JavaFX application.
 *
 * @author [William Rooselbelt May Barreto]
 * @version 1.5.2
 * @since 2025
 */
public class Main extends Application {

    /**
     * The main stage of the application.
     */
    private Stage primaryStage;

    /**
     * Starts the JavaFX application by loading the main FXML file and setting up the stage.
     *
     * @param stage the primary stage for this application
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        // Add CSS styling
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        stage.setTitle("Fast Writing Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * The main method that launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}