package pagefactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import genericfunction.Generic_Login;

public class Reset_cart {
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") 
	WebElement product1;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") 
	private WebElement product2;
	@FindBy(css="div.inventory_item_name")
	public List<WebElement> price;
	@FindBy(className="product_sort_container") 
	WebElement dropdown;
	@FindBy(xpath="//span[text()='2']") 
	WebElement number_of_items;
	@FindBy(xpath="//button[text()='Open Menu']") 
	WebElement menu_button;
	@FindBy(id="reset_sidebar_link") 
	WebElement reset_app;
	@FindBy(className=".shopping_cart_badge") 
	WebElement empty_cart;
	@FindBy(xpath="//a[text()='Logout']") 
	WebElement signout;
	
	WebDriver driver;	
    //Creating object for GenericLogin class
	Generic_Login generic;
	
	//Constructor initializing driver
	public Reset_cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generic=new Generic_Login(driver);
	}
	//Method to Validate filter
	public void validate_filter() {
		ArrayList<String>beforeprice=new ArrayList<String>();
		for(WebElement element:price)
		{
			beforeprice.add(element.getText());
		}
		System.out.println(beforeprice);
		Collections.sort(beforeprice);
		Collections.reverse(beforeprice);
        generic.selectByVisibleText(dropdown,"Name (Z to A)");
		ArrayList<String> afterPrice=new ArrayList<String>();
		for(WebElement element:price)
		{
			afterPrice.add(element.getText());
		}
		System.out.println(afterPrice);
		Assert.assertEquals(beforeprice,afterPrice);
	}
	
	//Method to add the products
	public void addcart() {
		generic.clickWebElement(product1);
		generic.clickWebElement(product2);
	}
	
	//Method to validate number of item in cart
	public void validate_items () {
		String ExpectedText = "2";
        generic.Validateproduct(number_of_items, ExpectedText);
		System.out.println("Number of the product in cart is same");
	}

	//Method to open menu in home page
	public void open_menu() {
		generic.clickWebElement(menu_button);
		generic.clickWebElement(reset_app);
		generic.FluentWait();
	}
	
	//Method to validate the cart is empty , after clicking reset button
	public void reset_cart() {
		try {
            generic.clickWebElement(empty_cart);
			System.out.println("Validation Failed: Cart is not empty");
        } catch (NoSuchElementException e) {
            System.out.println("Validation Passed: Cart is empty");
        }
	}
	
	//Method to click logout
	public void logout(){
        generic.clickWebElement(signout);
	}
	

}
