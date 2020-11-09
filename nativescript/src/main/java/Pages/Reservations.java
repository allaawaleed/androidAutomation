package Pages;

import java.util.HashMap;
import java.util.Map;

import Utilities.BasePage;
import Utilities.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Reservations extends BasePage {

	public Reservations(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reservations']")
	private MobileElement reserviationButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[198,418][882,529]']")
	private MobileElement reservationTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[28,583][171,726]']")
	private MobileElement plusButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New reservation']")
	private MobileElement addReservationTitle;

	public void swipeDown() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("direction", "down");
		driver.executeScript("mobile: scroll", params);
	}

	public void openReservations() {
		// swipeDown();
		waitElementToBeVisible(reserviationButton, 10);
		reserviationButton.click();
		waitElementToBeVisible(reservationTitle, 10);
		Log.info("App opens Reservations screen and title is " + reservationTitle.getText());
	}

	public String getReservationTitle() {
		return reservationTitle.getText();
	}

	public void addReservation() {
		waitElementToBeVisible(plusButton, 10);
		plusButton.click();
		waitElementToBeVisible(addReservationTitle, 10);
		Log.info("App opens add new reservations screen and title is " + addReservationTitle.getText());
	}

	public String getAddReservationtitle() {
		return addReservationTitle.getText();
	}
}
