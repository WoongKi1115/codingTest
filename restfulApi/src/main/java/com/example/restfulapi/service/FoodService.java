package com.example.restfulapi.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class FoodService {
    public void insertData() throws IOException, InvalidFormatException {
        ClassPathResource resource = new ClassPathResource("data.xlsx");
        File file = resource.getFile();

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        // 각 행을 반복하며 데이터를 읽음
        for (Row row : sheet) {
            // 셀을 반복하며 데이터를 읽음
            for (Cell cell : row) {
                // 셀 값 출력
                System.out.print(cell.toString() + "\t");
            }
            System.out.println(); // 다음 행으로 이동
        }

    }
}
