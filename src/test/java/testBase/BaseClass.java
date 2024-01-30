package testBase;

import java.io.File;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  //log4j import
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Date;
import java.util.ResourceBundle; //loading properties file


public class BaseClass {
   
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb; //properties file
	//import from log4j
	
	
	@Parameters("browser")
	@BeforeClass(groups={"Master", "Regression", "Sanity"})
	public void setup(String br)
	{
		
		rb=ResourceBundle.getBundle("config");  //reading data from properties file
		
		logger=LogManager.getLogger(this.getClass());  //log4j
		
		if(br.equals("Chrome")) 
    	{
			logger.info("lunching chrome browser");
			
			ChromeOptions options = new ChromeOptions();
    		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});   //taking of the controlled automation 

    		driver = new ChromeDriver(options);
    	}
    	else if (br.equals("Edge"))
    	{
			logger.info("lunching edge browser");
    	    driver = new EdgeDriver();
    	}
    	else if(br.equals("Firefox"))
    	{
    		logger.info("lunching firefox browser");
    		driver = new FirefoxDriver();

    	}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appUrl"));// local app url
		logger.info("lunching browser url");
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"Master", "Regression", "Sanity"})
	public void tearDown() 
	{
		driver.quit();
		logger.info("closing browser");
	}

	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(5);
		
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {
		
		/*
		Date dt=new Date();
		SimpleDateFormat sp = new SimpleDateFormat ("yyyyMMddhhmmss");
		String timestamp = sp.format(dt);
		*/

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	 
	
	
}
