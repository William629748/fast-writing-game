package com.fastwriting.util;

import com.fastwriting.model.GameStatistics;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Utility class for managing scene transitions and window navigation.
 * Implements the Singleton pattern to maintain a single instance throughout the application.
 *
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class SceneManager {

    /**
     * Singleton instance of SceneManager.
     */
    private static SceneManager instance;

    /**
     * The primary stage of the application.
     */
    private Stage primaryStage;

    /**
     * Game statistics shared between different screens.
     */
    private GameStatistics gameStatistics;

    /**
     * Width of the application window.
     */
    private static final double WINDOW_WIDTH = 800;

    /**
     * Height of the application window.
     */
    private static final double WINDOW_HEIGHT = 600;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private SceneManager() {
        // Private constructor for singleton
    }

    /**
     * Gets the singleton instance of SceneManager.
     *
     * @return the singleton instance
     */
    public static synchronized SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    /**
     * Sets the primary stage for the application.
     *
     * @param primaryStage the primary stage to set
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Gets the current game statistics.
     *
     * @return the current game statistics
     */
    public GameStatistics getGameStatistics() {
        return gameStatistics;
    }

    /**
     * Sets the game statistics to be shared between screens.
     *
     * @param gameStatistics the game statistics to set
     */
    public void setGameStatistics(GameStatistics gameStatistics) {
        this.gameStatistics = gameStatistics;
    }

    /**
     * Shows the main menu screen.
     */
    public void showMainMenuScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            primaryStage.setTitle("Fast Writing Game - Main Menu");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the game rules screen.
     */
    public void showRulesScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rules-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            primaryStage.setTitle("Fast Writing Game - Rules");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the main game screen.
     */
    public void showGameScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/game-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            primaryStage.setTitle("Fast Writing Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the statistics screen with game performance data.
     */
    public void showStatisticsScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statistics-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            primaryStage.setTitle("Fast Writing Game - Statistics");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the game over screen when the player loses.
     */
    public void showGameOverScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/gameover-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            primaryStage.setTitle("Fast Writing Game - Game Over");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches to a specific scene by loading the FXML file.
     *
     * @param fxmlPath the path to the FXML file
     * @param title the title for the window
     */
    public void switchScene(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}