package com.example.resistancecalculator;

import java.util.ArrayList;
import java.util.List;

public class ResistorCalculator {

    public static String calculate(ResistorColor... bands) {
        // Filter out NONE/null bands
        List<ResistorColor> valid = new ArrayList<>();
        for (ResistorColor b : bands) {
            if (b != null && b != ResistorColor.NONE) valid.add(b);
        }

        int n = valid.size();
        if (n < 4) return "Select at least 4 valid bands";

        double resistance = 0;
        double tolerance = 20.0; // default if not set

        switch (n) {
            case 4 -> {
                // 4-band resistor: 1st + 2nd digits, 3rd multiplier, 4th tolerance
                int d1 = valid.get(0).getDigit() != null ? valid.get(0).getDigit() : 0;
                int d2 = valid.get(1).getDigit() != null ? valid.get(1).getDigit() : 0;
                double multiplier = valid.get(2).getMultiplier() != null ? valid.get(2).getMultiplier() : 1.0;
                tolerance = valid.get(3).getTolerance() != null ? valid.get(3).getTolerance() : 20.0;
                resistance = (d1 * 10 + d2) * multiplier;
            }
            case 5, 6 -> {
                // 5- or 6-band resistor: 1st + 2nd + 3rd digits, 4th multiplier, 5th tolerance
                int d1 = valid.get(0).getDigit() != null ? valid.get(0).getDigit() : 0;
                int d2 = valid.get(1).getDigit() != null ? valid.get(1).getDigit() : 0;
                int d3 = valid.get(2).getDigit() != null ? valid.get(2).getDigit() : 0;
                double multiplier = valid.get(3).getMultiplier() != null ? valid.get(3).getMultiplier() : 1.0;
                tolerance = valid.get(4).getTolerance() != null ? valid.get(4).getTolerance() : 20.0;
                resistance = (d1 * 100 + d2 * 10 + d3) * multiplier;
            }
        }

        // Include min-max range with tolerance
        return String.format("%.2f Ω ±%.2f%% (%.2f - %.2f Ω)",
                resistance,
                tolerance,
                resistance * (1 - tolerance / 100),
                resistance * (1 + tolerance / 100));
    }
}
