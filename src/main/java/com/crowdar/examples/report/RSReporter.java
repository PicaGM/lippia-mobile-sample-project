package com.crowdar.examples.report;

import com.crowdar.driver.DriverManager;
import io.lippia.reporter.cucumber4.adapter.ReportServerApiAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class RSReporter extends ReportServerApiAdapter {

	public RSReporter(String arg) {
		super();
	}

	@Override
	public String getBase64Image() {
		return  ((TakesScreenshot) DriverManager.getDriverInstance()).getScreenshotAs(OutputType.BASE64);
	}

}
