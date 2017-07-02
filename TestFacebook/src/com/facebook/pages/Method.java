package com.facebook.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Method 
{
	WebDriver driver;
	Variables var = new Variables();
	
	public Method(WebDriver mydriver)
	{
		this.driver= mydriver;	
	}
	//@FindBy annotations for finding items on the page
	@FindBy(name = "email")
	WebElement field_UserName;
	
	@FindBy(name = "pass")
	WebElement field_password;
	
	@FindBy(id = "loginbutton")
	WebElement btn_Sign_In;
	
	@FindBy(linkText = "Новое сообщение")
	WebElement link_New_Message;
	
	@FindBy(name = "mercurymessages")
	WebElement link_Message;
	
	@FindBy(css = "input.textInput")
	WebElement field_apponent_name;
	
	@FindBy(css = "._1mf")
	WebElement field_mesage_text;
	
	@FindBy(id = "userNavigationLabel")
	WebElement btn_userNavigation;
	
	@FindBy(css = "li._54ni:nth-child(12) > a:nth-child(1) > span:nth-child(1) > span:nth-child(1)")
	WebElement btn_Exit;
	
	
	public void Sign_In(String mail, String pass)//The method enters a login, a password and presses the login button
	{
		field_UserName.isEnabled();
		field_UserName.clear();
		field_UserName.sendKeys(mail);
		field_password.sendKeys(pass);
		btn_Sign_In.click();
	}
	
	public void click_icon_message() //The method presses the message icon in Facebook
	{
		link_Message.click();
	}
	
	public void click_new_message() throws InterruptedException //The method clicks on the link "new message" and opens the chat
	{
		link_New_Message.click();
		Thread.sleep(3000);//Stops the stream to load an element
	}
	
	public void enter_second_apponent_name()//In chat enters the name of the interlocutor
	{	
		field_apponent_name.sendKeys(var.secondUserName);
		field_apponent_name.sendKeys(Keys.ENTER);
		field_apponent_name.sendKeys(Keys.TAB, Keys.TAB);//The cursor moves to the message input field
	}
	
	public void enter_first_apponent_name()
	{	
		field_apponent_name.sendKeys(var.firstUserName);
		field_apponent_name.sendKeys(Keys.ENTER);
		field_apponent_name.sendKeys(Keys.TAB, Keys.TAB);
	}
	
	public void enter_message_first_user() //Writes and sends a message to the interlocutor
	{	
		field_mesage_text.sendKeys(var.testMessageFirstUser);
		field_mesage_text.sendKeys(Keys.ENTER);
	}
	
	public void enter_message_second_user() throws Exception
	{	
		field_mesage_text.sendKeys(var.testMessageSecondUser);
		field_mesage_text.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	public void sign_Off() throws InterruptedException //Logs out of user profile
	{	
		btn_userNavigation.click();
		Thread.sleep(3000);
		btn_Exit.click();
	}
}
