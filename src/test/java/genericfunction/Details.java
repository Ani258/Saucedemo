package genericfunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Details {
		
		String firstname;
		String lastname;
		Double pincode;
		XSSFCell cell;
		XSSFSheet sh;
		XSSFWorkbook wb;
		
		
		public void readExcel() throws IOException
		{
			File src = new File("C:\\Users\\ar83\\Desktop\\Book1.xlsx");
			FileInputStream fis= new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		public String get_url() throws IOException {
			readExcel();
			sh=wb.getSheetAt(0);
			String url= sh.getRow(4).getCell(2).getStringCellValue();
			return url;
		}
		public  String get_username() throws IOException
		{
			readExcel();
			sh = wb.getSheetAt(0);
			String user= sh.getRow(4).getCell(0).getStringCellValue();
			return user;
		}
		public  String get_password() throws IOException
		{
			readExcel();
			sh = wb.getSheetAt(0);
			String pass= sh.getRow(4).getCell(1).getStringCellValue();
			return pass;
		}
		public  String get_firstname() throws IOException
		{
			readExcel();
			sh = wb.getSheetAt(0);
			String firstname= sh.getRow(1).getCell(0).getStringCellValue();
			return firstname;
		}
		public  String get_lastname() throws IOException 
		{
			readExcel();
			sh = wb.getSheetAt(0);
			String lastname= sh.getRow(1).getCell(1).getStringCellValue();
			return lastname;
		}
	    public  Double get_pincode() throws IOException 
		{
			readExcel();
			sh = wb.getSheetAt(0);
			Double pincode= sh.getRow(1).getCell(2).getNumericCellValue();
			return pincode;
		}
	 

}
