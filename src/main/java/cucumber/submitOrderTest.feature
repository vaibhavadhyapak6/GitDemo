@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

@Backgorund
Given I landed on Ecommerce Page
  @tag2
  Scenario Outline: Postiice test for for submitting the order
    Given Logged in with username <name> and password <password>
    When I add product<productName>
    And checkOut <productName> and submit the order
    Then "THANK YOU FOR THE ORDER." message is displayed in confirmationPage

    Examples: 
      | name 									 | password   			 | productName |
      | Vaiadhyapak@gmail.com  |  Takshvi@2024 | Zara COAT 3 |
    
