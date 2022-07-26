package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {

	public WebDriver localdriver;
	
	public LoginPage(WebDriver remotedriver) 
	{
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	
	@FindBy(linkText="Log in")
	WebElement lnkLogin;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(xpath=("//*[@type='submit'][3]"))
	WebElement btnLogin;
	
	@FindBy(linkText="Log out")
	WebElement lnkLogout;
	
	@Test
	public void get(String url)
	{
		localdriver.get(url);	
		//Get the current window handle
		
		 Set <String> windows = localdriver.getWindowHandles();
		 Iterator <String> it = windows.iterator();
		 
	        String parent = it.next();
	        String child = it.next();
	        localdriver.switchTo().window(parent);
	        //localdriver.close();
	        //driver.findElement(By.xpath("//p[@class='mb-0']")).click();
	        localdriver.switchTo().window(child);
	        //driver.quit();
	        localdriver.manage().window().maximize();
	
	}
	
	@Test
	public void clickLogin() {
		lnkLogin.click();
	}
	
	@Test
	public void setUsername(String Username)
	{
		txtEmail.clear();
		txtEmail.sendKeys(Username); 
	}
	
	@Test
	public void setPassword(String Password)
	{
		txtPassword.clear();
		txtPassword.sendKeys(Password);
	}
	
	@Test
	public void btnLogin()
	{
		//btnLogin.click();
		txtPassword.sendKeys(Keys.TAB);
		txtPassword.sendKeys(Keys.TAB);
		txtPassword.sendKeys(Keys.TAB);
		txtPassword.sendKeys(Keys.ENTER);
	}
	
	@Test
	public void clkLogout()
	{
		lnkLogout.click();
	}
	
	@Test
	public void validateLogout()
	{
		if (lnkLogout.isDisplayed() || lnkLogout.isEnabled())
		{
			System.out.println("Logout link is enabled / displayed");
		}
		else
		{
			System.out.println("Logout link is not enabled / displayed");
		}
	}
	
	@Test
	public void validateLogin()
	{
		if (lnkLogin.isDisplayed() || lnkLogin.isEnabled())
		{
			System.out.println("Login link is enabled / displayed");
		}
		else
		{
			System.out.println("Login link is not enabled / displayed");
		}
	}	
	
	@Test
	public void closeBrowser()
	{
		localdriver.quit();
	}
	
}
