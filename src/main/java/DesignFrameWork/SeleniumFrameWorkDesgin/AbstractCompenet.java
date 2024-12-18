package DesignFrameWork.SeleniumFrameWorkDesgin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import DesignFrameWork.SeleniumFrameWorkDesgin.cartPage;

public class AbstractCompenet {
	
	WebDriver driver;
	public AbstractCompenet(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
	
/*	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader; */
	
	@FindBy(css="button[routerlink=\"/dashboard/cart\"]")
	WebElement cartHeader;
	
	@FindBy(css="button[routerlink=\"/dashboard/myorders\"]")
	WebElement odrderHeader;
	
	

	public void waitforWebElemetToApper(WebElement findby)
	{
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Wait.until(ExpectedConditions.visibilityOf(findby));
	}
	
	  
	 public void waitforElementToDisApper(WebElement ele) 
		{
		 
		
			WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	Wait.until(ExpectedConditions.invisibilityOf(ele));
			
		}
	 
	 public void waitforElementToApper(By findby)
		{
			WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
		}
		
	 	 
	 public cartPage goTocartsection() 
	 {
		 
		//Thread.sleep(2);
		 cartHeader.click();
		 
		 cartPage cartpage =new cartPage(driver);
			return cartpage;
	 }
	 

	 public OrderPage goToOrderPage()
	 {
		 odrderHeader.click();
		 OrderPage orderpage=new OrderPage(driver);
		 return orderpage;
		 
	 }
		

		
		 
	 
	
	

}
