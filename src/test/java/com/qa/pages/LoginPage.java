package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	@FindBy(name = "q")
    private WebElement searchTextBox;
	
	@FindBy(xpath = "//div[@data-hveid='CAMQAA']/div/a")
    private WebElement firstLink;
	
	
	public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
	
	public void OpenApplication() throws Exception {
		System.out.println("abcd");
		//driver.findElement(By.name("q")).sendKeys("Vinutha");
		searchTextBox.sendKeys("Vinutha");
		searchTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(15000);
		firstLink.click();
		Thread.sleep(5000);
	}
}
