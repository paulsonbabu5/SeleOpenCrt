package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration()
	{   try
	{   //logger.debug("Application logs");
		logger.info("***Starting TC_001_AccountRegistrationTest***");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account");
		hp.clickRegister();
		logger.info("Clicked on my register");
		RegistrationPage regpage=new RegistrationPage(driver);
		logger.info("providing customer data");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		String pass=randomAlphaNumberic();
		regpage.setPassword(pass);
		regpage.setConfirmPassword(pass);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String expmsg=regpage.getMessageConfirmationMsg();
		logger.info("Validating Expected message");
		Assert.assertEquals(expmsg,"Your Account Has Been Created!","test failed");
	}
	catch(Exception e)
	{   logger.error("Test failed");
		Assert.fail();
	}
	logger.info("***Finished TC_001_AccountRegistrationTest***");
	}
	
}
