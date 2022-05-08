package MusalaSoftPOM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobApplication {
	
	private WebDriver driver;
	JavascriptExecutor js;
	private WebDriverWait wait;
	
	
	private final static By sendBtnXpath = By.xpath("//*[@id=\"wpcf7-f880-o1\"]/form/div[4]/p/input");
	
	private final static By NameID = By.id("cf-1");
	private final static By EmailID = By.id("cf-2");
	private final static By MobileID = By.id("cf-3");
	private final static By CvID = By.id("uploadtextfield");
	private final static By LinkedInUrlID = By.id("cf-5");
	private final static By YourMessageID = By.id("cf-6");
	private final static By AgreementID = By.id("adConsentChx");
	
	private final static By CloseButton = By.xpath("//*[@id=\"wpcf7-f880-o1\"]/form/div[5]/div/button");
	
	private final static By ErrorMessage = By.className("wpcf7-not-valid-tip");
	
	SingleJobPage form;

	public JobApplication(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", driver.findElement(AgreementID));

	}
	
	public void filljobApplication(String Name, String Email, String Mobile, String UploadCV, 
			String LinkedIn, String YourMessage, String Expected) {
		driver.findElement(NameID).sendKeys(Name);
		driver.findElement(EmailID).sendKeys(Email);
		driver.findElement(MobileID).sendKeys(Mobile);
		driver.findElement(CvID).sendKeys(UploadCV);
		driver.findElement(LinkedInUrlID).sendKeys(LinkedIn);
		driver.findElement(YourMessageID).sendKeys(YourMessage);
		
		js.executeScript("arguments[0].click();", driver.findElement(sendBtnXpath));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CloseButton));
		js.executeScript("arguments[0].click();", 	driver.findElement(CloseButton));
		clearFields();
		
	}
	
	public void clearFields() {
		driver.findElement(NameID).clear();
		driver.findElement(EmailID).clear();
		driver.findElement(MobileID).clear();
		driver.findElement(CvID).clear();
		driver.findElement(LinkedInUrlID).clear();
		driver.findElement(YourMessageID).clear();

	}
	public List<WebElement> getErrorMessages() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage));
		List<WebElement> Errors = driver.findElements(ErrorMessage);
		return Errors;
	}
	
	public boolean verifyErrorMessage(String expected) {
		List<WebElement> errorMessages = getErrorMessages();
		for(WebElement error : errorMessages) {
			if(error.getText().equalsIgnoreCase(expected)) {
				return true;
			}
		}
		return false;
	}

}
