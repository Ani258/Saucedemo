package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericfunction.Generic_Login;

public class Navigate_homepage {
	@FindBy(name="add-to-cart-sauce-labs-bolt-t-shirt") WebElement add_item;
	@FindBy(css=".shopping_cart_link") WebElement shopping_icon;
	@FindBy(xpath="//button[@id='continue-shopping']") WebElement next_button;
	@FindBy(linkText="Sauce Labs Bolt T-Shirt") WebElement selected_item;
	@FindBy(xpath="//span[text()='Products']") WebElement home_page;
	@FindBy(className="inventory_item_price") WebElement price;
	
	WebDriver driver;
    //Creating object for GenericLogin class
	Generic_Login generic;
 
	//Constructor initializing driver
	public Navigate_homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generic=new Generic_Login(driver);
	}
	
	//Method to add the product
	public void addproduct()  {
		generic.clickWebElement(add_item);	
	}
	
	//Method to open the shopping cart
	public void cart_icon() {
		generic.clickWebElement(shopping_icon);
	}
	
	//Method to click the continue button
	public void continue_shopping() {
		generic.clickWebElement(next_button);
	}
	
	//Method to validate the selected product
	public void selected_product() {
		generic.Validateproduct(selected_item);
		System.out.println("Selected item is displayed ");
		
		String ExpectedText = "$15.99";
		generic.Validateproduct(price, ExpectedText);
		System.out.println("Price of the product is same");
	}
	
	//Method to validate that HomePage is displayed
	public void navigate_homepage() {
		generic.Validateproduct(home_page);
	    System.out.println("Home page is displayed ");
	}

}
