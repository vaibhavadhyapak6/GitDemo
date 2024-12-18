package SeleniumFrameWorkDesgin.Testrun;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import DesignFrameWork.SeleniumFrameWorkDesgin.productCatloag;
import SeleniumFrameWorkDesgin.testcomponet.baseTest;

public class LoginTest extends baseTest{
	
	@Test
	
	public void loginPageInvalidCred() throws IOException, InterruptedException
	{


         String ExpectedToaster="Incorrect email or password.";
		 productCatloag Prodcatloag=Landpage.loginApplication("Vaiadhyapak@gmail.com", "Tahshvi@2024");
         String Actualtoaster=Landpage.invalidCred();
		 //Assert.assertEquals("Incorrect email or password.", Landpage.invalidCred());
		 
		 Assert.assertEquals(Actualtoaster, ExpectedToaster);
		 
		 
	}
	
@Test
	
	public void loginPagevalidCred() throws IOException, InterruptedException
	{
	
	
	productCatloag Prodcatloag=	Landpage.loginApplication("Vaiadhyapak@gmail.com","Takhvi@2024");
	 List<WebElement> product=Prodcatloag.getProductList();
//    / Prodcatloag.addProductToCart(prodname);
     
	
   
	}


}
