package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public  static WebDriver driver;

	public	Logger logger;

	public Properties properties;


	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os, String browser) throws Exception {

		//Loading config.properties fileB

		FileReader fileReader=new FileReader("./src//test//resources//config.properties");
		properties=new Properties();
		properties.load(fileReader);



		logger=LogManager.getLogger(this.getClass());
		
		//execution_env
	/*	if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
				
		if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(browser.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		}*/

		

		switch (browser.toLowerCase()) {
		case "chrome": driver= new ChromeDriver();break;

		case "edge": driver =new EdgeDriver();break;

		case "firefox": driver=new FirefoxDriver();break;

		default:System.out.println("Enter the correct browser");return;
		}

		//	driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(properties.getProperty("appURL"));
	}

	@AfterClass(groups = {"Sanity","Regression","Master"})
	public	void tearDown() {
		if (driver !=null) {
			driver.manage().window().minimize();
			driver.quit();
		}
	}

	public String randomName() {
		String randomFname= RandomStringUtils.randomAlphabetic(7);
		return randomFname;

	}

	public String randomTelNumber() {
		String randomTelNum=RandomStringUtils.randomNumeric(10);
		return  randomTelNum;

	}

	public String randomEmail() {
		String generetedString=	RandomStringUtils.randomAlphanumeric(10);
		return generetedString;
	}

	public String randomPasswoard() {
		String randomPass=RandomStringUtils.randomAlphanumeric(6);
		return randomPass+"@";
	}

	public String captureScreenShot(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhmmss").format(new Date());

		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath=System.getProperty("user.dir")+"\\screenshots"+tname+"_"+timeStamp+".png";
		File file=new File(targetFilePath);


		sourceFile.renameTo(file);

		return targetFilePath;

		//		try {
		//			FileUtils.copyFile(sourceFile, file);
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	}



	{

	}



}
