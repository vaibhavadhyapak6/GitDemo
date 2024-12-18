package SeleniumFrameWorkDesgin.testcomponet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DesignFrameWork.SeleniumFrameWorkDesgin.landingPage;

public class baseTest {

	public WebDriver driver;
	public landingPage Landpage;

	public WebDriver intilazationdriver() throws IOException {

		Properties prop = new Properties();
		// FileInputStream file=new FileInputStream(System.getProperty("user.dir")
		// +
		// "SeleniumFrameWorkDesgin\\src\\main\\java\\SeleniumFrameWorkDesgin\\resources\\GlobalData.properties");

		FileInputStream file = new FileInputStream("C:\\Users\\vaibhava\\Desktop\\my learning\\Framework\\"
				+ "SeleniumFrameWorkDesgin\\src\\main\\java\\SeleniumFrameWorkDesgin\\resources\\GlobalData.properties");

		prop.load(file);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;

	}

	@BeforeMethod
	public landingPage launchApplication() throws IOException {
		driver = intilazationdriver();

		Landpage = new landingPage(driver);
		Landpage.URL();
		return Landpage;

	}

	@AfterMethod(enabled = false)
	public void teardown() throws InterruptedException {
		Thread.sleep(5);
		driver.quit();
	}

	public List<HashMap<String, String>> getJsonreaderTomap(String filepath) throws IOException

	{

		// read json to string C:\\Users\\vaibhava\\Desktop\\my
		// learning\\Framework\\SeleniumFrameWorkDesgin\\src\\main\\java\\Datareader\\jsondata.json
		String jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

		// string to HashMap -Jackson datbind

		ObjectMapper mapper = new ObjectMapper();

//		/HashMap<String, String> map = objectMapper.readValue(jsoncontent, HashMap.class);

		List<HashMap<String, String>> data = mapper.readValue(jsoncontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String getScrenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(
				"C:\\Users\\vaibhava\\Desktop\\my learning\\Framework\\SeleniumFrameWorkDesgin\\src\\main\\java\\reports"+ testCaseName+ ".png");
 
		FileUtils.copyFile(source, file);
		
		return "C:\\Users\\vaibhava\\Desktop\\my learning\\Framework\\SeleniumFrameWorkDesgin\\src\\main\\java\\reports"+ testCaseName+ ".png";
	}

}
