package com.crowdar.examples.report;

import com.crowdar.driver.DriverManager;

import io.lippia.reporter.cucumber4.adapter.ReportServerApiAdapter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportServerReporter extends ReportServerApiAdapter{

	public ReportServerReporter(String arg) {
		super(arg);
	}

	@Override
	public String getBase64Image() {
		return  ((TakesScreenshot) DriverManager.getDriverInstance()).getScreenshotAs(OutputType.BASE64);
	}

}
