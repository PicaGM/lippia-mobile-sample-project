package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.ClockifyConstants;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.InputStream;
import java.util.Properties;

import static com.crowdar.core.actions.ActionManager.setInput;

public class GenericService {
    private static AndroidDriver driver = null;

    public GenericService(AndroidDriver driver) {
        this.driver = driver;
    }

    public static void clickAndHoldBckp(WebElement element) {
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriverInstance().getWrappedDriver();
        Actions action = new Actions(driver);
        action.clickAndHold(element).build().perform();
    }
    public static RemoteWebDriver getDriver()
    {
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriverInstance().getWrappedDriver();
        return driver;
    }

    public static void genericScroll(int startX, int startY, int endX, int endY){
        TouchAction ts = new TouchAction((PerformsTouchActions) getDriver());
        ts.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
    }

    public static void genericTouch(int x, int y){
        TouchAction ts = new TouchAction((PerformsTouchActions) getDriver());
        ts.tap(PointOption.point(x, y)).perform();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException var4) {
            System.out.println("Error in sleep: ".concat(var4.getMessage()));
            var4.printStackTrace();
        }
    }

    public static void login() throws Exception{
        Properties config = new Properties();
        InputStream input = null;

        try {
            input = GenericService.class.getClassLoader().getResourceAsStream("config.properties");

            config.load(input);

            String mail = config.getProperty("clocky.mail");
            String pass = config.getProperty("clocky.password");

            setInput(ClockifyConstants.MAIL_INPUT_LOCATOR, mail);
            setInput(ClockifyConstants.PASS_INPUT_LOCATOR, pass);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}