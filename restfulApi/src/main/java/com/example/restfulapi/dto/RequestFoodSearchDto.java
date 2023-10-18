package com.example.restfulapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 검색 api 매개변수 dto
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestFoodSearchDto {
    private String foodName;

    private String researchYear;

    private String makerName;

    private String foodCode;
}
