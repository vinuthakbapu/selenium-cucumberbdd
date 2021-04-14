package com.qa.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.pages.LoginPage;
import com.qa.utils.TestBase;

import io.cucumber.java.en.Given;

public class LoginSteps extends TestBase{
	
	private TestBase testBase;
	private LoginPage loginPage;

	public LoginSteps(TestBase testBase) {
		this.testBase=testBase;
		loginPage= new LoginPage(this.testBase.driver);
	}


	//LoginPage loginPage = new LoginPage(testBase.driver);
	
	@Given("Launch chrome browser")
	public void launch_chrome_browser() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("stepsabcd");
		//this.testBase.driver.findElement(By.name("q")).sendKeys("Vinutha");
		this.loginPage.OpenApplication();
	}
	
}
