package com.fastwriting.controller;

import com.fastwriting.util.SceneManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the main menu interface.
 * Handles navigation to different sections of the game application.
 *
 * @author [William Rooselbelt May Barreto]
 * @version 1.0
 * @since 2025
 */
public class MenuController implements Initializable {

    /**
     * FXML button component to start a new game.
     * Connected to the FXML file through fx:id="playButton".
     */
    @FXML
    private Button playButton;

    /**
     * FXML button component to view game rules.
     * Connected to the FXML file through fx:id="rulesButton".
     */
    @FXML
    private Button rulesButton;

    /**
     * FXML button component to exit the application.
     * Connected to the FXML file through fx:id="exitButton".
     */
    @FXML
    private Button exitButton;

    /**
     * FXML label component that displays the welcome message.
     * Connected to the FXML file through fx:id="welcomeLabel".
     */
    @FXML
    private Label welcomeLabel;

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
        setupWelcomeMessage();
    }

    /**
     * Sets up the welcome message and any initial UI configurations.
     */
    private void setupWelcomeMessage() {
        welcomeLabel.setText("Welcome to Fast Writing Game!\nTest your typing speed and accuracy!");
    }

    /**
     * Handles play button clicks to start a new game.
     * Called from FXML when the play button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onPlayButtonClicked(ActionEvent event) {
        sceneManager.showGameScreen();
    }

    /**
     * Handles rules button clicks to view game instructions.
     * Called from FXML when the rules button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onRulesButtonClicked(ActionEvent event) {
        sceneManager.showRulesScreen();
    }

    /**
     * Handles exit button clicks to close the application.
     * Called from FXML when the exit button is clicked.
     *
     * @param event the action event
     */
    @FXML
    private void onExitButtonClicked(ActionEvent event) {
        Platform.exit();
    }
}