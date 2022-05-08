package MusalaSoftPOM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleJobPage {


	private WebDriver driver;
	JavascriptExecutor js;
	private WebDriverWait wait;
	
	String [] contentSections = {"General description","Requirements","Responsibilities","What we offer"}; 
	List<String> contentItem = new ArrayList<>(Arrays.asList(contentSections));
	
	private final static By JobcontentTitleClass = By.className("content-title");
	private final static By ApplyButtonXpath = By.xpath("//*[@id=\"post-1501\"]/div/div[2]/div[2]/a/input");


	public SingleJobPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public List<WebElement> get_all_JobContent_In_Page() {
		List<WebElement> JobContent = driver.findElements(JobcontentTitleClass);
		return JobContent;
	}
	
	public boolean is4SectionDisplayed() {
		List<WebElement> DisplayedJobContent = get_all_JobContent_In_Page();
		for(WebElement content : DisplayedJobContent) {
			if(!contentItem.contains(content.getText())) {
				return false;
			}
		}
		return true;
	}
	public boolean isApplyButtonDisplayed() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		return driver.findElement(ApplyButtonXpath).isDisplayed();
	}
	
	public JobApplication openJobApplication() {
		driver.findElement(ApplyButtonXpath).click();
		return new JobApplication(driver);
	}
	
	
}
