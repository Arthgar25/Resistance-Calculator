package com.example.resistancecalculator;

import javafx.scene.paint.Color;

public enum ResistorColor {

    BLACK(0, 1.0, null, Color.BLACK),
    BROWN(1, 10.0, 1.0, Color.SADDLEBROWN),
    RED(2, 100.0, 2.0, Color.RED),
    ORANGE(3, 1_000.0, null, Color.ORANGE),
    YELLOW(4, 10_000.0, 5.0, Color.YELLOW),
    GREEN(5, 100_000.0, 0.5, Color.GREEN),
    BLUE(6, 1_000_000.0, 0.25, Color.BLUE),
    VIOLET(7, 10_000_000.0, 0.1, Color.VIOLET),
    GRAY(8, 100_000_000.0, 0.05, Color.GRAY),
    WHITE(9, 1_000_000_000.0, null, Color.WHITE),
    GOLD(null, 0.1, 5.0, Color.GOLD),
    SILVER(null, 0.01, 10.0, Color.SILVER),
    NONE(null, null, null, Color.TRANSPARENT); // unselected

    private final Integer digit;
    private final Double multiplier;
    private final Double tolerance;
    private final Color fxColor;

    ResistorColor(Integer digit, Double multiplier, Double tolerance, Color fxColor) {
        this.digit = digit;
        this.multiplier = multiplier;
        this.tolerance = tolerance;
        this.fxColor = fxColor;
    }

    public Integer getDigit() { return digit; }
    public Double getMultiplier() { return multiplier; }
    public Double getTolerance() { return tolerance; }
    public Color getFxColor() { return fxColor; }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
