package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	//elements
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnklogout;
	
	//actions
	public boolean isMyAccountPageExists()
	{
		try
		{
			boolean status=msgHeading.isDisplayed();
			return status;
		}
		catch(Exception e)
		{
			return(false);
		}
	}
    public void logOut()
    {
    	lnklogout.click();
    }

}


