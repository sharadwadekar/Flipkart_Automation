package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 public LoginPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	 @FindBy(how = How.XPATH, using = "//div[@class='_36HLxm col col-3-5']//form//input[@type='text']") 
	 private WebElement username;
	 
	 @FindBy(how = How.XPATH, using = "//div[@class='_36HLxm col col-3-5']//form//input[@type='password']") 
	 private WebElement password;
	 
	 @FindBy(how = How.XPATH, using = "//div[@class='_36HLxm col col-3-5']//form//button[@type='submit']") 
	 private WebElement LoginBtn;
	 
	 public void enter_username(String userName) {
		 username.sendKeys(userName);
		 }
	 public void enter_password(String passWord) {
		 password.sendKeys(passWord);
		 }
	 public void clickOn_LoginBtn() {
		 LoginBtn.click();
		 }
	 public void enter_credentials() {
		 enter_username("ravinangre@gmail.com");
		 enter_password("gujar1311");
		 }
}
