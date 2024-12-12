@AdminLoginFunctionality
Feature: Admin Login Functionality

   Scenario: Validate Successful Login
      When the admin enters valid credentials 
      And clicks on the login button
      Then validates Announcement section is visible
      And validates that the logo is visible
      And validates that the url includes the "MainPage.aspx" extension
   
   
   
   Scenario: Validate Error Message for Invalid Login
      When the admin enters invalid credentials "wrongUser" and "wrongPassword"
      And clicks on the login button
      Then validates credentials do not match error message
   
   
   Scenario: Validate Empty Fields during Login
      When the admin leaves the username and password fields empty
      And clicks on the login button
      Then validates fill required fields error message
   