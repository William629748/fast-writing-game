package com.fastwriting.controller;

import com.fastwriting.util.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the game rules interface.
 * Displays game instructions and handles navigation back to the main menu.
 *
 * @author [William Rooselbelt May Barreto]
 * @version 1.0
 * @since 2025
 */
public class RulesController implements Initializable {

    /**
     * FXML text area component that displays the game rules and instructions.
     * Connected to the FXML file through fx:id="rulesTextArea".
     */
    @FXML
    private TextArea rulesTextArea;

    /**
     * FXML scroll pane component that allows scrolling through the rules text.
     * Connected to the FXML file through fx:id="rulesScrollPane".
     */
    @FXML
    private ScrollPane rulesScrollPane;

    /**
     * FXML button component to return to the main menu.
     * Connected to the FXML file through fx:id="backToMenuButton".
     */
    @FXML
    private Button backToMenuButton;

    /**
     * FXML button component to start playing the game directly.
     * Connected to the FXML file through fx:id="startGameButton".
     */
    @FXML
    private Button startGameButton;

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
        sceneManager = SceneManager.getInstance();
        setupRulesContent();
        setupUI();
    }

    /**
     * Sets up the game rules content in the text area.
     */
    private void setupRulesContent() {
        String rulesContent = """
                 FAST WRITING GAME - RULES & INSTRUCTIONS
                           \s
                            ===============================================================
                           \s
                            OBJECTIVE:
                            Type words and phrases correctly before time runs out. Advance through
                            levels to test your typing speed and accuracy!
                           \s
                            TIME LIMITS:
                            • Start with 20 seconds per level
                            • Every 5 levels completed: time decreases by 2 seconds
                            • Minimum time limit: 2 seconds per level
                           \s
                            DIFFICULTY LEVELS:
                            • Levels 1-10: Easy words (cat, dog, sun, moon...)
                            • Levels 11-20: Medium words (computer, technology, education...)
                            • Levels 21-30: Hard words (sophisticated, unprecedented...)
                            • Levels 31-40: Expert words (antidisestablishmentarianism...)
                            • Levels 41-50: Short phrases ("The quick brown fox jumps...")
                            • Levels 51+: Complex phrases (programming concepts, etc.)
                           \s
                            HOW TO PLAY:
                            1. A word or phrase appears on screen
                            2. Type it exactly as shown (case-sensitive!)
                            3. Press ENTER or click Submit when done
                            4. Must be completed before timer reaches zero
                           \s
                            SCORING SYSTEM:
                            • Correct answer: Advance to next level
                            • Wrong answer or timeout: Game Over
                            • No partial credit - must be 100% accurate
                           \s
                            CONTROLS:
                            • Type in the text field
                            • ENTER key or Submit button to confirm
                            • Restart button to start over
                            • End Game button to finish and view stats
                           \s
                            STATISTICS TRACKED:
                            • Final level reached
                            • Words attempted vs correct
                            • Accuracy percentage
                            • Typing speed (Words Per Minute)
                            • Session duration
                            • Performance rating
                           \s
                            TIPS FOR SUCCESS:
                            • Focus on accuracy over speed
                            • Pay attention to punctuation and capitalization
                            • Use proper typing technique with all fingers
                            • Don't panic when time gets low
                            • Practice regularly to improve
                           \s
                            PERFORMANCE RATINGS:
                            • Beginner Typist: Levels 1-9
                            • Intermediate Typist: Levels 10-19
                            • Advanced Typist: Levels 20-29
                            • Expert Typist: Levels 30-39
                            • Master Typist: Levels 40-49
                            • Legendary Typist: Level 50+
                           \s
                            ===============================================================
                           \s
                            Good luck and happy typing!
            """;

        rulesTextArea.setText(rulesContent);
    }

    /**
     * Sets up the UI components and styling.
     */
    private void setupUI() {
        // Make text area read-only and disable editing
        rulesTextArea.setEditable(false);
        rulesTextArea.setWrapText(true);

        // Set focus to the scroll pane for keyboard navigation
        rulesScrollPane.setFitToWidth(true);

        // Ensure buttons are properly styled
        backToMenuButton.requestFocus();
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

    /**
     * Handles start game button clicks to begin playing directly.
     * Called from FXML when the start game button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onStartGameButtonClicked(ActionEvent event) {
        sceneManager.showGameScreen();
    }
}