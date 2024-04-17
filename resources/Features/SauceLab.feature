
Feature: Order the Product in Saucelab demosite

Background: User in Login page
    Given User should login and navigate to the home page
    
Scenario: Add product to the cart
    When User should add the last product to the cart    
    And User should display with cart page
    Then User should validate the selected item and title is same in home page
    
Scenario: Navigate back to the home page
    When User should add the 3rd product to the cart
    And User should navigate to the cart page
    And User should validate the selected item and price is same in home page
    And User should click on continue button
    Then user should be navigated back to home page
    
Scenario: Remove product from the cart
    When User should add 3rd and 1st product to the cart  
    And User should displayed with cart page
    And User should validate the selected item is displayed
    And User should remove the 2nd product from the cart
    Then User should validate that product is removed
    
Scenario: Order the product
    When User should select and validate the product in price(low to high) from dropdown
    And User add multiple products to the cart
    And User should display with cart
    And User enter first name,last name and postal code  
    And User should displayed with checkout page
    And User should displayed with checkout complete page
    And User should validate the order placed message is displayed
    Then User should navigate to the home page
    
Scenario: Reset the application state
    When User should select and validate the product in Name(Z to A) from dropdown  
    And  User should add multiple products to the cart
    And User validate that cart icon is displayed with number of product added
    And User should reset the cart
    And User should validate that cart is empty
    Then User should logout        