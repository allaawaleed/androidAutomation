package Pages;

import Data.RandomData;
import Utilities.BasePage;
import Utilities.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddReservation extends BasePage {

	public AddReservation(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Name']")
	private MobileElement nameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Name']")
	private MobileElement mobileField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[187,605][507,721]']")
	private MobileElement dateField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[573,605][1047,721]']")
	private MobileElement timeField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='1 guest']")
	private MobileElement guestNumber;

	@AndroidFindBy(id = "//org.nativescript.examples:id/number_picker_plus")
	private MobileElement increasePicker;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[187,1022][507,1081]']")
	private MobileElement selectSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[573,1029][1047,1088]']")
	private MobileElement selectTable;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[198,1260][915,1319]']")
	private MobileElement selectOrign;

	@AndroidFindBy(xpath = "//android.widget.TextView[DONE']")
	private MobileElement doneButton;

	public void addNewReservation() {
		waitElementToBeVisible(nameField, 10);
		enterData();
		while (guestNumber.getText() != "2 guests") {
			increasePicker.click();
		}
		selectSection.sendKeys("3rd floor");
		selectTable.sendKeys("4");
		selectOrign.sendKeys("online");
		doneButton.click();

	}

	public void enterData() {
		RandomData randomData = new RandomData();
		nameField.click();
		nameField.sendKeys("Test" + randomData.getCurrentTime());
		mobileField.click();
		mobileField.sendKeys(randomData.getMobile());
		dateField.click();
		dateField.sendKeys(randomData.getCurrentDate());
		Log.info(randomData.getCurrentDate());
		timeField.click();
		timeField.sendKeys(randomData.getCurrentTime());
		Log.info(randomData.getCurrentTime());
	}

}
