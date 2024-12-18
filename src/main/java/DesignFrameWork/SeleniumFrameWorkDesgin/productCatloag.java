package DesignFrameWork.SeleniumFrameWorkDesgin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class productCatloag extends AbstractCompenet {
	
	WebDriver driver;
	
	public productCatloag(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	    //paefactory
		@FindBy(css=".offset-sm-1")
		List<WebElement> product;
		
		@FindBy(css=".ng-animating")
		WebElement spriner;
		
		
		
		By productsBy=By.cssSelector(".mb-3");
		By addToCart=By.cssSelector("button[class$='btn w-10 rounded']");
		By toasterMsg=By.cssSelector("#toast-container");
		
		
		
		
		public List<WebElement> getProductList()
		{
			
			
			waitforElementToApper(productsBy);
			return product;
		}
		
		public WebElement getProductByName(String prodname)
		
		{
			WebElement prod = getProductList().stream().filter(s -> s.findElement(By.cssSelector("B")).getText().equals(prodname))
					.findFirst().orElse(null);
			
			return prod;
		}
//		
		
	public void addProductToCart(String prodname)
	{
	WebElement prod=getProductByName(prodname);
	
	prod.findElement(addToCart).click();
	
	waitforElementToApper(toasterMsg);
	
	waitforElementToDisApper(spriner);
	


	}
	

		
	}



