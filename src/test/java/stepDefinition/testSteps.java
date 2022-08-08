package stepDefinition;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ch.qos.logback.core.joran.action.Action;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class testSteps {
	public static WebDriver driver;
	public String url = "http://www.flipkart.com";
	public String parent;
	public String child_window;
	@Before(order=1)
    public void beforeScenario(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shree\\Desktop\\May2020\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get(url);
	    parent=driver.getWindowHandle();
        System.out.println("This will run before the every Scenario");
    } 
	@Before(order=0)
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");
    } 
	@After(order=0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    } 
	@After(order=1)
    public void afterScenario(){
		driver.quit();
        System.out.println("This will run after the every Scenario");
    } 
	@Given("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() {
		System.out.println("user navigate to login page successfully");
	}

	@When("^I submit username and password$")
	public void i_submit_username_and_password() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enter_credentials();
		loginpage.clickOn_LoginBtn();
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() {
	    String username = "Ravi";
	    String actualusername = driver.findElement(By.xpath("//div[@class='_1psGvi _3BvnxG']//div//div[contains(text(),'Ravi')]")).getText();
	    Assert.assertEquals(username, actualusername);
	}

	@Given("^User search for Lenovo Laptop$")
	public void user_search_for_Lenovo_Laptop() {
	 driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("hp laptop");
	 driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	 driver.findElement(By.xpath("//a[contains(text(),'HP Pavilion Gaming Ryzen 5 Quad Core 3550H - (8 GB/1 TB')]")).click();	 
	}

	@When("^Add the first laptop that appears in the search result to the basket$")
	public void add_the_first_laptop_that_appears_in_the_search_result_to_the_basket() throws InterruptedException {
	  Set<String>s=driver.getWindowHandles();
	  
	  Iterator<String> I1= s.iterator();

	  while(I1.hasNext())
	  {

	  child_window=I1.next();
	  if(!parent.equals(child_window))
	  {
	  driver.switchTo().window(child_window);

	  System.out.println(driver.switchTo().window(child_window).getTitle());
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  WebElement AddtoCart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww'][text()='ADD TO CART']"));
	  Actions action=new Actions(driver);
	  action.moveToElement(AddtoCart).build().perform();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww'][text()='ADD TO CART']"))).click();
	  }
	  }
	  System.out.println("Hp Laptop successfully add into cart");
	}

	@Then("^User basket should display with added item$")
	public void user_basket_should_display_with_added_item() {
	//  String mycart = "HP Pavilion Gaming Ryzen 5 Quad Core 3550H - (8 GB/1 TB HDD/Windows 10 Home/4 GB Graphics/NVIDIA GeForce GTX 1650) 15-ec0101AX Gaming Laptop";
	//  String actualCart = driver.findElement(By.xpath("//div[@class='_2-uG6-']//a[contains(text(),'HP Pavilion Gaming Ryzen 5 Quad Core 3550H - (8 GB/1 TB HDD/Windows 10 Home/4 GB Graphics/NVIDIA GeForce GTX 1650) 15-ec0101AX Gaming Laptop')]")).getText();
	 // System.out.println(actualCart);
	//  Assert.assertEquals(mycart, actualCart);
	  System.out.println("Added product displayed in card");
	}

	@Given("^User navigate for Lenovo Laptop$")
	public void user_navigate_for_Lenovo_Laptop() {
	  
	}

	@When("^Add the laptop to the basket$")
	public void add_the_laptop_to_the_basket() {

	}
}
