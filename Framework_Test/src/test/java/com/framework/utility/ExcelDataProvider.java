package com.framework.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		
		File src=new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			
		System.out.println("Unable to read the file "+e.getMessage());
		} 
		
		}

	public String getstringdata(int sheet_index, int row_num, int col_num) {
		
		return wb.getSheetAt(sheet_index).getRow(row_num).getCell(col_num).getStringCellValue();
		
	}
	
	public String getstringdata(String sheet_name, int row_num, int col_num) {
		
		return wb.getSheet(sheet_name).getRow(row_num).getCell(col_num).getStringCellValue();
		
	}
	
    public Double getnumericdata(String sheet_name, int row_num, int col_num) {
		
    return wb.getSheet(sheet_name).getRow(row_num).getCell(col_num).getNumericCellValue();
	
		
	}
	
	
}
