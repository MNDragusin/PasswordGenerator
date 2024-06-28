package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox upperCaseCheckBox;
    @FXML
    private CheckBox lowerCaseCheckBox;
    @FXML
    private CheckBox numbersCheckBox;
    @FXML
    private CheckBox specialCharactersCheckBox;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(){
        upperCaseCheckBox.setSelected(true);
        lowerCaseCheckBox.setSelected(true);
        numbersCheckBox.setSelected(true);
        specialCharactersCheckBox.setSelected(true);
    }
}