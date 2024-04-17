package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pagefactory.Page01;

public class Scenario_01 {
	
     WebDriver driver=new EdgeDriver();
	
	@BeforeSuite()
	public void login() {
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	public void bank() throws IOException {
		Page01 pg=new Page01(driver);
		pg.LoginBankMangaer();
		//pg.NewCustomer();
		//pg.CheckAccount();
		//pg.SearchCustomer();
		//pg.Deletecustomer();
	}
//	@Test(priority = 2)
//	public void newcustomer() throws IOException {
//		pg.NewCustomer();
//	}
//	@Test(priority = 3)
//	public void addedcustomer() throws IOException {
//		pg.CheckAccount();
//	}
//	@Test(priority = 4)
//	public void search() {
//		pg.SearchCustomer();
//	}
//	@Test(priority = 5)
//	public void delete() {
//		pg.Deletecustomer();
//	}
}
