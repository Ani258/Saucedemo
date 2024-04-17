package genericfunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data {
	
	String firstname;
	String lastname;
	Double pincode;
	XSSFCell cell;
	XSSFSheet sh;
	XSSFWorkbook wb;
	
	
	public void readExcel() throws IOException
	{
		File src = new File("C:\\Users\\ar83\\Desktop\\Data.xlsx");
		FileInputStream fis= new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
	}
	public  String get_FirstName() throws IOException
	{
		readExcel();
		sh = wb.getSheetAt(0);
		String first= sh.getRow(1).getCell(0).getStringCellValue();
		return first;
	}
	public  String get_LastName() throws IOException
	{
		readExcel();
		sh = wb.getSheetAt(0);
		String last= sh.getRow(1).getCell(1).getStringCellValue();
		return last;
	}
	public  String get_PostalCode() throws IOException
	{
		readExcel();
		sh = wb.getSheetAt(0);
		String post= sh.getRow(1).getCell(2).getStringCellValue();
		return post;
	}
}



