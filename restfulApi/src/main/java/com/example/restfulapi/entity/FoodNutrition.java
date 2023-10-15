package com.example.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodNutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String sampleId;

    private String foodCode;

    private String groupName;

    private String commercialProduct;

    private String foodName;

    private String researchYear;

    private String makerName;

    private String harvestTime;

    private String foodMajorCategory;

    private String foodMinerCategory;

    private int servingSize;

    private String unit;

    @Column(name = "total_content(g)")
    private Long totalContentG;

    @Column(name = "total_content(ml)")
    private Long totalContentMl;

    private double calorie;

    private double water;

    private double protein;

    private double province;

    private double carbohydrate;

    private double sugers;

    private double saccharose;

    private double glucose;

    private double fruitSuger;

    private double lactose;

    private double maltose;

    private double dietaryFiber;

    private double calcium;

    private double ironContent;

    private double magnesium;

    private double phosphorus;

    private double potassium;

    private double salt;

    private double zinc;

    private double copper;

    private double cholesterol;

    private double saturatedFattyAcids;

    private double transFat;

    private String refName;
}

