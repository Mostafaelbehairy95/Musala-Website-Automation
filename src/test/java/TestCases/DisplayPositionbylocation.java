package TestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import MusalaSoftPOM.HomePage;
import MusalaSoftPOM.JoinUs;
import MusalaSoftPOM.SingleJobPage;
import common.BaseTest;

public class DisplayPositionbylocation extends BaseTest {
	private WebDriver driver;
	HomePage home;
	JoinUs join;
	SingleJobPage details;

	@BeforeClass
	@Parameters({"Browser"})
	public void beforeClass(String Browser) {
		this.driver = super.setUpDriver(Browser);
		home = new HomePage(driver);
		join = home.AccessCareerPage().Check_our_open_positions();
	}
	
	@Test(priority = 1)
	public void ValidateJoinUsPage() {
		String Actual = join.isJoinUsPageOpened();
		assertEquals(Actual, super.getJoinUsConfigFile());
	}
	
	
	@Test(priority = 2)
	public void PrintPositionsInfoSofia() {
		join.displayAllPositioninPage("Sofia");
	}
	
	@Test(priority = 3)
	public void PrintPositionsInfoSkopje() {
		join.displayAllPositioninPage("Skopje");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("..................................................");
	}
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
