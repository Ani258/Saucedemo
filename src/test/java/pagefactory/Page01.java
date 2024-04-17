package pagefactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import genericfunction.Excel_Data;



public class Page01 {
	@FindBy(xpath="//button[@ng-click='manager()']")WebElement Bankmanager;
    @FindBy(xpath="//button[@ng-class='btnClass1']")WebElement Addcustomer;
    @FindBy(xpath="//input[@placeholder='First Name']")WebElement Firstname;
    @FindBy(xpath="//input[@placeholder='Last Name']")WebElement Lastname;
    @FindBy(xpath="//input[@placeholder='Post Code']")WebElement Postcode;
    @FindBy(className="btn btn-default")WebElement Submitdetails;
    @FindBy(xpath="//button[contains(@class,'btn-lg tab btn')]")WebElement Openaccount;
    @FindBy(xpath="//select[contains(@class,'ng-pristine ng-invalid')]")WebElement Customername;
    @FindBy(xpath="//option[@ng-repeat='cust in Customers']")List <WebElement> Selectcustomer;
    @FindBy(name="currency")WebElement Currency;
    @FindBy(xpath="//button[@type='submit']")WebElement Process;
    @FindBy(className="btn btn-lg tab btn-primary")WebElement Customers;
    @FindBy(xpath="//input[@placeholder='Search Customer']")WebElement SearchCustomer;
    @FindBy(xpath="//button[text()='Delete']")WebElement Deleteuser;
    
    WebDriver driver;
    Excel_Data data =new Excel_Data();
    public Page01(WebDriver driver) {
 	   this.driver=driver;
 	   PageFactory.initElements(driver,this);
    }
    public void LoginBankMangaer() {
 	   Bankmanager.click();
    }
    public void NewCustomer() throws IOException {
 	   Addcustomer.click();
 	   Firstname.sendKeys(data.get_FirstName());
 	   Lastname.sendKeys(data.get_LastName());
 	   Postcode.sendKeys(data.get_PostalCode());
 	   Submitdetails.click();
 	   String alerttext=driver.switchTo().alert().getText();
 	   
 	   driver.switchTo().alert().accept();
 	    	   
    }
    public void CheckAccount() throws IOException {
 	   Openaccount.click();
 	   Customername.click();
 	   Select s=new Select(Customername);
 	   s.selectByVisibleText("abi man");
 	   Currency.click();
 	   Select sc=new Select(Currency);
 	   sc.selectByValue("Rupee");
 	   Process.click();
 	   String alerttext2=driver.switchTo().alert().getText();
 	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src,new File("./Screenshot/sc2.png"));
 	   driver.switchTo().alert().accept();
 	   System.out.println(alerttext2);
 	   
    }
    public void SearchCustomer() {
 	   Customers.click();
 	   SearchCustomer.sendKeys("abi man");
    }
    public void Deletecustomer() {
 	   Deleteuser.click();
    }


}
