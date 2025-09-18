package com.fastwriting.app;

import com.fastwriting.util.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class for the Fast Writing game.
 * This class extends Application and serves as the entry point for the JavaFX application.
 *
 * @author [Your Name]
 * @version 2.0
 * @since 2024
 */
public class Main extends Application {

    /**
     * Scene manager instance for handling window transitions.
     */
    private SceneManager sceneManager;

    /**
     * Starts the JavaFX application by initializing the scene manager and showing the main menu.
     *
     * @param stage the primary stage for this application
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Initialize scene manager with the primary stage
        sceneManager = SceneManager.getInstance();
        sceneManager.setPrimaryStage(stage);

        // Configure the primary stage
        stage.setTitle("Fast Writing Game");
        stage.setResizable(false);

        // Show the main menu as the starting screen
        sceneManager.showMainMenuScreen();
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