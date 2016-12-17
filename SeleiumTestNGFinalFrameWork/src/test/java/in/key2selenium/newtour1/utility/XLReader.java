package in.key2selenium.newtour1.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XLReader {
	
	
	@DataProvider(name="newtours") //1
	public static String[][] storeTestData(Method tc) //3
			throws EncryptedDocumentException, InvalidFormatException, IOException {
	
		FileInputStream fis=new FileInputStream(".\\TestData\\NewtourTestData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet s1 = wb.getSheet("Sheet1");
		
		String testcaseName=tc.getName();  //4
		
			
		int arrayRowCount=getGivenTestCaseRowCount(testcaseName);
		int arrayCellCount=getGivenTestCaseCellCount(testcaseName);
		
		String[][] tdata=new String[arrayRowCount][arrayCellCount+1];
		int nrindex=0;
		
		int rowCount = s1.getPhysicalNumberOfRows();
		int count = 0;
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			Row r = s1.getRow(rowIndex);
			
			int nciindex=0;

			Cell c1 = r.getCell(1);
			Cell c2 = r.getCell(2);

			String secondCellData = c1.getStringCellValue();
			String thirdCellData = c2.getStringCellValue();

			if (thirdCellData.equalsIgnoreCase("Y") && secondCellData.equalsIgnoreCase(testcaseName)) {
				
				int cc=r.getPhysicalNumberOfCells();
				for(int cellIndex=3; cellIndex<cc;cellIndex++)
				{
					tdata[nrindex][nciindex++]=r.getCell(cellIndex).getStringCellValue();
					System.out.println(r.getCell(cellIndex).getStringCellValue());
				}
				
				tdata[nrindex][nciindex]=rowIndex+"";
				nrindex++;
			}
		}
		return tdata;
	}
	
	
	public static int getGivenTestCaseRowCount(String testcaseName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
	
		FileInputStream fis=new FileInputStream(".\\TestData\\NewtourTestData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet s1 = wb.getSheet("Sheet1");
		
		int rowCount = s1.getPhysicalNumberOfRows();
		int count = 0;
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			Row r = s1.getRow(rowIndex);

			Cell c1 = r.getCell(1);
			Cell c2 = r.getCell(2);

			String secondCellData = c1.getStringCellValue();
			String thirdCellData = c2.getStringCellValue();

			if (thirdCellData.equalsIgnoreCase("Y") && secondCellData.equalsIgnoreCase(testcaseName)) {
				count++;
			}
		}
		return count;
	}
	
	public static int getGivenTestCaseCellCount(String testcaseName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
	
		FileInputStream fis=new FileInputStream(".\\TestData\\NewtourTestData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet s1 = wb.getSheet("Sheet1");
		
		int rowCount = s1.getPhysicalNumberOfRows();
		int count = 0;
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			Row r = s1.getRow(rowIndex);

			Cell c1 = r.getCell(1);
			Cell c2 = r.getCell(2);

			String secondCellData = c1.getStringCellValue();
			String thirdCellData = c2.getStringCellValue();

			if (thirdCellData.equalsIgnoreCase("Y") && secondCellData.equalsIgnoreCase(testcaseName)) {
				return r.getPhysicalNumberOfCells()-3;
			}
		}
		return 0;
	}
	
	
	
	
	

}
