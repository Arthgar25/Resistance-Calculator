package com.example.resistancecalculator;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends VBox {
    private HBox bandas;
    private VBox primerColor;
    private VBox segundoColor;
    private VBox tercerColor;
    private VBox cuartoColor;
    private VBox quintoColor;

    public MainView() {
        setSpacing(12);
        setPadding(new Insets(8,12,8,12));
        setStyle("""
            -fx-border-color: #cfcfcf;
            -fx-border-radius: 8;
            -fx-background-radius: 8;
            -fx-background-color: #f9f9f9;
        """);



    }
}
