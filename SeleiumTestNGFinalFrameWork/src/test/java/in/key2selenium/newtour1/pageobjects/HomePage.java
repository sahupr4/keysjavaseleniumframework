package in.key2selenium.newtour1.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver=null;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickRegisterLink1()
	{
		WebDriverWait ww=new WebDriverWait(driver, 50);
		WebElement reglink = ww.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'REGISTER')]")));
		reglink.click();
	}
	
	
	public void clickRegisterLink2()
	{
		FluentWait<WebDriver> fw=new FluentWait(driver);
		fw.withTimeout(50, TimeUnit.SECONDS);
		fw.pollingEvery(5, TimeUnit.SECONDS);
		
		WebElement reglink = fw.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'REGISTER')]")));
		reglink.click();
	}
	
	public void clickRegisterLink3()
	{
		WebElement reglink = driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]"));
		reglink.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'REGISTER')]")
	private WebElement reg1;
	public void clickRegisterLink4()
	{
		reg1.click();
	}

}
