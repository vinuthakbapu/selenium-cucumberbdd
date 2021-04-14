package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class TestBase {
	
    public WebDriver driver;
    static Properties props;
    static String propsFileName = "config.properties";
    static InputStream is = null;

	
    public static void LoadProperties() throws Exception{
    	try {
    		props = new Properties();
    		is = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\config\\config.properties");
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(is != null){
                is.close();
            }
    	}
    }
    
    public static String GetProperties(String name) throws Exception {
    	LoadProperties();
    	return props.getProperty(name);
    }
    
}
