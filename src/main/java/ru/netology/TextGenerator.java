package ru.netology;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TextGenerator {
    public static void typeText(String text, WebDriver driver) {
        char[] strToArray = text.toCharArray();
        for (char c : strToArray) {
            new Actions(driver).sendKeys(String.valueOf(c)).perform();
        }
    }
}
