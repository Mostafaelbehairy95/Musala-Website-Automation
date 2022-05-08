package MusalaSoftPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {
	
	private WebDriver driver;
	
	private static final By CompanyXpath = By.xpath("//*[@id=\'menu-main-nav-1\']/li[1]/a");
	private static final By ContactUsid = By.id("contact_form_pop");
	private static final By ContactUsXpath  = By.xpath("/html/body/main/section[2]/div/div/div/a[1]/button");
	private static final By CareerXpath   = By.xpath("//*[@id=\'menu-main-nav-1\']/li[5]/a");
	private JavascriptExecutor js ;

	
	public HomePage(WebDriver driver) {
		if(driver == null) {
			throw new IllegalArgumentException();
		}
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
	
	public ContactUs AccessContactUsPage() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].click();", driver.findElement(ContactUsXpath));
		return new ContactUs(driver);
	}
	
	public Company AccessCompanyPage() {
		js.executeScript("arguments[0].click();", driver.findElement(CompanyXpath));
		return new Company(driver);
	}
	public Careers AccessCareerPage() {
		js.executeScript("arguments[0].click();", driver.findElement(CareerXpath));
		return new Careers(driver);
	}

}
