package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class Excel {
	public String fetchExcelData(String path, String sheet, int rownumber, int columnnumber) throws FileNotFoundException {
		
	
		try{
			FileInputStream fi= new FileInputStream(path);
			Workbook wb= new XSSFWorkbook(fi);
			Sheet sheetdata= wb.getSheet(sheet);
			Row rowdata= sheetdata.getRow(rownumber);
			Cell celldata= rowdata.getCell(columnnumber);
		String cellvalue= celldata.getStringCellValue();
		return cellvalue;
		}catch (Exception e)
		{
			e.getMessage();
			return null;
		}
		
		
	}

}
