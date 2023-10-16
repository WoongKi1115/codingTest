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

    private String foodCode;

    private String groupName;

    private String foodName;

    private int researchYear;

    private String makerName;

    private int servingSize;

    private double calorie;

    private double protein;

    private double province;

    private double carbohydrate;

    private double sugers;

    private double salt;

    private double cholesterol;

    private double saturatedFattyAcids;

    private double transFat;

    private String refName;

    public static FoodNutrition of(String foodCode, String groupName, String foodName, int researchYear, String makerName,
                                   int servingSize, double calorie, double protein, double province, double carbohydrate,
                                   double sugers, double salt, double cholesterol, double saturatedFattyAcids, double transFat,
                                String refName) {
        return FoodNutrition.builder()
                .foodCode(foodCode)
                .groupName(groupName)
                .foodName(foodName)
                .researchYear(researchYear)
                .makerName(makerName)
                .servingSize(servingSize)
                .calorie(calorie)
                .protein(protein)
                .province(province)
                .carbohydrate(carbohydrate)
                .sugers(sugers)
                .salt(salt)
                .cholesterol(cholesterol)
                .saturatedFattyAcids(saturatedFattyAcids)
                .transFat(transFat)
                .refName(refName)
                .build();
    }
}

