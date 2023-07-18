package Hashtag.HastagRegistration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

	protected WebDriver driver;

	@BeforeTest
	public void launchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Study\\Selenium\\Akshata\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void exitSession() {
		driver.close();

	}

}
