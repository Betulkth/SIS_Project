@LoginPageValidation
Feature: Login Page Functionality

  Scenario: Validate landing on the Login Page successfully
     
     Then Validate the page title is correct
     And Validate the page logo is displayed
     And Validate "Username:", "Password:", "Academic Year:" and "Login" fields are displayed
     
  Scenario: Validate behavior for an incorrect URL
  
    When Navigate to the "https://sis.neotechacademy.com/invalid" URL
    Then Validate the error message 
