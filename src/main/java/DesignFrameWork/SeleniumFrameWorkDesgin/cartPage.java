package DesignFrameWork.SeleniumFrameWorkDesgin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage extends AbstractCompenet {
	
	
WebDriver driver;
	
@FindBy(css=".cartSection h3")
List<WebElement> prodTitles;


@FindBy(css=".totalRow button")
WebElement checkout;


	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProdDisplayed(String prodname)
	{
	
		//List<WebElement> cartprod = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean Match = prodTitles.stream().anyMatch(s -> s.getText().equalsIgnoreCase(prodname));
		return Match;
	}
	
	public checkoutpage checkout()
	{
		// click on checkout

		checkout.click();
		
		checkoutpage checkout=new checkoutpage(driver);
		return checkout;
		
	}
	
}
