package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.ClockifyConstants;
import org.testng.Assert;

public class ClockifyService {

    public static void loginClockify() throws Exception {
        MobileActionManager.click(ClockifyConstants.LOGIN_MANUAL_BUTTON_LOCATOR);
        GenericService.login();
        MobileActionManager.click(ClockifyConstants.LOGIN_BUTTON_LOCATOR);
    }

    public static void verifyLogin() {
        MobileActionManager.waitPresence(ClockifyConstants.TIME_TRACKER_TEXT_LOCATOR);
        Assert.assertTrue(MobileActionManager.isPresent(ClockifyConstants.TIME_TRACKER_TEXT_LOCATOR));
    }

    public static void createProject() {
        MobileActionManager.click(ClockifyConstants.NEW_ENTRY_BUTTON_LOCATOR);
        MobileActionManager.click(ClockifyConstants.MANUAL_ENTRY_BUTTON_LOCATOR);
    }
    public static void setProjectValues(String horario, String descripcion) {
        MobileActionManager.setInput(ClockifyConstants.FIRST_TIME_INPUT_LOCATOR, horario);
        MobileActionManager.click(ClockifyConstants.OK_TIME_BUTTON_LOCATOR);
        MobileActionManager.setInput(ClockifyConstants.PROJECT_DESCRIPTION_INPUT_LOCATOR, descripcion);
        MobileActionManager.click(ClockifyConstants.PROJECT_SELECT_BUTTON_LOCATOR);
        MobileActionManager.click(ClockifyConstants.PROJECT_SELECTOR_BUTTON_LOCATOR);
        MobileActionManager.click(ClockifyConstants.TASK_SELECT_BUTTON_LOCATOR);
        MobileActionManager.click(ClockifyConstants.TASK_SELECTOR_BUTTON_LOCATOR);
        MobileActionManager.click(ClockifyConstants.BACK_BUTTON_LOCATOR);
        MobileActionManager.click(ClockifyConstants.SAVE_PROJECT_BUTTON_LOCATOR);
    }

    public static void verifyProject() {
        MobileActionManager.waitPresence(ClockifyConstants.ENTRY_VERIFY_TEXT_LOCATOR);
        Assert.assertTrue(MobileActionManager.isPresent(ClockifyConstants.ENTRY_VERIFY_TEXT_LOCATOR));
    }
}
