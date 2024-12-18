package DesignFrameWork.SeleniumFrameWorkDesgin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutpage extends AbstractCompenet{
	
WebDriver driver;
	
	public checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
By results=By.cssSelector(".ta-results");
	

//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	
	//driver.findElement(By.cssSelector(".ta-item:nth-last-child(1)")).click();
	
	@FindBy(css=".ta-item:nth-last-child(1)")
	WebElement selectCoutry;
	
	///WebElement submitButton = driver.findElement(By.cssSelector(".action__submit"));
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	public void  selectCountry(String CountryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Country,CountryName).build().perform();
		
		waitforElementToApper(results);
		selectCoutry.click();
		
		
	}
	
	public confirmationPage submitOrder()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement submitButton = submit;
		jsExecutor.executeScript("arguments[0].click();", submitButton);
		
		confirmationPage confirmpage=new confirmationPage(driver);
		
		return confirmpage;
	}
	
	
	
	
	
}
