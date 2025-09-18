package com.fastwriting.controller;

import com.fastwriting.model.GameStatistics;
import com.fastwriting.util.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Controller class for the statistics interface.
 * Displays detailed game performance statistics and metrics.
 *
 * @author [William Rooselbelt May Barreto]
 * @version 1.0
 * @since 2025
 */
public class StatisticsController implements Initializable {

    /**
     * FXML label component that displays the final level reached.
     * Connected to the FXML file through fx:id="finalLevelLabel".
     */
    @FXML
    private Label finalLevelLabel;

    /**
     * FXML label component that displays the total words attempted.
     * Connected to the FXML file through fx:id="wordsAttemptedLabel".
     */
    @FXML
    private Label wordsAttemptedLabel;

    /**
     * FXML label component that displays the number of correct words.
     * Connected to the FXML file through fx:id="correctWordsLabel".
     */
    @FXML
    private Label correctWordsLabel;

    /**
     * FXML label component that displays the number of incorrect words.
     * Connected to the FXML file through fx:id="incorrectWordsLabel".
     */
    @FXML
    private Label incorrectWordsLabel;

    /**
     * FXML label component that displays the accuracy percentage.
     * Connected to the FXML file through fx:id="accuracyLabel".
     */
    @FXML
    private Label accuracyLabel;

    /**
     * FXML label component that displays the typing speed in WPM.
     * Connected to the FXML file through fx:id="wpmLabel".
     */
    @FXML
    private Label wpmLabel;

    /**
     * FXML label component that displays the performance rating.
     * Connected to the FXML file through fx:id="performanceRatingLabel".
     */
    @FXML
    private Label performanceRatingLabel;

    /**
     * FXML label component that displays the session duration.
     * Connected to the FXML file through fx:id="sessionDurationLabel".
     */
    @FXML
    private Label sessionDurationLabel;

    /**
     * FXML label component that displays the session start time.
     * Connected to the FXML file through fx:id="startTimeLabel".
     */
    @FXML
    private Label startTimeLabel;

    /**
     * FXML progress bar component that shows accuracy visually.
     * Connected to the FXML file through fx:id="accuracyProgressBar".
     */
    @FXML
    private ProgressBar accuracyProgressBar;

    /**
     * FXML button component to start a new game.
     * Connected to the FXML file through fx:id="playAgainButton".
     */
    @FXML
    private Button playAgainButton;

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

        if (gameStatistics != null) {
            displayStatistics();
        } else {
            displayEmptyStatistics();
        }
    }

    /**
     * Displays the game statistics on the interface.
     */
    private void displayStatistics() {
        // Display basic statistics
        finalLevelLabel.setText("Level " + gameStatistics.getFinalLevel());
        wordsAttemptedLabel.setText(String.valueOf(gameStatistics.getWordsAttempted()));
        correctWordsLabel.setText(String.valueOf(gameStatistics.getCorrectWords()));
        incorrectWordsLabel.setText(String.valueOf(gameStatistics.getIncorrectWords()));

        // Display calculated metrics
        double accuracy = gameStatistics.getAccuracyPercentage();
        accuracyLabel.setText(String.format("%.1f%%", accuracy));
        accuracyProgressBar.setProgress(accuracy / 100.0);

        wpmLabel.setText(String.format("%.1f WPM", gameStatistics.getWordsPerMinute()));
        performanceRatingLabel.setText(gameStatistics.getPerformanceRating());

        // Display session information
        long minutes = gameStatistics.getSessionDuration().toMinutes();
        long seconds = gameStatistics.getSessionDuration().toSecondsPart();
        sessionDurationLabel.setText(String.format("%d:%02d", minutes, seconds));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        startTimeLabel.setText(gameStatistics.getStartTime().format(formatter));

        // Style the performance rating based on level
        stylePerformanceRating();
    }

    /**
     * Displays empty statistics when no game data is available.
     */
    private void displayEmptyStatistics() {
        finalLevelLabel.setText("Level 0");
        wordsAttemptedLabel.setText("0");
        correctWordsLabel.setText("0");
        incorrectWordsLabel.setText("0");
        accuracyLabel.setText("0.0%");
        wpmLabel.setText("0.0 WPM");
        performanceRatingLabel.setText("No Game Played");
        sessionDurationLabel.setText("0:00");
        startTimeLabel.setText("--:--:--");
        accuracyProgressBar.setProgress(0);
    }

    /**
     * Applies appropriate styling to the performance rating based on the level achieved.
     */
    private void stylePerformanceRating() {
        if (gameStatistics == null) return;

        // Remove existing style classes
        performanceRatingLabel.getStyleClass().removeAll(
                "rating-beginner", "rating-intermediate", "rating-advanced",
                "rating-expert", "rating-master", "rating-legendary"
        );

        int level = gameStatistics.getFinalLevel();
        if (level >= 50) {
            performanceRatingLabel.getStyleClass().add("rating-legendary");
        } else if (level >= 40) {
            performanceRatingLabel.getStyleClass().add("rating-master");
        } else if (level >= 30) {
            performanceRatingLabel.getStyleClass().add("rating-expert");
        } else if (level >= 20) {
            performanceRatingLabel.getStyleClass().add("rating-advanced");
        } else if (level >= 10) {
            performanceRatingLabel.getStyleClass().add("rating-intermediate");
        } else {
            performanceRatingLabel.getStyleClass().add("rating-beginner");
        }
    }

    /**
     * Handles play again button clicks to start a new game.
     * Called from FXML when the play again button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onPlayAgainButtonClicked(ActionEvent event) {
        sceneManager.showGameScreen();
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