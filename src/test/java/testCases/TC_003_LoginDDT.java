package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	@Test(dataProvider="dp1",dataProviderClass=DataProviders.class)
	public void testLogin(String email,String pwd,String exp)
	{
	logger.info("***Starting TC_003_LoginDDT***");
	  try
		{   
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			MyAccountPage myaccount=new MyAccountPage(driver);
			boolean status=myaccount.isMyAccountPageExists();
			if(exp.equals("Valid"))
			{
				if (status==true)
				{   myaccount.logOut();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equals("InValid"))
			{
				if (status==true)
				{  
					myaccount.logOut();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
			
		}
		catch(Exception e)
		{   logger.error("Test Failed");
			Assert.fail();
			}
		logger.info("***Finished TC_003_LoginDDT***");
			}
}


