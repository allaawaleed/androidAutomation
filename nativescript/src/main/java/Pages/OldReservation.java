package Pages;

import Utilities.BasePage;
import Utilities.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OldReservation extends BasePage {

	public OldReservation(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@bounds='[0,748][1080,946]']")
	private MobileElement firstOldReservation;

	@AndroidFindBy(xpath = "//android.widget.TextView[Edit reservation']")
	private MobileElement editeTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@bounds='[0,66][154,220]']")
	private MobileElement backButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ActionBar\"]/android.widget.ImageButton")
	private MobileElement menuBurger;

	@AndroidFindBy(xpath = "//android.widget.TextView[Code samples']")
	private MobileElement codeSampleButton;

	public void openOldReservation() {
		waitElementToBeVisible(firstOldReservation, 10);
		firstOldReservation.click();
		waitElementToBeVisible(editeTitle, 10);
		Log.info("App navigates user sucessfully to  " + editeTitle.getText());
		backButton.click();
		backButton.click();
		waitElementToBeVisible(menuBurger, 10);
		menuBurger.click();
		waitElementToBeVisible(codeSampleButton, 10);
		codeSampleButton.click();
	}
}
