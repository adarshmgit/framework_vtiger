package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/*This method will return the particular cell data
	 * @param sheetName,rownum, cellnum
	 * @throws Throwable
	 */
	public String getExcelsheetData(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream file=new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		return cell.getStringCellValue();


	}

	/*This method will return all the data in the sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */

	public Object[][] getExcelsheetData(String sheetName) throws Throwable {
		FileInputStream file=new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

	/*This method fetch the data from excel sheet based on the row and cell header values
	 * @param sheetName
	 * @param tcID
	 * @param headerValue
	 * @throws throwable
	 */
	public String getExcelData(String sheetName,String tcID,String headerValue) throws Throwable {
		FileInputStream file=new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int expectedRowNumber=0;
		for(int i=0;i<=lastRow;i++) {
			String TestCaseID=sheet.getRow(i).getCell(0).getStringCellValue();
			if(TestCaseID.equalsIgnoreCase(tcID)) {
				expectedRowNumber=i;
				break;
			}
		}
		expectedRowNumber--;
		int expectedColumnNumber=0;
		int lastCell=sheet.getRow(expectedRowNumber).getLastCellNum();
		for(int j=0;j<=lastCell;j++) {
			String columnValue=sheet.getRow(expectedRowNumber).getCell(j).getStringCellValue();
			if(columnValue.equalsIgnoreCase(headerValue)) {
				expectedColumnNumber=j;
				break;
			}
		}
		return sheet.getRow(expectedRowNumber+1).getCell(expectedColumnNumber).getStringCellValue();

	}
	
	public void writeExcelData(String sheetName,int rowNum,int column,String value) throws Throwable {
		  FileInputStream file=new FileInputStream(IPathConstants.EXCEL_PATH);
		  Workbook workbook=WorkbookFactory.create(file);
		  workbook.createSheet(sheetName).createRow(rowNum).createCell(column).setCellValue(value);
		  FileOutputStream writeFile=new FileOutputStream(IPathConstants.EXCEL_PATH);
		  workbook.write(writeFile);
		 }


}
