package com.gapstar.lib;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	public XSSFWorkbook wb;
	public XSSFSheet sheet1;
	
	public ExcelDataConfig(String path)
	{
		try {
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public String getData(int sheetNo, int row, int col)
	{
		sheet1 = wb.getSheetAt(sheetNo);
		String data = sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetNo)
	{
		int row = wb.getSheetAt(sheetNo).getLastRowNum();
		row = row + 1;
		return row;
	}

}
