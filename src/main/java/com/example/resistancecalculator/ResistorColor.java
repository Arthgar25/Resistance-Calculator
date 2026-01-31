package com.example.resistancecalculator;

public enum ResistorColor {
    BLACK(0, 1.0, null),
    BROWN(1, 10.0, 1.0),
    RED(2, 100.0, 2.0),
    ORANGE(3, 1_000.0, null),
    YELLOW(4, 10_000.0, null),
    GREEN(5, 100_000.0, 0.5),
    BLUE(6, 1_000_000.0, 0.25),
    VIOLET(7, 10_000_000.0, 0.1),
    GRAY(8, 100_000_000.0, 0.05),
    WHITE(9, 1_000_000_000.0, null),
    GOLD(null, 0.1, 5.0),
    SILVER(null, 0.01, 10.0);

    private final Integer digit;
    private final Double multiplier;
    private final Double tolerance;

    ResistorColor(Integer digit, Double multiplier, Double tolerance) {
        this.digit = digit;
        this.multiplier = multiplier;
        this.tolerance = tolerance;
    }

    public Integer getDigit() {
        return digit;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public Double getTolerance() {
        return tolerance;
    }

    public javafx.scene.paint.Color getFxColor() {
        return javafx.scene.paint.Color.valueOf(this.name());
    }
}
