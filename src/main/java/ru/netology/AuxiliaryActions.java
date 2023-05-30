package ru.netology;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import java.time.LocalDateTime;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class AuxiliaryActions {
    public static void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage, WebDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage / 100);
        int startPoint = (int) (size.height * startPercentage / 100);
        int endPoint = (int) (size.height * endPercentage / 100);

        new TouchAction((PerformsTouchActions) driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(2000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }

    public static void tapByCoordinates(int x, int y, PerformsTouchActions driver) {

        new TouchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    public static String getCurrentTime(){
        return String.valueOf(LocalDateTime.now());
    }
}
