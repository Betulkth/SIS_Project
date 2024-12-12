package com.sis.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/",

		glue = "com.sis.steps",

		dryRun = false,

		monochrome = true,

		tags = "@LoginPageValidation",

		plugin = {

				"pretty", "html:target/cucumber-deafult-report.html", "json:target/cucumber.json"

		}

)

public class TestRunner {

}
