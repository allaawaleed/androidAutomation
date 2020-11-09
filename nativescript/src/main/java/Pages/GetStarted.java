package Pages;

import java.time.Duration;

import Utilities.BasePage;
import Utilities.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GetStarted extends BasePage {

	public GetStarted(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@text='GET STARTED']")
	private MobileElement getStartedButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ActionBar\"]/android.widget.ImageButton")
	private MobileElement menuBurger;

	public void openSplashScreen() {
		waitElementToBeVisible(getStartedButton, 20);
		Log.info("App opens and displays " + getStartedButton.getText());

	}

	public String getGetStartedButton() {
		return getStartedButton.getText();
	}

	public void clickOnGetStarted() {
		getStartedButton.click();
		waitElementToBeVisible(menuBurger, 20);
		Log.info("System clicked on Get Started button and App navigate user suesccfully to");

	}

	public void addApptoBackgrond() {
		// add app in background
		driver.runAppInBackground(Duration.ofSeconds(3));
		// open app again
		driver.activateApp("org.nativescript.examples");
		openSplashScreen();
	}

	public void openHomePage() {
		clickOnGetStarted();
		clickOnGetStarted();
	}

	public Boolean burgerIsDisplayed() {
		return menuBurger.isDisplayed();

	}
}
