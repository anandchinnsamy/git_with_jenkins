package finalpack;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class finaltest {
	Logger logger =Logger.getLogger(finaltest.class);

	WebDriver d;
	@BeforeTest()
   	public void browserlauching()
   	{
	BasicConfigurator.configure();

	System.setProperty("webdriver.chrome.driver", "../final22/src/main/resources/chromedriver.exe");
	d = new ChromeDriver();
	d.get("http://192.168.1.73:4000/#");
	d.manage().window().maximize();
	
   	}
	@Test
	public void OnlyCorrectUNPW() {
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.findElement(By.id("kitchen_user_user_name")).clear();
		d.findElement(By.id("kitchen_user_password_digest")).clear();

		try {
			d.findElement(By.id("kitchen_user_user_name")).sendKeys("vivek");
			logger.info("Valid UN is passed to the UN field");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Valid data is not passed to the UN field");

		}
		try {
			d.findElement(By.id("kitchen_user_password_digest")).sendKeys("vivek");
			logger.info("Valid password data is passed to the PW field");
		} 
		catch (Exception e) 
		{

			logger.error("Valid password is not passed to the PW field");

		}
		
		d.findElement(By.name("commit")).click();

		logger.info("User able to login with Correct UN  &PW");
	}
}


