package com.example.resistancecalculator;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBand extends VBox {
    private Label label;
    private Rectangle rectangle;
    private ComboBox<ResistorColor> comboBox;

    public ColorBand(String position) {
        label = new Label(position);

        rectangle = new Rectangle(40, 40);
        rectangle.setStroke(Color.BLACK);

        // Create ComboBox with observable list
        comboBox = new ComboBox<>(FXCollections.observableArrayList(ResistorColor.values()));

        // Set default selection
        comboBox.setValue(ResistorColor.NONE);
        rectangle.setFill(ResistorColor.NONE.getFxColor());

        // Update rectangle whenever selection changes
        comboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                rectangle.setFill(newVal.getFxColor());
            }
        });

        getChildren().addAll(label, rectangle, comboBox);
        setSpacing(5);
    }

    public ComboBox<ResistorColor> getComboBox() {
        return comboBox;
    }
}
