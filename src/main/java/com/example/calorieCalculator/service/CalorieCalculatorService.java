package com.example.calorieCalculator.service;

import com.example.calorieCalculator.entity.CalorieRequest;
import com.example.calorieCalculator.entity.CalorieResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalorieCalculatorService {

    private static final double INCHES_IN_FOOT = 12.0;
    private static final double CM_PER_INCH = 2.54;

    public CalorieResponse calorieCalculator(CalorieRequest request) {
        double heightInCm = convertFeetToCm(request.getHeightInFeet());
        double bmr = calculateBMR(request.getGender(), request.getWeightInKg(), heightInCm, request.getAge());
        double maintenanceCalories = bmr * getActivityLevelMultiplier(request.getActivityLevel());
        double calorieDelta = getIntensityLevelDeficit(request.getIntensity());

        double resultCalories;

        switch (request.getGoal().toLowerCase()) {
            case "lose" -> resultCalories = maintenanceCalories - calorieDelta;
            case "gain" -> resultCalories = maintenanceCalories + calorieDelta;
            case "maintain" -> resultCalories = maintenanceCalories;
            default -> resultCalories = maintenanceCalories;
        }

        CalorieResponse response = new CalorieResponse();
        response.setCalories(round(resultCalories, 2));
        return response;
    }


    private double convertFeetToCm(double heightInFeet) {
        int feet = (int) heightInFeet;
        double inchesDecimal = (heightInFeet - feet) * 10; // Assume 5.8 = 5 feet 8 inches
        int inches = (int) Math.round(inchesDecimal);
        double totalInches = (feet * INCHES_IN_FOOT) + inches;
        return totalInches * CM_PER_INCH;
    }

    private double calculateBMR(String gender, double weightKg, double heightCm, int age) {
        if ("male".equalsIgnoreCase(gender)) {
            return 10 * weightKg + 6.25 * heightCm - 5 * age + 5;
        } else {
            return 10 * weightKg + 6.25 * heightCm - 5 * age - 161;
        }
    }

    private double getActivityLevelMultiplier(String level) {
        return switch (level.toLowerCase()) {
            case "sedentary" -> 1.2;
            case "lightly" -> 1.375;
            case "moderately" -> 1.55;
            case "very" -> 1.725;
            case "super" -> 1.9;
            default -> 1.2;
        };
    }

    private double getIntensityLevelDeficit(String intensity) {
        return switch (intensity.toLowerCase()) {
            case "low" -> 250;
            case "moderate" -> 500;
            case "high" -> 750;
            default -> 250;
        };
    }

    private double round(double value, int places) {
        return BigDecimal.valueOf(value)
                .setScale(places, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
