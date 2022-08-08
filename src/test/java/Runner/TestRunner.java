package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Sharayu\\eclipse-workspace\\Flipkart_Automation\\src\\test\\resources\\Features",
		glue = {"stepDefinition"})
public class TestRunner {

}
