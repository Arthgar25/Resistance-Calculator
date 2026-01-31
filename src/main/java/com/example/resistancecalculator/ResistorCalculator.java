package com.example.resistancecalculator;

import java.util.ArrayList;
import java.util.List;

public class ResistorCalculator {

    public static String calculate(ResistorColor... bands) {
        // Collect valid bands (ignore NONE/null)
        List<ResistorColor> valid = new ArrayList<>();
        for (ResistorColor b : bands) {
            if (b != null && b != ResistorColor.NONE) valid.add(b);
        }

        int n = valid.size();

        if (n < 4) return "Select at least 4 valid bands";

        // First two digits
        int firstDigit = valid.get(0).getDigit() != null ? valid.get(0).getDigit() : 0;
        int secondDigit = valid.get(1).getDigit() != null ? valid.get(1).getDigit() : 0;

        // Multiplier
        double multiplier = valid.get(2).getMultiplier() != null ? valid.get(2).getMultiplier() : 1.0;

        // Tolerance
        double tolerance = valid.get(3).getTolerance() != null ? valid.get(3).getTolerance() : 20.0;

        // Extra digit for 5 or 6 band resistor
        int thirdDigit = 0;
        if (n >= 5 && valid.get(4).getDigit() != null) {
            thirdDigit = valid.get(4).getDigit();
        }

        // Calculate resistance
        double resistance;
        if (n == 4) {
            resistance = (firstDigit * 10 + secondDigit) * multiplier;
        } else if (n == 5) {
            resistance = (firstDigit * 100 + secondDigit * 10 + thirdDigit) * multiplier;
        } else { // 6 bands, assume 5th is digit, 6th is tolerance if present
            resistance = (firstDigit * 100 + secondDigit * 10 + thirdDigit) * multiplier;
            // Optionally override tolerance if 6th band has tolerance
            if (valid.get(5).getTolerance() != null) {
                tolerance = valid.get(5).getTolerance();
            }
        }

        return String.format("%.2f Ω ±%.2f%% (%.2f - %.2f Ω)",
                resistance,
                tolerance,
                resistance * (1 - tolerance / 100),
                resistance * (1 + tolerance / 100));

    }
}
