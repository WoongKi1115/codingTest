package com.example.restfulapi.controller;

import com.example.restfulapi.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping
    ResponseEntity<?> insertData() throws IOException, InvalidFormatException {
        foodService.insertData();
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
}
