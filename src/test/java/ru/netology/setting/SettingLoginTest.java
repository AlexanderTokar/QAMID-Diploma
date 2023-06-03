package ru.netology.setting;

import ru.netology.TextGenerator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import io.qameta.allure.Step;

public class SettingLoginTest {

    protected static AndroidDriver driver;

    @BeforeEach
    @Step("1. Запуск приложения и успешная авторизация")
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "API29");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:appPackage", "ru.iteco.fmhandroid");
        desiredCapabilities.setCapability("appium:appActivity", "ru.iteco.fmhandroid.ui.AppActivity");
        desiredCapabilities.setCapability("appium:unicodeKeyboard", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();
    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
}
