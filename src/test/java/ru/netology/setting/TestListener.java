package ru.netology.setting;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Optional;

import static ru.netology.setting.SettingLoginTest.driver;

public class TestListener implements TestWatcher {

    @Override
    @Step("3. Закрытие приложения")
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png"
                , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        driver.quit();
    }

    @Override
    @Step("3. Закрытие приложения")
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        driver.quit();
    }

    @Override
    @Step("3. Закрытие приложения")
    public void testSuccessful(ExtensionContext context) {
        driver.quit();
    }

    @Override
    @Step("3. Закрытие приложения")
    public void testAborted(ExtensionContext context, Throwable cause) {
        driver.quit();
    }

}
