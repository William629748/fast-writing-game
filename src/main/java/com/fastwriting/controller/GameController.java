package com.fastwriting.controller;

import com.fastwriting.model.GameStatistics;
import com.fastwriting.model.WordGenerator;
import com.fastwriting.util.SceneManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

/**
 * Controller class for the main game interface.
 * Handles game logic, user input validation, timer management, and level progression.
 *
 * @author [Your Name]
 * @version 3.0
 * @since 2024
 */
public class GameController implements Initializable {

    /**
     * FXML label component that displays the current word or phrase to be typed.
     * Connected to the FXML file through fx:id="wordDisplayLabel".
     */
    @FXML
    private Label wordDisplayLabel;

    /**
     * FXML text field component where users input their typed responses.
     * Connected to the FXML file through fx:id="inputTextField".
     */
    @FXML
    private TextField inputTextField;

    /**
     * FXML button component that users click to submit their typed input.
     * Connected to the FXML file through fx:id="submitButton".
     */
    @FXML
    private Button submitButton;

    /**
     * FXML button component that users click to restart the game.
     * Connected to the FXML file through fx:id="restartButton".
     */
    @FXML
    private Button restartButton;

    /**
     * FXML button component that users click to end the game and view statistics.
     * Connected to the FXML file through fx:id="endGameButton".
     */
    @FXML
    private Button endGameButton;

    /**
     * FXML button component that users click to return to the main menu.
     * Connected to the FXML file through fx:id="backToMenuButton".
     */
    @FXML
    private Button backToMenuButton;

    /**
     * FXML label component that displays the remaining time for the current level.
     * Connected to the FXML file through fx:id="timerLabel".
     */
    @FXML
    private Label timerLabel;

    /**
     * FXML label component that displays the current level and difficulty category.
     * Connected to the FXML file through fx:id="levelLabel".
     */
    @FXML
    private Label levelLabel;

    /**
     * FXML label component that displays feedback messages to the user.
     * Shows success, error, and instructional messages.
     * Connected to the FXML file through fx:id="feedbackLabel".
     */
    @FXML
    private Label feedbackLabel;

    /**
     * FXML progress bar component that shows game progression visually.
     * Updates based on current level advancement.
     * Connected to the FXML file through fx:id="progressBar".
     */
    @FXML
    private ProgressBar progressBar;

    /**
     * Word generator instance for obtaining random words and phrases.
     */
    private WordGenerator wordGenerator;

    /**
     * Timeline for the countdown timer.
     */
    private Timeline timeline;

    /**
     * Current level of the game.
     */
    private int currentLevel;

    /**
     * Remaining time for the current level.
     */
    private int remainingTime;

    /**
     * Initial time limit for each level.
     */
    private int timeLimit;

    /**
     * Current word or phrase to be typed.
     */
    private String currentWord;

    /**
     * Flag indicating if the game is currently active.
     */
    private boolean gameActive;

    /**
     * Game statistics tracker for performance analysis.
     */
    private GameStatistics gameStatistics;

