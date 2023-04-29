package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
@Test(groups={"Sanity","Master"})	
public void test_Login()
{   try
{   logger.info("***Starting TC_002_LoginTest***");
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	LoginPage lp=new LoginPage(driver);
	lp.setEmail("abcabc@gmail.com");
	lp.setPassword("abcabc");
	lp.clickLogin();
	MyAccountPage myaccount=new MyAccountPage(driver);
	Assert.assertEquals(myaccount.isMyAccountPageExists(), true);
}
catch(Exception e)
{   logger.error("Test Failed");
	Assert.fail();
	}
logger.info("***Finished TC_002_Login***");
	}
}



