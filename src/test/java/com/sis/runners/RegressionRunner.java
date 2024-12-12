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

		tags = "",

		plugin = {

				"html:target/resgression-report.html", 
				"json:target/cucumber.json", 
				"rerun:target/failed.txt"

		}

)

public class RegressionRunner {

}
