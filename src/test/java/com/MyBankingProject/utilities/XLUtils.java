package com.MyBankingProject.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

		public static FileInputStream fis;
		public static FileOutputStream fos;
		public static XSSFWorkbook workbook;
		public static XSSFSheet sheet;
		public static XSSFRow row;
		public static XSSFCell cell;
		
		public static int getRowCount(String xlFile, String xlShSeet) throws IOException
		{
			fis = new FileInputStream(xlFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlShSeet);
			int rowCount = sheet.getLastRowNum();
			workbook.close();
			fis.close();
			return rowCount;
		}
		
		public static int getCellCount(String xlFile, String xlShSeet, int rownum) throws IOException
		{
			fis = new FileInputStream(xlFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlShSeet);
			row = sheet.getRow(rownum);
			int cellCount = row.getLastCellNum();
			workbook.close();
			fis.close();
			return cellCount;	
		}

	   public static String getCellData(String xlFile, String xlShSeet, int rownum, int cellnum) throws IOException
	   {
		    fis = new FileInputStream(xlFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlShSeet);
			row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			String data;
			try
			{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
			}
			catch (Exception e) 
			{
				data ="";
			}
			workbook.close();
			fis.close();
			return data;
	   }
	   
	   public static void setCellData(String xlFile, String xlShSeet, int rownum, int cellnum, String data) throws IOException
	   {
		    fis = new FileInputStream(xlFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlShSeet);
			row = sheet.getRow(rownum); 
			cell = row.createCell(cellnum);
			cell.setCellValue(data);
			
			fos = new FileOutputStream(xlFile);
			workbook.write(fos);
			workbook.close();
			fis.close();
			fos.close();  
	   }

}
