package WebsiteAutomation.MusalaSoft;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs {
	private WebDriver driver;
	WebDriverWait wait;
	private static final By ContactUsFormID = By.id("contact_form_pop");
	private static final By NameField = By.id("cf-1");
	private static final By EmailField = By.id("cf-2");
	private static final By MobileField = By.id("cf-3");
	private static final By SubjectField = By.id("cf-4");
	private static final By YourMessageField = By.id("cf-5");
	private static final By submit_btn = By.xpath("//*[@id=\'wpcf7-f875-o1\']/form/div[2]/p/input");
	private static final By EmailErrorMessage = By.xpath("//*[@id=\'wpcf7-f875-o1\']/form/p[2]/span/span");

	public ContactUs(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public boolean CheckContactUsFormIsOpened() {
		return driver.findElement(ContactUsFormID).isDisplayed();
	}
	
	public void FillForm(String name,String Email,String mobile,String Subject,String Message) {
		driver.findElement(NameField).sendKeys(name);
		driver.findElement(EmailField).sendKeys(Email);
		driver.findElement(MobileField).sendKeys(mobile);
		driver.findElement(SubjectField).sendKeys(Subject);
		driver.findElement(YourMessageField).sendKeys("Message");
		driver.findElement(submit_btn).click();
	}
	
	public void clearFields() {
		driver.findElement(NameField).clear();
		driver.findElement(EmailField).clear();
		driver.findElement(MobileField).clear();
		driver.findElement(SubjectField).clear();
		driver.findElement(YourMessageField).clear();
	}
	
	public String getErrorEmail() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailErrorMessage));
		return driver.findElement(EmailErrorMessage).getText();
	}
	

}
