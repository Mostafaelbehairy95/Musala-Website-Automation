package WebsiteAutomation.MusalaSoft;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.ReadDataExcel;

public class ContactUsTCs extends BaseTest {

	WebDriver driver;
	ContactUs contact_Us_Form;
	HomePage home;
	
	@BeforeClass
	@Parameters({"Browser"})
	public void beforeClass(String Browser) {
		this.driver = super.setUpDriver(Browser);
		home = new HomePage(driver);
		contact_Us_Form = home.AccessContactUsPage();
	}
	

	
	@Test(priority = 2, dataProvider = "contactus")
	public void Submit_Form_Invalid_Email_Synatax(String name,String Email,String mobile,String Subject,String Message) {
		contact_Us_Form.FillForm(name, Email, mobile, Subject, Message);
		assertEquals(contact_Us_Form.getErrorEmail(), "The e-mail address entered is invalid.");
		contact_Us_Form.clearFields();
	}
	@Test(priority = 1)
	public void isContact_Us_Form_Displayed() {
		boolean Actual = contact_Us_Form.CheckContactUsFormIsOpened();
		assertEquals(Actual, true);
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	@DataProvider(name="contactus")
	public String[][] gdata() throws IOException {
		String[][] obj = null;
		obj = ReadDataExcel.getData("ContactUs");
		return obj;
	}
	
	
	
}
