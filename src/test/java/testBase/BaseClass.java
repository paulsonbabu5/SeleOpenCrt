package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	@BeforeClass(groups= {"Regression","Master","Sanity"})
	@Parameters("browser")
	public void setup(String br)
	{ 
	  logger=LogManager.getLogger(this.getClass());
	  if(br.equals("firefox"))
	  {
	  driver=new FirefoxDriver();
	  }
	  else if(br.equals("edge"))
	  {
		  driver=new EdgeDriver();
	  }
	  else
	  {
		  driver=new ChromeDriver();
	  }
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("http://localhost/opencart/upload/");
	  driver.manage().window().maximize();
		
	}
    @AfterClass(groups= {"Regression","Master","Sanity"})
	public void tearDown()
	{
		driver.quit();
	}
    public String randomString()
    {
    	String generatedString=RandomStringUtils.randomAlphabetic(5);
    	return (generatedString);
    }
    public String randomNumber()
    {
    	String generatedNumber=RandomStringUtils.randomNumeric(5);
    	return (generatedNumber);
    }
    public String randomAlphaNumberic()
    {
    	String st=RandomStringUtils.randomAlphabetic(3);
    	String Num=RandomStringUtils.randomNumeric(4);
    	return(st+"@"+Num);
    }
    public String captureScreen(String tname)
    {
    	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
    	
    	try {
			FileUtils.copyFile(source,new File(destination));
		} catch (Exception e) {
			
			e.getMessage();
		}
    	return destination;
    }

}
