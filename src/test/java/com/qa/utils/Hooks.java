package com.qa.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends TestBase{

    private TestBase testBase;
    
	public Hooks(TestBase testBase) {
		this.testBase=testBase;
	}
    
	@Before
    public void initialize() throws Exception {
		WebDriverManager.chromedriver().setup();
		this.testBase.driver = new ChromeDriver();
		this.testBase.driver.manage().window().maximize();
		this.testBase.driver.get("http://google.co.in/");
    }

    @After
    public void quit(){
    	this.testBase.driver.quit();
    }
    
    @After
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)this.testBase.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png",scenario.getName());
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
    }
	
}
