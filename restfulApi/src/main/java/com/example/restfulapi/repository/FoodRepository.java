package com.example.restfulapi.repository;

import com.example.restfulapi.entity.FoodNutrition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodNutrition, Long> {
}
