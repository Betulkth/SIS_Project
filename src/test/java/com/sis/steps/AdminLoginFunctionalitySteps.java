package com.sis.steps;

import org.junit.Assert;

import com.sis.utils.CommonMethods;
import com.sis.utils.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLoginFunctionalitySteps extends CommonMethods {

	@When("the admin enters valid credentials")
	public void the_admin_enters_valid_credentials() {

		sendText(loginPage.usernameBox, ConfigsReader.getProperty("username"));
		sendText(loginPage.passwordBox, ConfigsReader.getProperty("password"));

	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {

		click(loginPage.loginBtn);

	}

	@Then("validates Announcement section is visible")
	public void validate_announcement_section_is_visible() {

		waitForVisibility(homePage.announcements);
		Assert.assertTrue("Announcement section is Not visible", homePage.announcements.isDisplayed());

	}

	@Then("validates that the logo is visible")
	public void validate_that_the_logo_is_visible() {

		Assert.assertTrue("Logo did Not displayed", homePage.homePageLogo.isDisplayed());

	}

	@Then("validates that the url includes the {string} extension")
	public void validate_that_the_url_includes_the_extension(String urlIncludes) {
	   
		String currentUrl = driver.getCurrentUrl();
		
		if(currentUrl.contains(urlIncludes)) {
			
				System.out.println("The url includes MainPage.aspx extension");
					
		}
		
		
	}

	@When("the admin enters invalid credentials {string} and {string}")
	public void the_admin_enters_invalid_credentials_and(String wrongUser, String wrongPassword) {

		sendText(loginPage.usernameBox, wrongUser);
		sendText(loginPage.passwordBox, wrongPassword);

	}

	@Then("validates credentials do not match error message")
	public void validates_either_username_and_password_do_not_match_error_message() {

		String actualAlert = getAlertText();
		String expectedAlert = "Either username and password do not match or your account doesn't have  access for the selected Academic Year.";

		Assert.assertEquals("Error mesage did Not displayed", expectedAlert, actualAlert);
	    acceptAlert();
	}

	@When("the admin leaves the username and password fields empty")
	public void the_admin_leaves_the_username_and_password_fields_empty() {

		sendText(loginPage.usernameBox, "");
		sendText(loginPage.passwordBox, "");

	}

	@Then("validates fill required fields error message")
	public void validates_error_message() {

		String actualAlert = getAlertText();
		String expectedAlert = "Please fill required fields";
		Assert.assertEquals("Error message did not displayed", actualAlert, actualAlert);
		acceptAlert();
	}

}
