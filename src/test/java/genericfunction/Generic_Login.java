package genericfunction;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Generic_Login {
	WebDriver driver;
	FluentWait<WebDriver> fluent_wait;
	WebDriverWait explicit_wait;
	public 	Generic_Login(WebDriver driver) {
		this.driver=driver;
	}
	
	//Method to sendKeys with the given XPath
	public void sendInput(WebElement InputField, String Input) {
    	InputField.sendKeys(Input);
    }
	
	//Method to use ImplicitWait
	public void ImplicitWait() {
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	//Method to use FluentWait
	public void FluentWait() {
	      fluent_wait = new FluentWait<WebDriver>(driver)
	    		.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
	}
	
	//Method to use Explicit wait 
	public void ExplicitWait(String element) {
		 explicit_wait = new WebDriverWait(driver, 10);
	        explicit_wait.until(ExpectedConditions.titleContains(element));
	}
	
    //Method to click on an element with the given XPath
    public void clickWebElement(WebElement element) {
        element.click();
    }
    
    //Method to compare the expected text and actual text
    public void Validateproduct(WebElement element, String ExpectedText) {
    	Assert.assertEquals(element.getText(),ExpectedText);
	}
    
    //Method to validate the element is displayed
	public void Validateproduct(WebElement element) {
		Assert.assertEquals(true, element.isDisplayed());
	}
	
	//Method to select DropDown for filter the product
	public void selectByVisibleText(WebElement element, String visibleText) { 
        Select select = new Select(element); 
        select.selectByVisibleText(visibleText); 
    } 

}
