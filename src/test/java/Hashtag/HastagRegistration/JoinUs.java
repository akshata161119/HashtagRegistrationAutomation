package Hashtag.HastagRegistration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JoinUs extends TestNgTestBase {

	// Scenario: To verify name field is accepting user's Full Name.
	@Test
	public void NameField() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String UserName = "Test User";
		By nameInputField = By.xpath("//input[@placeholder='Enter your name']");

		driver.findElement(nameInputField).sendKeys(UserName);
		wait.until(ExpectedConditions.textToBePresentInElementValue(nameInputField, UserName));

		String namePresent = driver.findElement(nameInputField).getAttribute("value");
		Assert.assertEquals(namePresent, UserName);

	}

	// Scenario: To verify email field is accepting user's Email ID.
	@Test
	public void EmailField() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String EmailID = "Testuser@gmail.com";
		By emailInputField = By.xpath("//input[@name='email']");

		driver.findElement(emailInputField).sendKeys(EmailID);
		wait.until(ExpectedConditions.textToBePresentInElementValue(emailInputField, EmailID));

		String emailPresent = driver.findElement(emailInputField).getAttribute("value");
		Assert.assertEquals(emailPresent, EmailID);

	}

	// Scenario: To verify Phone field is accepting user's Phone Number.
	@Test
	public void resumeField() throws IOException, InterruptedException {

		String workingDir = System.getProperty("user.dir");

		WebElement el = driver.findElement(By.xpath("//input[@id='inputFile']"));

		Actions action = new Actions(driver);
		action.moveToElement(el);
		action.click(el).build().perform();
		TimeUnit.SECONDS.sleep(3);
		Runtime.getRuntime().exec(workingDir + "\\FileUpload.exe");

	}

	// Scenario: To verify Phone field is accepting user's Phone Number.
	@Test
	public void PhoneField() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Phonenumber = "9880119876";
		By phoneInputField = By.xpath("//input[@placeholder='Enter your phone']");

		driver.findElement(phoneInputField).sendKeys(Phonenumber);
		wait.until(ExpectedConditions.textToBePresentInElementValue(phoneInputField, Phonenumber));

		String phonePresent = driver.findElement(phoneInputField).getAttribute("value");
		Assert.assertEquals(phonePresent, Phonenumber);

	}

	// Scenario: To verify Phone field is accepting user's Description .
	@Test
	public void DescriptionField() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Description = "Over 2 years of experience in Software testing, with primary focus on quality assurance. Extensively involved in functional and automation testing. Experience in designing and executing automation scripts using Selenium for different web-based apps. ";
		By descriptionInputField = By.xpath("//textarea[@placeholder='Briefly Describe Yourself']");

		driver.findElement(descriptionInputField).sendKeys(Description);
		wait.until(ExpectedConditions.textToBePresentInElementValue(descriptionInputField, Description));

		String descriptionPresent = driver.findElement(descriptionInputField).getAttribute("value");
		Assert.assertEquals(descriptionPresent, Description);

	}

	// Scenario: To verify Submit Button is accepting user's Job application.
	@Test
	public void Applynow() throws InterruptedException, IOException {
		
		String workingDir = System.getProperty("user.dir");

		By applynowButton = By.xpath("//button[@class='btn form-button font-12 font-bold']");
		By emailInputField = By.xpath("//input[@name='email']");
		By nameInputField = By.xpath("//input[@placeholder='Enter your name']");
		By descriptionInputField = By.xpath("//textarea[@placeholder='Briefly Describe Yourself']");
		By phoneInputField = By.xpath("//input[@placeholder='Enter your phone']");

		driver.findElement(phoneInputField).sendKeys("7347434567");
		driver.findElement(descriptionInputField).sendKeys("Hello there its Test User here!");
		driver.findElement(nameInputField).sendKeys("Test User");
		driver.findElement(emailInputField).sendKeys("test.user@gmail.com");
		driver.findElement(applynowButton).click();
		WebElement el = driver.findElement(By.xpath("//input[@id='inputFile']"));

		Actions action = new Actions(driver);
		action.moveToElement(el);
		action.click(el).build().perform();
		TimeUnit.SECONDS.sleep(3);
		Runtime.getRuntime().exec(workingDir + "\\FileUpload.exe");

		String SubmitSuccess = driver
				.findElement(By.xpath("//p[contains(text(),'something went wrong! please try again later')]"))
				.getText();
		Assert.assertEquals(SubmitSuccess, "something went wrong! please try again later");
		
	}

}
