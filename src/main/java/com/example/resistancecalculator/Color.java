package com.example.resistancecalculator;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class Color extends VBox {
    private Label label;
    private Rectangle rectangle;
    private ComboBox<ResistorColor> comboBox;

    public Color(String posicion) {
        label = new Label();
        rectangle = new Rectangle();
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(ResistorColor.values());
        label.setText(posicion);
        getChildren().addAll(label, rectangle, comboBox);

        rectangle.setWidth(60);
        rectangle.setHeight(20);

        comboBox.getItems().addAll(ResistorColor.values());

        comboBox.setOnAction(e -> {
            ResistorColor selected = comboBox.getValue();
            if (selected != null) {
                rectangle.setFill(selected.getFxColor());
            }
        });

    }
}
