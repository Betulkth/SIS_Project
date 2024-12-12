package com.sis.steps;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import com.sis.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageValidationSteps extends CommonMethods {

	
	@Then("Validate the page title is correct")
	public void validate_the_page_title_is_correct() {
		
		waitForVisibility(loginPage.SIStitle);
		String expected = "Student Information System© Login";
		String actual = loginPage.SIStitle.getText();
		Assert.assertEquals("Page title is not correct!", expected, actual);

	}

	@Then("Validate the page logo is displayed")
	public void validate_the_page_logo_is_displayed() {

		Assert.assertTrue("The page logo is not displayed", loginPage.logo.isDisplayed());
	}

	@Then("Validate {string}, {string}, {string} and {string} fields are displayed")
	public void validate_and_fields_are_displayed(String Username, String Password, String AcademicYear, String Login) {

		
		waitForVisibility(loginPage.loginBtn);
		SoftAssert soft = new SoftAssert();
		
		String actualUsername = loginPage.usernameHeader.getText().trim();
		soft.assertEquals(actualUsername, Username, "Username header did not displayed!");
		
		String actualPassword = loginPage.passwordHeader.getText().trim();
		soft.assertEquals(actualPassword, Password, "Password header did not displayed!");
		
		String actualAcademicYear = loginPage.academicYearHeader.getText().trim();
		soft.assertEquals(actualAcademicYear, AcademicYear, "AcademicYear header did not displayed!");
		
		String actualLoginBtn = loginPage.loginBtn.getAttribute("value");
		soft.assertEquals(actualLoginBtn, Login, "Login header did not displayed!");
		
		soft.assertAll();
	}

	@When("Navigate to the {string} URL")
	public void navigate_to_the_url(String wrongUrl) {
		
		wrongUrl = "https://sis.neotechacademy.com/wrong";
		driver.get(wrongUrl);
		
	}

	@Then("Validate the error message")
	public void validate_the_error_message() {

		waitForClickability(wrongURLPage.errorMsg);
		Assert.assertTrue("Error Message did not displayed", wrongURLPage.errorMsg.isDisplayed());
	}

}
