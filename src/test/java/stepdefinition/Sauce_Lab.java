package stepdefinition;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import genericfunction.Details;
import genericfunction.Generic_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.Add_Cart;
import pagefactory.Navigate_homepage;
import pagefactory.Order_message;
import pagefactory.Remove_product;
import pagefactory.Reset_cart;

public class Sauce_Lab {
	WebDriver driver= new EdgeDriver();
	//Creating object for the class
	Add_Cart order;
	Navigate_homepage home;
	Remove_product remove;
	Order_message product;
	Reset_cart reset;
	
	Details excel=new Details();
	Generic_Login generic=new Generic_Login(driver);
	@Given("User should login and navigate to the home page")
	public void user_should_login_and_navigate_to_the_home_page() throws IOException {
	    driver.manage().window().maximize();
	 
	    order=new Add_Cart(driver);
	    home=new Navigate_homepage(driver);
	    remove=new Remove_product(driver);
	    product=new Order_message(driver);
	    reset=new Reset_cart(driver);
	    
	    driver.get("https://www.saucedemo.com");
	    order.username();
	    order.password();
	    order.submit();
	    }

	@When("User should add the last product to the cart")
	public void user_should_add_the_last_product_to_the_cart() {
	   order.addproduct(); 
	}

	@And("User should display with cart page")
	public void user_should_display_with_cart_page() {
	   order.cart_icon(); 
	}

	@Then("User should validate the selected item and title is same in home page")
	public void user_should_validate_the_selected_item_and_title_is_same_in_home_page() {
	    order.validate_item();
	}

	@When("User should add the 3rd product to the cart")
	public void user_should_add_the_3rd_product_to_the_cart() {
	    home.addproduct();
	}

	@And("User should navigate to the cart page")
	public void user_should_navigate_to_the_cart_page() {
	    home.cart_icon();
	}

	@And("User should validate the selected item and price is same in home page")
	public void user_should_validate_the_selected_item_and_price_is_same_in_home_page() {
	    home.selected_product();
	}

	@And("User should click on continue button")
	public void user_should_click_on_continue_button() {
	    home.continue_shopping();
	}

	@Then("user should be navigated back to home page")
	public void user_should_be_navigated_back_to_home_page() {
	    home.navigate_homepage();
	}

	@When("User should add 3rd and 1st product to the cart")
	public void user_should_add_3rd_and_1st_product_to_the_cart() {
	    remove.addproduct1();
	    remove.addproduct2();
	}

	@And("User should displayed with cart page")
	public void user_should_displayed_with_cart_page() {
	    remove.cart_icon();
	}

	@And("User should validate the selected item is displayed")
	public void user_should_validate_the_selected_item_is_displayed() {
	    remove.validate_product();
	}

	@And("User should remove the 2nd product from the cart")
	public void user_should_remove_the_2nd_product_from_the_cart() {
	    remove.remove_button();
	}

	@Then("User should validate that product is removed")
	public void user_should_validate_that_product_is_removed() {
	    remove.remove_product();
	}

	@When("User should select and validate the product in price\\(low to high) from dropdown")
	public void user_should_select_and_validate_the_product_in_price_low_to_high_from_dropdown() {
	    product.validate_price();
	}

	@And("User add multiple products to the cart")
	public void user_add_multiple_products_to_the_cart() {
	    product.add_product();
	}

	@And("User should display with cart")
	public void user_should_display_with_cart() {
	   product.cart_icon();
	   product.checkout_page();
	}

	@And("User enter first name,last name and postal code")
	public void user_enter_first_name_last_name_and_postal_code() throws InterruptedException, IOException {
	   product.details();
	}

	@And("User should displayed with checkout page")
	public void user_should_displayed_with_checkout_page() {
	   product.continue_button();
	}

	@And("User should displayed with checkout complete page")
	public void user_should_displayed_with_checkout_complete_page() {
	    product.Finish_button();
	}

	@And("User should validate the order placed message is displayed")
	public void user_should_validate_the_order_placed_message_is_displayed() throws IOException {
	    product.Order_placed();
	}

	@Then("User should navigate to the home page")
	public void user_should_navigate_to_the_home_page() {
	    product.backhome_button();
	}

	@When("User should select and validate the product in Name\\(Z to A) from dropdown")
	public void user_should_select_and_validate_the_product_in_name_z_to_a_from_dropdown() {
	   reset.validate_filter();
	}

	@And("User should add multiple products to the cart")
	public void user_should_add_multiple_products_to_the_cart() {
	    reset.addcart();
	}

	@And("User validate that cart icon is displayed with number of product added")
	public void user_validate_that_cart_icon_is_displayed_with_number_of_product_added() {
	    reset.validate_items();
	}

	@And("User should reset the cart")
	public void user_should_reset_the_cart() {
	   reset.open_menu();
	}

	@And("User should validate that cart is empty")
	public void user_should_validate_that_cart_is_empty() {
	    reset.reset_cart();
	}

	@Then("User should logout")
	public void user_should_logout() {
	    reset.logout();
	}
}
