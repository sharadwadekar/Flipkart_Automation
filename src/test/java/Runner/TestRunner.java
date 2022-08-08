package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Shree\\Desktop\\May2020\\Flipkart_Automation\\src\\test\\resources\\Features\\Login.feature",
		glue = {"stepDefinition"}
		
		)

public class TestRunner {

}