    /**
     * Scene manager for navigation between windows.
     */
    private SceneManager sceneManager;

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     *
     * @param location  the location used to resolve relative paths for the root object
     * @param resources the resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordGenerator = new WordGenerator();
        gameStatistics = new GameStatistics();
        sceneManager = SceneManager.getInstance();
        initializeGame();
    }

    /**
     * Initializes the game to its starting state.
     * Resets level, time, and loads the first word.
     */
    private void initializeGame() {
        currentLevel = 1;
        timeLimit = 20;
        gameActive = true;

        // Reset game statistics
        gameStatistics = new GameStatistics();
        gameStatistics.setStartTime(LocalDateTime.now());

        updateLevelDisplay();
        loadNewWord();
        startTimer();

        inputTextField.setDisable(false);
        submitButton.setDisable(false);
        endGameButton.setDisable(false);
        inputTextField.requestFocus();

        // Set initial feedback message with CSS styling
        feedbackLabel.setText("Type the word above and press Enter or Submit!");
        feedbackLabel.getStyleClass().removeAll("feedback-success", "feedback-error");
        feedbackLabel.getStyleClass().add("feedback-neutral");
    }

    /**
     * Loads a new word or phrase for the current level.
     * Updates the display and clears the input field.
     */
    private void loadNewWord() {
        currentWord = wordGenerator.getRandomWord(currentLevel);
        wordDisplayLabel.setText(currentWord);
        inputTextField.clear();

        // Update progress bar based on current level (max 50 levels for visual purposes)
        double progress = Math.min(1.0, currentLevel / 50.0);
        progressBar.setProgress(progress);
    }

    /**
     * Starts the countdown timer for the current level.
     * The timer decreases every second and validates input when it reaches zero.
     */
    private void startTimer() {
        if (timeline != null) {
            timeline.stop();
        }

        remainingTime = timeLimit;
        updateTimerDisplay();

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> handleTimerTick()));
        timeline.setCycleCount(timeLimit);
        timeline.play();
    }

    /**
     * Handles timer tick events. Called every second during countdown.
     */
    private void handleTimerTick() {
        remainingTime--;
        updateTimerDisplay();

        if (remainingTime <= 0) {
            timeline.stop();
            String userInput = inputTextField.getText().trim();

            if (userInput.isEmpty()) {
                handleFailure("Time's up! No input provided.");
            } else if (!userInput.equals(currentWord)) {
                handleFailure("Time's up! Incorrect answer.");
            } else {
                handleSuccess();
            }
        }
    }

    /**
     * Updates the timer display with the current remaining time.
     * Changes styling based on remaining time.
     */
    private void updateTimerDisplay() {
        timerLabel.setText("Time: " + remainingTime + "s");

        // Remove existing timer style classes
        timerLabel.getStyleClass().removeAll("timer-warning", "timer-danger");

        // Apply appropriate styling based on remaining time
        if (remainingTime <= 5) {
            timerLabel.getStyleClass().add("timer-danger");
        } else if (remainingTime <= 10) {
            timerLabel.getStyleClass().add("timer-warning");
        }
    }

    /**
     * Updates the level display with current level information.
     */
    private void updateLevelDisplay() {
        String difficulty = wordGenerator.getDifficultyCategory(currentLevel);
        levelLabel.setText("Level: " + currentLevel + " (" + difficulty + ")");
    }

    /**
     * Validates the user's input against the current word.
     * Handles success and failure scenarios.
     */
    private void validateInput() {
        if (!gameActive) return;

        String userInput = inputTextField.getText();
        gameStatistics.incrementWordsAttempted();

        if (userInput.equals(currentWord)) {
            handleSuccess();
        } else {
            gameStatistics.incrementIncorrectWords();
            handleFailure("Incorrect! Try again.");
        }
    }

    /**
     * Handles successful word completion.
     * Advances to next level and adjusts difficulty.
     */
    private void handleSuccess() {
        currentLevel++;
        gameStatistics.incrementCorrectWords();
        gameStatistics.addTimeSpent(timeLimit - remainingTime);

        feedbackLabel.setText("Correct! Moving to level " + currentLevel +
                " (" + wordGenerator.getDifficultyCategory(currentLevel) + ")");
        feedbackLabel.getStyleClass().removeAll("feedback-error", "feedback-neutral");
        feedbackLabel.getStyleClass().add("feedback-success");

        // Increase difficulty every 5 levels until minimum time is reached
        if (currentLevel % 5 == 1 && currentLevel > 1 && timeLimit > 2) {
            timeLimit = Math.max(2, timeLimit - 2);
        }

        updateLevelDisplay();
        loadNewWord();
        startTimer();
    }

    /**
     * Handles input failure scenarios.
     * Stops the game and displays game over screen.
     *
     * @param message the failure message to display
     */
    private void handleFailure(String message) {
        gameActive = false;
        timeline.stop();

        gameStatistics.setEndTime(LocalDateTime.now());
        gameStatistics.setFinalLevel(currentLevel);

        // Navigate to Game Over screen
        sceneManager.setGameStatistics(gameStatistics);
        sceneManager.showGameOverScreen();
    }

    /**
     * Ends the game voluntarily and shows statistics.
     */
    private void endGameVoluntarily() {
        gameActive = false;
        if (timeline != null) {
            timeline.stop();
        }

        gameStatistics.setEndTime(LocalDateTime.now());
        gameStatistics.setFinalLevel(currentLevel);

        // Navigate to Statistics screen
        sceneManager.setGameStatistics(gameStatistics);
        sceneManager.showStatisticsScreen();
    }

    /**
     * Handles key press events on the input field.
     * Called from FXML when a key is pressed in the input field.
     *
     * @param event the key event
     */
    @FXML
    private void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            validateInput();
        }
    }

    /**
     * Handles submit button clicks.
     * Called from FXML when the submit button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onSubmitButtonClicked(ActionEvent event) {
        validateInput();
    }

    /**
     * Handles restart button clicks.
     * Called from FXML when the restart button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onRestartButtonClicked(ActionEvent event) {
        if (timeline != null) {
            timeline.stop();
        }
        initializeGame();
    }

    /**
     * Handles end game button clicks.
     * Called from FXML when the end game button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onEndGameButtonClicked(ActionEvent event) {
        endGameVoluntarily();
    }

    /**
     * Handles back to menu button clicks.
     * Called from FXML when the back to menu button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onBackToMenuButtonClicked(ActionEvent event) {
        if (timeline != null) {
            timeline.stop();
        }
        sceneManager.showMainMenuScreen();
    }
}