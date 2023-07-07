package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	
@DataProvider(name="fetchData")
public static String[][] readexcel() throws IOException {

	XSSFWorkbook workbook = new XSSFWorkbook("./testData/LoginSalesforce1.xlsx");

	XSSFSheet sheet = workbook.getSheetAt(0);
					
		int rowcount = sheet.getLastRowNum();
	 
		int cellcount = sheet.getRow(0).getLastCellNum();
	 
		String[][] data = new String[rowcount] [cellcount];
	 
	    for(int i=1; i<= rowcount; i++) 
	  
	    {
		
	    	XSSFRow row = sheet.getRow(i);
			
	    	for(int j=0; j< cellcount; j++) 
				
	    	{
				    String stringCellValue = row.getCell(j).getStringCellValue();
					
				    System.out.println(stringCellValue);
					
				    data[i-1][j] = stringCellValue;
		     }
		 }
		
	    workbook.close();
	    
		return data;
}

}