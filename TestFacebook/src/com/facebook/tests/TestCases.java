package com.facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.facebook.pages.Method;
import com.facebook.pages.Variables;


public class TestCases 
{
	Variables var = new Variables();
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{	//Set Path to driver firefox
		System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
	}

	@Test()
	public void test_Facebook() throws Exception
	{
		Method m = PageFactory.initElements(driver, Method.class);
		m.Sign_In(var.firstUserLogin, var.firstUserPass); //The method enters a login, a password and presses the login button
		m.click_icon_message();                           //The method presses the message icon in Facebook
		m.click_new_message();                            //The method clicks on the link "new message" and opens the chat
		m.enter_second_apponent_name();                   //In chat enters the name of the interlocutor
		m.enter_message_first_user();                     //Writes and sends a message to the interlocutor
		m.sign_Off();                                     //Logs out of user profile
		m.Sign_In(var.secondUserLogin, var.secondUserPass); 
		m.click_icon_message();
		m.click_new_message();
		m.enter_first_apponent_name();
		m.enter_message_second_user();
		Assert.assertTrue(var.testMessageSecondUser == var.testMessageSecondUser);//Checking the sent message
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
