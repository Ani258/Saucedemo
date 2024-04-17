package pagefactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import genericfunction.Details;
import genericfunction.Generic_Login;


public class Order_message {
	@FindBy(name="add-to-cart-sauce-labs-onesie")WebElement product1 ;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-bike-light']")WebElement product2 ;
	@FindBy(css=".shopping_cart_link") 
	private WebElement shopping_icon;
	@FindBy(css=".inventory_item_price")
	public List<WebElement> price;
	@FindBy(className="product_sort_container") WebElement dropdown;
	@FindBy(xpath="//button[text()='Checkout']") WebElement checklist;
	@FindBy(css="#first-name") WebElement detail_firstname;
	@FindBy(css="#last-name") WebElement detail_lastname;
	@FindBy(css="#postal-code") WebElement detail_zipcode;
	@FindBy(name="continue") WebElement continue_box;
	@FindBy(xpath="//button[text()='Finish']") WebElement finish_page;
	@FindBy(xpath="//button[text()='Back Home']") WebElement backhome;
	
	WebDriver driver;
	Details excel=new Details();
    //Creating object for GenericLogin class
	Generic_Login generic;
	 
	//Constructor initializing driver
	public Order_message(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generic=new Generic_Login(driver);
		generic.ImplicitWait();
	}
	
	//Method to validate filter
	public void validate_price() {
		ArrayList<Double>bprice=new ArrayList<Double>();

		for(WebElement element:price)
		{
			bprice.add(Double.valueOf(element.getText().replace("$", "")));
		}
		System.out.println(bprice);
		Collections.sort(bprice);
        generic.selectByVisibleText(dropdown,"Price (low to high)");   
	    ArrayList<Double>aPrice=new ArrayList<Double>();

		for(WebElement element:price)
		{
			aPrice.add(Double.valueOf(element.getText().replace("$", "")));
		}
		System.out.println(aPrice);
		 Assert.assertEquals(bprice, aPrice);
	}
	
	//Method to add the products
	public void add_product() {
		generic.clickWebElement(product1);
		generic.clickWebElement(product2);
	}

	//Method to open the shopping cart
	public void cart_icon() {
		generic.clickWebElement(shopping_icon);
	}

	//Method to open checkout page
	public void checkout_page() {
		generic.clickWebElement(checklist);
	}
	
	//Method to getting the FirstName,LastName and ZipCode
	public void details() throws InterruptedException, IOException {
		generic.sendInput(detail_firstname, excel.get_firstname());
		generic.sendInput(detail_lastname,excel.get_lastname());
		generic.sendInput(detail_zipcode,String.valueOf(excel.get_pincode()));
	}
	
	//Method to click continue button
	public void continue_button(){
		generic.clickWebElement(continue_box);
	}
	
	//Method to click finish button
	public void Finish_button() {
		generic.clickWebElement(finish_page);
	}
	
	//Method to validate ordered message
	public void Order_placed() throws IOException {
		TakesScreenshot sc=(TakesScreenshot)driver;
		File Src=sc.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/scr1.png");
		FileUtils.copyFile(Src,dst);
	}
	
	//Method to navigate the home page
	public void backhome_button() {
		generic.clickWebElement(backhome);
	}

}
