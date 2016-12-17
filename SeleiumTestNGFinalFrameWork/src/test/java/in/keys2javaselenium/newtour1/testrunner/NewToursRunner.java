package in.keys2javaselenium.newtour1.testrunner;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import in.key2selenium.newtour1.pageobjects.HomePage;
import in.key2selenium.newtour1.pageobjects.RegisterPage;
import in.key2selenium.newtour1.utility.BrowserSelection;
import in.key2selenium.newtour1.utility.XLReader;

public class NewToursRunner {
	
	WebDriver driver=null;
	
	HomePage homepg=null;
	
	RegisterPage rp=null;
	
		
	@Parameters({"bn", "url"})
	@BeforeMethod
	
	public void init(@Optional("firefox") String browserName,
			@Optional("http://newtours.demoaut.com/") String url)
	{
		driver=BrowserSelection.OpenBrowsers(browserName);
		BrowserSelection.openURL(url);
		homepg=PageFactory.initElements(driver, HomePage.class);
	}
	
		
	@Test(dataProvider="newtours", dataProviderClass=XLReader.class)
	public void verifyHomePage(String pageTitle, String rownum)
	{
		String act_pageTitle=homepg.getPageTitle();
		System.out.println(pageTitle);
		System.out.println(act_pageTitle);
		System.out.println(rownum);
		//Assert.assertEquals(act_pageTitle, pageTitle);
		
		Assert.assertTrue(act_pageTitle.equals(pageTitle));
	}
	
	@Test(dataProvider="newtours", dataProviderClass=XLReader.class)
	public void verifyRegistrationPage(String data1, String data2,
			String data3, String data4, String data5, String data6, String data7,
			String data8, String data9, String data10, String data11, String data12, String data13, String rowNum)
	{
		homepg.clickRegisterLink1();
		rp=PageFactory.initElements(driver, RegisterPage.class);
		System.out.println(rowNum);
		rp.setFirstName(data1);
		rp.setLasttName(data2);
		rp.setPhoneNumber(data3);
		rp.setEmailAddress(data4);
		
		rp.clickSubmitButton();
		
	}
	
	
	
	

}
