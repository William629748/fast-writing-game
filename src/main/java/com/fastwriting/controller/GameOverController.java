package com.fastwriting.controller;

import com.fastwriting.model.GameStatistics;
import com.fastwriting.util.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the game over interface.
 * Displays when the player loses the game and provides restart options.
 *
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class GameOverController implements Initializable {

    /**
     * FXML label component that displays the game over title.
     * Connected to the FXML file through fx:id="gameOverLabel".
     */
    @FXML
    private Label gameOverLabel;

    /**
     * FXML label component that displays the final level reached.
     * Connected to the FXML file through fx:id="finalLevelLabel".
     */
    @FXML
    private Label finalLevelLabel;

    /**
     * FXML label component that displays quick statistics summary.
     * Connected to the FXML file through fx:id="quickStatsLabel".
     */
    @FXML
    private Label quickStatsLabel;

    /**
     * FXML label component that displays an encouraging message.
     * Connected to the FXML file through fx:id="encouragementLabel".
     */
    @FXML
    private Label encouragementLabel;

    /**
     * FXML button component to restart the game immediately.
     * Connected to the FXML file through fx:id="restartButton".
     */
    @FXML
    private Button restartButton;

    /**
     * FXML button component to view detailed statistics.
     * Connected to the FXML file through fx:id="viewStatsButton".
     */
    @FXML
    private Button viewStatsButton;

    /**
     * FXML button component to return to the main menu.
     * Connected to the FXML file through fx:id="backToMenuButton".
     */
    @FXML
    private Button backToMenuButton;

    /**
     * Scene manager for navigation between windows.
     */
    private SceneManager sceneManager;

    /**
     * Game statistics data to display.
     */
    private GameStatistics gameStatistics;

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     *
     * @param location  the location used to resolve relative paths for the root object
     * @param resources the resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneManager = SceneManager.getInstance();
        gameStatistics = sceneManager.getGameStatistics();

        setupGameOverDisplay();
        restartButton.requestFocus();
    }

    /**
     * Sets up the game over display with statistics and encouraging messages.
     */
    private void setupGameOverDisplay() {
        if (gameStatistics != null) {
            displayStatistics();
            displayEncouragement();
        } else {
            displayDefaultMessages();
        }
    }

    /**
     * Displays the game statistics and performance information.
     */
    private void displayStatistics() {
        int finalLevel = gameStatistics.getFinalLevel();
        finalLevelLabel.setText("You reached Level " + finalLevel + "!");

        // Display quick statistics
        int correct = gameStatistics.getCorrectWords();
        int total = gameStatistics.getWordsAttempted();
        double accuracy = gameStatistics.getAccuracyPercentage();

        String statsText = String.format(
                "Words Correct: %d/%d | Accuracy: %.1f%% | Rating: %s",
                correct, total, accuracy, gameStatistics.getPerformanceRating()
        );
        quickStatsLabel.setText(statsText);
    }

    /**
     * Displays an encouraging message based on the player's performance.
     */
    private void displayEncouragement() {
        int level = gameStatistics.getFinalLevel();
        String message;

        if (level >= 50) {
            message = "LEGENDARY! You're a typing master! Amazing performance!";
        } else if (level >= 40) {
            message = "INCREDIBLE! Master level achieved! You're truly skilled!";
        } else if (level >= 30) {
            message = "EXCELLENT! Expert level reached! Outstanding typing!";
        } else if (level >= 20) {
            message = "GREAT JOB! Advanced level achieved! Keep practicing!";
        } else if (level >= 10) {
            message = "GOOD WORK! Intermediate level reached! You're improving!";
        } else if (level >= 5) {
            message = "NICE TRY! You're getting the hang of it! Don't give up!";
        } else {
            message = "KEEP PRACTICING! Everyone starts somewhere! Try again!";
        }

        encouragementLabel.setText(message);

        // Apply appropriate styling based on performance
        encouragementLabel.getStyleClass().removeAll(
                "encouragement-excellent", "encouragement-good", "encouragement-try-again"
        );

        if (level >= 30) {
            encouragementLabel.getStyleClass().add("encouragement-excellent");
        } else if (level >= 10) {
            encouragementLabel.getStyleClass().add("encouragement-good");
        } else {
            encouragementLabel.getStyleClass().add("encouragement-try-again");
        }
    }

    /**
     * Displays default messages when no game statistics are available.
     */
    private void displayDefaultMessages() {
        finalLevelLabel.setText("Game Over");
        quickStatsLabel.setText("No statistics available");
        encouragementLabel.setText("Try again to improve your typing skills!");
        encouragementLabel.getStyleClass().add("encouragement-try-again");
    }

    /**
     * Handles restart button clicks to start a new game immediately.
     * Called from FXML when the restart button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onRestartButtonClicked(ActionEvent event) {
        sceneManager.showGameScreen();
    }

    /**
     * Handles view statistics button clicks to see detailed performance data.
     * Called from FXML when the view stats button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onViewStatsButtonClicked(ActionEvent event) {
        sceneManager.showStatisticsScreen();
    }

    /**
     * Handles back to menu button clicks.
     * Called from FXML when the back to menu button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onBackToMenuButtonClicked(ActionEvent event) {
        sceneManager.showMainMenuScreen();
    }
}