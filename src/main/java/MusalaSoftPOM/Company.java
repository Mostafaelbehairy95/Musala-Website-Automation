package MusalaSoftPOM;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Company {
	
	private WebDriver driver;
	WebDriverWait wait;
	private JavascriptExecutor js;
	
	private static final By LeaderShipSectionClass = By.className("company-members");
	private static final By LeaderShipMemberclass = By.className("member");
	private static final By Facebook = By.xpath("/html/body/footer/div/div/a[4]");
	private static final By MusalaProfilePicFB = By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/"
			+ "div[1]/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div/a");
	
	public Company(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public String getcompanyPageURL() {
		return driver.getCurrentUrl();
	}
	
	public int isLeaderShipLoaded() {
		return driver.findElement(LeaderShipSectionClass).findElements(LeaderShipMemberclass).size();
	}

	
	public String getFacebooURLCompany() {
		return driver.findElement(Facebook).getAttribute("href");
	}
	
	public boolean ValidateFacebookURL() {
		js.executeScript("arguments[0].click();", driver.findElement(Facebook));
	    ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(newTb.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MusalaProfilePicFB));
		return driver.findElement(MusalaProfilePicFB).isDisplayed();
		
	}
}
