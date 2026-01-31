package com.example.resistancecalculator;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class MainView extends HBox {
        private Color primerColor;
    private Color segundoColor;
    private Color tercerColor;
    private Color cuartoColor;
    private Color quintoColor;

    public MainView() {
        setSpacing(12);
        setPadding(new Insets(8,12,8,12));
        setStyle("""
            -fx-border-color: #cfcfcf;
            -fx-border-radius: 8;
            -fx-background-radius: 8;
            -fx-background-color: #f9f9f9;
        """);

        primerColor = new Color("Primer Color");
        segundoColor = new Color("Segundo Color");
        tercerColor = new Color("Tercer Color");
        cuartoColor = new Color("Cuarto Color");
        quintoColor = new Color("Quinto Color");
        getChildren().addAll(primerColor,  segundoColor, tercerColor, cuartoColor, quintoColor);

    }
}
