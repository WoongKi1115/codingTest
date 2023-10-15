package com.example.restfulapi.controller;

import com.example.restfulapi.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

}
