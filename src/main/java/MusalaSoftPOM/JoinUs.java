package MusalaSoftPOM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JoinUs {
	
	private WebDriver driver;
	JavascriptExecutor js;
	private WebDriverWait wait;
	
	private static final By filterXpath = By.xpath("//*[@id=\'get_location\']");
	private static final By PositionCard = By.className("card-container");
	private static final By JobCard = By.className("card-jobsHot__title");
	
	

	public JoinUs(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public String isJoinUsPageOpened() {
		return driver.getCurrentUrl();
	}
	
	public String getfilter(String key) {
		Select filterSelect = new Select(driver.findElement(filterXpath));
		filterSelect.selectByVisibleText(key);

		return driver.getCurrentUrl();
	}
	
	public void displayAllPositioninPage(String filter) {
		getfilter(filter);
		System.out.println(filter + "\n");
		List<WebElement> DisplayedJobs = get_all_Jobs_In_Page();
		for(WebElement Job : DisplayedJobs) {
			System.out.println("Position: " + Job.findElement(JobCard).getText());
			System.out.println("More Info: " + Job.findElement(By.className("card-jobsHot__link")).getAttribute("href") + "\n");			
		}
	}
	
	public List<WebElement> get_all_Jobs_In_Page() {
		List<WebElement> Jobs = driver.findElements(PositionCard);
		return Jobs;
	}
	
	public boolean SelectPosition(String position) {
		List<WebElement> DisplayedJobs = get_all_Jobs_In_Page();
		for(WebElement Job : DisplayedJobs) {
			if(Job.findElement(JobCard).getText().equalsIgnoreCase(position)) {
				Job.findElement(JobCard).click();
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	

}
