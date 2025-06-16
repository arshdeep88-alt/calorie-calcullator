package com.example.calorieCalculator.controller;

import com.example.calorieCalculator.entity.CalorieRequest;
import com.example.calorieCalculator.entity.CalorieResponse;
import com.example.calorieCalculator.service.CalorieCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalorieCalculatorController {

    @Autowired
    private CalorieCalculatorService calorieService;

    @PostMapping
    public ResponseEntity<CalorieResponse> calculate(@RequestBody CalorieRequest request) {
        CalorieResponse response = calorieService.calorieCalculator(request);
        return ResponseEntity.ok(response);
    }
}
