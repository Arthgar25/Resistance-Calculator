package com.example.resistancecalculator;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class Color extends VBox {
    private Label label;
    private Rectangle rectangle;
    private ComboBox<String> comboBox;
    public Color(String posicion) {
        label = new Label();
        rectangle = new Rectangle();
        comboBox = new ComboBox<>();
        label.setText(posicion);
        getChildren().addAll(label, rectangle, comboBox);
    }
}
