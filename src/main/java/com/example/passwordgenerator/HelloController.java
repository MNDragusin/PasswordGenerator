package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class HelloController {
    @FXML
    protected Button copyBtn;
    @FXML
    private Label passwordLbl;

    @FXML
    private CheckBox upperCaseCheckBox;
    @FXML
    private CheckBox lowerCaseCheckBox;
    @FXML
    private CheckBox numbersCheckBox;
    @FXML
    private CheckBox specialCharactersCheckBox;

    @FXML
    private Slider chunkSizeSlider;
    @FXML
    private Slider numberOfChunksSlider;

    private String _currentgeneratedPassword;
    @FXML
    protected void onGenerateButtonClick() {
        var result = _generator.GenerateNewPassword(new Options(
                lowerCaseCheckBox.isSelected(),
                upperCaseCheckBox.isSelected(),
                numbersCheckBox.isSelected(),
                specialCharactersCheckBox.isSelected(),
                (int) chunkSizeSlider.getValue(),
                (int) numberOfChunksSlider.getValue()
        ));

        _currentgeneratedPassword = result;
        passwordLbl.setText(result);
        copyBtn.setVisible(true);
    }

    @FXML
    protected void onCopyBtn(){
        StringSelection stringSelection = new StringSelection(_currentgeneratedPassword);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private Generator _generator;

    public void initialize(){
        _generator = new Generator();
        copyBtn.setVisible(false);
        chunkSizeSlider.setMin(4);
        chunkSizeSlider.setMax(8);
        chunkSizeSlider.setBlockIncrement(1);
        chunkSizeSlider.setMajorTickUnit(1);
        chunkSizeSlider.setMinorTickCount(0);
        chunkSizeSlider.setShowTickMarks(true);
        chunkSizeSlider.setSnapToTicks(true);
        chunkSizeSlider.setShowTickLabels(true);

        numberOfChunksSlider.setMin(2);
        numberOfChunksSlider.setMax(5);
        numberOfChunksSlider.setBlockIncrement(1);
        numberOfChunksSlider.setMajorTickUnit(1);
        numberOfChunksSlider.setMinorTickCount(0);
        numberOfChunksSlider.setShowTickMarks(true);
        numberOfChunksSlider.setSnapToTicks(true);
        numberOfChunksSlider.setShowTickLabels(true);

        upperCaseCheckBox.setSelected(true);
        lowerCaseCheckBox.setSelected(true);
        numbersCheckBox.setSelected(true);
        specialCharactersCheckBox.setSelected(true);
    }
}