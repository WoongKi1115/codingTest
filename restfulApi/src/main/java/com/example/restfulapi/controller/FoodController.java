package com.example.restfulapi.controller;

import com.example.restfulapi.dto.RequestFoodSearchDto;
import com.example.restfulapi.entity.FoodNutrition;
import com.example.restfulapi.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/foods")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    /**
     * data.xslx에 있는 foodData 저장하는 api
     * @return
     */
    @PostMapping
    ResponseEntity<?> insertData() {
        foodService.insertData();
        return ResponseEntity.status(HttpStatus.CREATED).body("데이터 저장 완료");
    }

    /**
     * 매개변수를 받아 조건에 맞는 foodData 출력하는 api
     * @param dto
     * @return
     */
    @PostMapping("/nutritions")
    ResponseEntity<FoodNutrition> searchData(@RequestBody RequestFoodSearchDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(foodService.searchData(dto));
    }
}
