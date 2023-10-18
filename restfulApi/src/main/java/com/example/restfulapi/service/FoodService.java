package com.example.restfulapi.service;

import com.example.restfulapi.dto.RequestFoodSearchDto;
import com.example.restfulapi.entity.FoodNutrition;
import com.example.restfulapi.entity.QFoodNutrition;
import com.example.restfulapi.repository.FoodRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodService {

    private final FoodRepository foodRepository;
    private final JPAQueryFactory queryFactory;

    /**
     * db에 엑셀 데이터 저장
     */
    @Transactional
    public void insertData() {
        try {
            // resources 폴더에 있는 엑셀 파일을 불러옴
            ClassPathResource resource = new ClassPathResource("data.xlsx");
            File file = resource.getFile();

            // poi 라이브러리를 활용해 시트, row 순으로 조회
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            // 0번 째 시트의 데이터 사용
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                // 가장 첫 줄은 column 명이므로 생략
                if (row.getRowNum() == 0) {
                    continue;
                }

                // foodcode, groupname 같은 데이터는 문자열로 저장
                // reasearchyear, calorie 같은 숫자데이터는 int, double 형식으로 저장
                // 숫자 형태로 저장될 곳에 어떤 값들은 "-", "1g 미만" 같은 문자열로 저장되어 있음.
                // 때문에 numberFormatException 예외가 발생할 경우 해당 값을 0 또는 0.0으로 저장시켜서
                // 에러가 발생하는 것을 막음.
                String foodCode = row.getCell(2).getStringCellValue();
                String groupName = row.getCell(3).getStringCellValue();
                String foodName = row.getCell(5).getStringCellValue();

                int researchYear;
                try {
                    researchYear = Integer.parseInt(row.getCell(6).getStringCellValue());
                } catch (NumberFormatException e) {
                    researchYear = 0;
                }
                String makerName = row.getCell(7).getStringCellValue();

                int servingSize;
                try {
                    servingSize = Integer.parseInt(row.getCell(11).getStringCellValue());
                } catch (NumberFormatException e) {
                    servingSize = 0;
                }
                double calorie;
                try {
                    calorie = Double.parseDouble(row.getCell(15).getStringCellValue());
                } catch (NumberFormatException e) {
                    calorie = 0.0;
                }
                double protein;
                try {
                    protein = Double.parseDouble(row.getCell(17).getStringCellValue());
                } catch (NumberFormatException e) {
                    protein = 0.0;
                }
                double province;
                try {
                    province = Double.parseDouble(row.getCell(18).getStringCellValue());
                } catch (NumberFormatException e) {
                    province = 0.0;
                }
                double carbohydrate;
                try {
                    carbohydrate = Double.parseDouble(row.getCell(19).getStringCellValue());
                } catch (NumberFormatException e) {
                    carbohydrate = 0.0;
                }
                double sugers;
                try {
                    sugers = Double.parseDouble(row.getCell(20).getStringCellValue());
                } catch (NumberFormatException e) {
                    sugers = 0.0;
                }

                double salt;
                try {
                    salt = Double.parseDouble(row.getCell(33).getStringCellValue());
                } catch (NumberFormatException e) {
                    salt = 0.0;
                }
                double cholesterol;
                try {
                    cholesterol = Double.parseDouble(row.getCell(67).getStringCellValue());
                } catch (NumberFormatException e) {
                    cholesterol = 0.0;
                }

                double saturatedFattyAcids;
                try {
                    saturatedFattyAcids = Double.parseDouble(row.getCell(68).getStringCellValue());
                } catch (NumberFormatException e) {
                    saturatedFattyAcids = 0.0;
                }

                double transFat;
                try {
                    transFat = Double.parseDouble(row.getCell(92).getStringCellValue());
                } catch (NumberFormatException e) {
                    transFat = 0.0;
                }
                String refName = row.getCell(98).getStringCellValue();

                // 저장한 변수를 db에 저장시킴.
                FoodNutrition food = FoodNutrition.of(foodCode, groupName, foodName, researchYear, makerName, servingSize, calorie, protein, province,
                        carbohydrate, sugers, salt, cholesterol, saturatedFattyAcids, transFat, refName);
                foodRepository.save(food);
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }


    /**
     * 식품 검색
     * @param dto
     * @return
     */
    public FoodNutrition searchData(RequestFoodSearchDto dto) {
        QFoodNutrition food = QFoodNutrition.foodNutrition;
        FoodNutrition foodNutrition = queryFactory.selectFrom(food)
                .where(food.foodName.eq(dto.getFoodName())
                        .and(food.researchYear.eq(Integer.parseInt(dto.getResearchYear())))
                        .and(food.makerName.eq(dto.getMakerName()))
                        .and(food.foodCode.eq(dto.getFoodCode())))
                .fetchOne();
        return foodNutrition;

    }
}
