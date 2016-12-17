package in.key2selenium.newtour1.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteXLExample {

	public static void WrtiteXML(String test,int rowNum,int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream(".\\TestData" + "\\NewtourTestData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet1");
		Row r=s.getRow(rowNum);
		Cell c=r.getCell(colNum);
		c.setCellValue("Pass");
		
		FileOutputStream fos=new FileOutputStream(".\\TestData" + "\\NewtourTestData.xlsx");
		wb.write(fos);
		fos.close();
		wb.close();

	}
	
	
	public static void main(String... args) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		WriteXLExample.WrtiteXML("Pass", 2, 16);
	}

}
