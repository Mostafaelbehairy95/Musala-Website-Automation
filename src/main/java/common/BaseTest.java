package common;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BaseTest {
//	protected ExtractionProperties propertiesFile;
	
	private WebDriver driver;
	private ExtractionProperties propertiesFile;
	
	public WebDriver setUpDriver(String Browser) {
		propertiesFile =  new ExtractionProperties();
		if(Browser.equals(propertiesFile.getChromeBrowser())){
			System.setProperty("webdriver.chrome.driver", ".\\BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(Browser.equals(propertiesFile.getFirefoxBrowser())){
			System.setProperty("webdriver.gecko.driver", ".\\BrowserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(propertiesFile.getHomepage());

		return driver;
	}
	
	public String getCompanyURLConfigFile() {
		return propertiesFile.getcompanyUrl();
	}
	
	public String getFacebookMusalaLink() {
		return propertiesFile.getfacebookUrl();
	}
	
	public String getJoinUsConfigFile() {
		return propertiesFile.getjoinUsUrl();
	}
	public String getJoinUsfilterConfigFile() {
		return propertiesFile.getjoinUsFilterUrl();
	}

}
