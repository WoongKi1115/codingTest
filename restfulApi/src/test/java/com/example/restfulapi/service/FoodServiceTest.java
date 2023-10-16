package com.example.restfulapi.service;

import com.example.restfulapi.entity.FoodNutrition;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FoodServiceTest {

    @Test
    void insertData() {
        try {
            ClassPathResource resource = new ClassPathResource("data.xlsx");
            File file = resource.getFile();

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            // 각 행을 반복하며 데이터를 읽음
            for (Row row : sheet) {
                // 셀을 반복하며 데이터를 읽음
                String foodCode = row.getCell(2).getStringCellValue();
                String groupName = row.getCell(3).getStringCellValue();
                String foodName = row.getCell(5).getStringCellValue();
                int researchYear = Integer.parseInt(row.getCell(6).getStringCellValue());
                String makerName = row.getCell(7).getStringCellValue();
                int servingSize = Integer.parseInt(row.getCell(11).getStringCellValue());
                double calorie = Double.parseDouble(row.getCell(15).getStringCellValue());
                double protein =  Double.parseDouble(row.getCell(17).getStringCellValue());
                double province =  Double.parseDouble(row.getCell(18).getStringCellValue());
                double carbohydrate =  Double.parseDouble(row.getCell(19).getStringCellValue());
                double sugers =  Double.parseDouble(row.getCell(20).getStringCellValue());
                double salt =  Double.parseDouble(row.getCell(33).getStringCellValue());
                double cholesterol =  Double.parseDouble(row.getCell(67).getStringCellValue());
                double saturatedFattyAcids =  Double.parseDouble(row.getCell(68).getStringCellValue());
                double transFat = Double.parseDouble(row.getCell(92).getStringCellValue());
                String refName = row.getCell(98).getStringCellValue();
                FoodNutrition food = FoodNutrition.of(foodCode, groupName, foodName, researchYear, makerName, servingSize, calorie, protein, province,
                        carbohydrate, sugers, salt, cholesterol, saturatedFattyAcids, transFat, refName);
                System.out.println("food.getFoodName() = " + food.getFoodName());
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace(); // 예외 정보 출력
        }
    }
}