package MusalaSoftPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Careers {
	
	private WebDriver driver;
	JavascriptExecutor js;
	private WebDriverWait wait;
	
	private static final By positionXpath = By.xpath("//*[@id=\"content\"]/div[1]/div/div[1]/div/section/div/a/button");
	
	
	private static final By AutomationQAJobXpath = By.xpath("//*[@id=\'content\']/section/div[2]/article[2]/div/a");
	

	public Careers(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	public JoinUs Check_our_open_positions() {
		js.executeScript("arguments[0].click();", driver.findElement(positionXpath));
		return new JoinUs(driver);
	}


}
