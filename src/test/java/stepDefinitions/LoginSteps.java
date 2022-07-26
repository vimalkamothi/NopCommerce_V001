package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class LoginSteps {

	public WebDriver driver;
	public LoginPage lp;
	
	@Given("I want to launch Chrome browser")
	public void i_want_to_launch_chrome_browser() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
		
	}

	@When("I opn URL {string}")
	public void i_opn_url(String url) {
		lp.get(url);
	}

	@When("I click on Login link")
	public void i_click_login() {
		lp.clickLogin();
	}
	
	@When("I enter Email as {string} and Password as {string}")
	public void i_enter_email_as_and_password_as(String username, String password) {
		lp.setUsername(username);
		lp.setPassword(password);
	}

	@When("Click on the Login button")
	public void click_on_the_login_link() {
		lp.btnLogin();
	}

	@Then("I validate the Logout link")
	public void i_validate_the_logout_link() {
		lp.validateLogout();
	}

	@When("I click on Logout link")
	public void i_click_on_logout_link() {
		lp.clkLogout();
	}

	@Then("I validate the Login link")
	public void i_validate_the_login_link() {
		lp.validateLogin();
	}

	@Then("I close browser")
	public void i_close_browser() {
		lp.closeBrowser();
	}

}
