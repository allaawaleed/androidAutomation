package Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

public class RandomData {

	Faker fakeData = new Faker();
	String mobile = fakeData.phoneNumber().cellPhone();
	DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	DateFormat dateFormat = new SimpleDateFormat("");
	// get current date time with Date()
	Date date = new Date();
	String currentTime = timeFormat.format(timeFormat);
	String currentDate = dateFormat.format(dateFormat);

//	public void randomData(String mobile, String currentTime) {
//		this.mobile = mobile;
//		this.currentTime = currentTime;
//	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

}
