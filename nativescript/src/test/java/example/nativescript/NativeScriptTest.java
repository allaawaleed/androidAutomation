package example.nativescript;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.AddReservation;
import Pages.GetStarted;
import Pages.OldReservation;
import Pages.Reservations;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NativeScriptTest {

	public static AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws Exception {
		BasicConfigurator.configure();
//		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//		service.start();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		// Emulator Caps
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("automationName", "UiAutomator1");
		// TODO to install and open app automatically
		// capabilities.setCapability("app", System.getProperty("user.dir") +
		// "/Apps/ExamplesNativeScript.apk");

		capabilities.setCapability("appPackage", "org.nativescript.examples");
		capabilities.setCapability("appActivity", "com.tns.NativeScriptActivity");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", false);
		driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}

	@Test(priority = 1, enabled = true, description = "Verify that app is working and able to click on get startd")
	public void validateSplashScreen() throws Exception {
		GetStarted openSplash = new GetStarted(driver);
		openSplash.openSplashScreen();
		assertThat(openSplash.getGetStartedButton(), containsString("GET"));
		openSplash.clickOnGetStarted();
		openSplash.addApptoBackgrond();
	}

	@Test(priority = 2, enabled = true, description = "Verify that app opens HomePage after clicking on Get Started and menu burger is displayed")
	public void openHomePage() throws Exception {
		GetStarted openHome = new GetStarted(driver);
		openHome.openHomePage();
		assertEquals(openHome.burgerIsDisplayed(), ("true"));

	}

	@Test(priority = 3, enabled = true, description = "Verify that app open reservation screen")
	public void clickOnReservation() throws Exception {
		Reservations clickonReservation = new Reservations(driver);
		clickonReservation.openReservations();
		assertThat(clickonReservation.getReservationTitle(), containsString("Reservation"));
	}

	@Test(priority = 4, enabled = true, description = "Verify that app open Add Reservation screen")
	public void clickOnPlus() throws Exception {
		Reservations clickOnPlus = new Reservations(driver);
		clickOnPlus.addReservation();
		assertThat(clickOnPlus.getAddReservationtitle(), containsString("New"));
	}

	@Test(priority = 5, enabled = true, description = "Verify adding new reservation")
	public void addNewReservation() throws Exception {
		AddReservation addNewRes = new AddReservation(driver);
		addNewRes.addNewReservation();
	}

	@Test(priority = 5, enabled = true, description = "Verify open old reservation")
	public void oldReservationandBack() throws Exception {
		OldReservation oldRes = new OldReservation(driver);
		oldRes.openOldReservation();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
