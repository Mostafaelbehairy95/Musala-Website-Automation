package TestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import MusalaSoftPOM.Company;
import MusalaSoftPOM.HomePage;
import common.BaseTest;

public class CompanyTcs extends BaseTest {
	WebDriver driver;
	Company company;
	HomePage home;	
	
	@BeforeClass
	@Parameters({"Browser"})
	public void AccessCompanyPage(String Browser) {
		this.driver = super.setUpDriver(Browser);
		home = new HomePage(driver);
		company = home.AccessCompanyPage();
	}
	
	@Test(priority = 1)
	public void CorrectCompanyURL() {
		String Actual = company.getcompanyPageURL();
		assertEquals(Actual, super.getCompanyURLConfigFile());
	}
	
	@Test(priority = 2)
	public void LeaderShipSectionContainMember() {
		assertEquals(company.isLeaderShipLoaded(), 3, "The LeaderShips sections may be not loaded or doesn't have member");
	}
	
	@Test(priority = 3)
	public void verifyCorrectURLFacebook() {
		assertEquals(company.getFacebooURLCompany(),super.getFacebookMusalaLink());
	}
	
	@Test(priority = 4)
	public void validateCorrectURLFacebookUsingProfilePicture() {
		assertEquals(company.ValidateFacebookURL(), true);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

}
