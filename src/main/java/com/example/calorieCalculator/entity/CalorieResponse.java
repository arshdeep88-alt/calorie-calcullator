package com.example.calorieCalculator.entity;

public class CalorieResponse {
    private double maintenanceCalories;
    private double weightLossCalories;
    private double weightGainCalories;

    public double getMaintenanceCalories() {
        return maintenanceCalories;
    }

    public void setMaintenanceCalories(double maintenanceCalories) {
        this.maintenanceCalories = maintenanceCalories;
    }

    public double getWeightLossCalories() {
        return weightLossCalories;
    }

    public void setWeightLossCalories(double weightLossCalories) {
        this.weightLossCalories = weightLossCalories;
    }

    public double getWeightGainCalories() {
        return weightGainCalories;
    }

    public void setWeightGainCalories(double weightGainCalories) {
        this.weightGainCalories = weightGainCalories;
    }
}
