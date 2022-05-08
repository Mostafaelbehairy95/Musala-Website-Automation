package WebsiteAutomation.MusalaSoft;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.ReadDataExcel;

public class JoinUsTcs extends BaseTest {
	private WebDriver driver;
	HomePage home;
	JoinUs join;
	SingleJobPage details;
	JobApplication Jobform;
	
	@BeforeClass
	@Parameters({"Browser"})
	public void beforeClass(String Browser) {
		this.driver = super.setUpDriver(Browser);
		home = new HomePage(driver);
		join = home.AccessCareerPage().Check_our_open_positions();
		details = new SingleJobPage(driver);
	}
	
	@Test(priority = 1)
	public void ValidateJoinUsPage() {
		String Actual = join.isJoinUsPageOpened();
		assertEquals(Actual, super.getJoinUsConfigFile());
	}
	
	@Test(priority = 2)
	public void ApplyFilterByAnyWhere() {
		String KeyFilter = "Anywhere";
		String Actual = join.getfilter(KeyFilter);
		System.out.println(Actual);
		assertEquals(Actual.toLowerCase(), (super.getJoinUsfilterConfigFile() + KeyFilter).toLowerCase());
	}
	
	@Test(priority = 3)
	public void Choose_open_position_by_name() {
		boolean Actual = join.SelectPosition("Automation QA Engineer");
		assertEquals(Actual, true, "This Posistion Doesn't Exist");
	}
	
	@Test(priority = 4)
	public void isJobSpecificationDisplayed() {
		boolean Actual = details.is4SectionDisplayed();
		assertEquals(Actual, true, "There's missing section");
	}
	
	@Test(priority = 5)
	public void VerifyAppearanceApplyButton() {
		boolean Actual = details.isApplyButtonDisplayed();
		Jobform = details.openJobApplication();
		assertEquals(Actual, true, "The button isn't displayed");
	}
	
	@Test(priority = 6, dataProvider = "JobApplication")
	public void SubmitJobForm(String Name, String Email, String Mobile, String UploadCV, String LinkedIn, String YourMessage,String Expected) {
		Jobform.filljobApplication(Name, Email, Mobile, UploadCV, LinkedIn, YourMessage, Expected);
		boolean Actual = Jobform.verifyErrorMessage(Expected);
		assertEquals(Actual, true);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@DataProvider(name="JobApplication")
	public String[][] gdata() throws IOException {
		String[][] obj = null;
		obj = ReadDataExcel.getData("JoinUs");
		return obj;
	}
	
	
		
	
	
}
