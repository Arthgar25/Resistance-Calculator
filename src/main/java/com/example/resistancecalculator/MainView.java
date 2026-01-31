package com.example.resistancecalculator;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MainView extends HBox {
    private ColorBand firstColorBand;
    private ColorBand secondColorBand;
    private ColorBand thirdColorBand;
    private ColorBand fourthColorBand;
    private ColorBand fifthColorBand;
    private ColorBand sixthColorBand;
    private Label result;

    public MainView() {
        setSpacing(12);
        setPadding(new Insets(8,12,8,12));
        setStyle("""
            -fx-border-color: #cfcfcf;
            -fx-border-radius: 8;
            -fx-background-radius: 8;
            -fx-background-color: #f9f9f9;
        """);

        firstColorBand = new ColorBand("First Color");
        secondColorBand = new ColorBand("Second Color");
        thirdColorBand = new ColorBand("Third Color");
        fourthColorBand = new ColorBand("Fourth Color");
        fifthColorBand = new ColorBand("Fifth Color");
        sixthColorBand = new ColorBand("Sixth Color");
        result = new Label("Result: ");

        firstColorBand.getComboBox().setOnAction(e -> updateResult());
        secondColorBand.getComboBox().setOnAction(e -> updateResult());
        thirdColorBand.getComboBox().setOnAction(e -> updateResult());
        fourthColorBand.getComboBox().setOnAction(e -> updateResult());
        fifthColorBand.getComboBox().setOnAction(e -> updateResult());
        sixthColorBand.getComboBox().setOnAction(e -> updateResult());

        getChildren().addAll(firstColorBand, secondColorBand, thirdColorBand, fourthColorBand, fifthColorBand, sixthColorBand, result);

    }

    private void updateResult() {
        ResistorColor c1 = firstColorBand.getComboBox().getValue();
        ResistorColor c2 = secondColorBand.getComboBox().getValue();
        ResistorColor c3 = thirdColorBand.getComboBox().getValue();
        ResistorColor c4 = fourthColorBand.getComboBox().getValue();
        ResistorColor c5 = fifthColorBand.getComboBox().getValue();
        ResistorColor c6 = sixthColorBand.getComboBox().getValue();
        String output = ResistorCalculator.calculate(c1, c2, c3, c4, c5, c6);
        result.setText(output);
    }
}
