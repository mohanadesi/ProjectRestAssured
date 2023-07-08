package com.sl.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TestReqRes_Excel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\mohan\\Course4\\GetRequestExcel.xlsx";
		String sheetName = "Sheet1";
		
		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);
			
			//Read data from Excel cells
			
			String C_ID = getDataFromCell(sheet, 1, 0);
            String expFirstName = getDataFromCell(sheet, 1, 1);
            String baseURL = "https://reqres.in";
            //String baseURL = getDataFromCell(sheet, 1, 2);
            
            RestAssured.baseURI = baseURL;

            Response response = RestAssured
                    .given()
                    .when()
                    .get("/api/users/" + C_ID);
            System.out.println(C_ID);
            System.out.println(response.asString());
            
            JsonPath jsonPath = response.jsonPath();
            String actFirstName = jsonPath.getString("data.first_name");
            System.out.println(actFirstName);
            System.out.println(expFirstName);
            if (expFirstName.equals(actFirstName)) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            
            workbook.close();
            file.close();
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static String getDataFromCell(Sheet sheet, int rowNumber, int columnNumber) {
		// TODO Auto-generated method stub
		Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(columnNumber);
        String cellValue;
        if (cell.getCellType() == CellType.STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            cellValue = String.valueOf((int) cell.getNumericCellValue());
        } else {
        	cellValue = "";
        }
        return cellValue;
	}

	
}
