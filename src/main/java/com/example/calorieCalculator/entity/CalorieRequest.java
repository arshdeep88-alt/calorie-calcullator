package com.example.calorieCalculator.entity;

public class CalorieRequest {
    private double weightInKg;
    private double heightInFeet;
    private int age;
    private String gender;

    private String activityLevel;// e.g., "sedentary", "lightly", "moderately", "very", "super"
    private String goal;// "maintain", "lose", "gain"
    private String intensity;//"low","moderate","high"

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public double getHeightInFeet() {
        return heightInFeet;
    }

    public void setHeightInFeet(double heightInFeet) {
        this.heightInFeet = heightInFeet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
}
