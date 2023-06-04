package ru.netology.qamid;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.netology.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.setting.SettingLoginTest;
import ru.netology.setting.TestListener;

import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith(TestListener.class)
public class NewsPageTest extends SettingLoginTest {

    @Test
    @Step("2. Переход на экран с блоками новостей")
    @Description("Открытие и пролистывание экрана с блоками новостей")
    public void newsPageNavActions() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(30, 90, 50, driver);

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("container_list_news_include");
        //MobileElement el4 = (MobileElement) driver.findElementById("container_list_news_includ"); ADD MISTAKE

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и создание новости")
    @Description("Открытие экрана с блоками новостей и добавление новой новости с заполнением всех полей корректными значениями")
    public void addNewsWithCorrectFillingFields() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        Thread.sleep(1000);
        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Cool header", driver);

        Thread.sleep(1000);
        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("This too shall pass", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(1000);
        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals("Cool header", actual2);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и попытка создания новости с пустым полем Категория")
    @Description("Открытие экрана с блоками новостей и попытка добавления новой новости с заполнением всех полей корректными значениями. Поле Категория не заполнено")
    public void addNewsCategoryFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Cool header", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("This too shall pass", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(2000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и попытка создания новости с пустым полем Дата")
    @Description("Открытие экрана с блоками новостей и попытка добавления новой новости с заполнением всех полей корректными значениями. Поле Дата не заполнено")
    public void addNewsDateFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Cool header", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("This too shall pass", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(2000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и попытка создания новости с пустым текстовым полем")
    @Description("Открытие экрана с блоками новостей и попытка добавления новой новости с заполнением всех (кроме одного текстового поля Описание) полей корректными значениями")
    public void addNewsOneTextFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(2000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и редактирование новости")
    @Description("Открытие экрана с блоками новостей и редактирование новости с заполнением всех полей корректными значениями")
    public void changeNews() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();
        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        AuxiliaryActions.tapByCoordinates(380, 780, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Something changed", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        el12.clear();
        TextGenerator.typeText("Have a good day", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();
        Thread.sleep(2000);

        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals("Something changed", actual2);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и попытка редактирования новости с пустым полем Категория")
    @Description("Открытие экрана с блоками новостей и попытка редактирования новости с заполнением всех полей корректными значениями. Поле Категория не заполнено")
    public void changeNewsCategoryFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        el6.clear();
        Thread.sleep(1000);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Something changed", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        el12.clear();
        TextGenerator.typeText("Have a good day", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(2000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и попытка редактирования новости с пустым полем Время")
    @Description("Открытие экрана с блоками новостей и попытка редактирования новости с заполнением всех полей корректными значениями. Поле Время не заполнено")
    public void changeNewsTimeFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        AuxiliaryActions.tapByCoordinates(380, 780, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Something changed", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.clear();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        el12.clear();
        TextGenerator.typeText("Have a good day", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(2000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и попытка редактирования новости с пустым текстовым полем")
    @Description("Открытие экрана с блоками новостей и попытка редактирования новости с заполнением всех (кроме одного текстового поля Заголовок) полей корректными значениями")
    public void changeNewsOneTextFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        //MobileElement el5 = (MobileElement) driver.findElementById("ru.iteco.fmhandroid:id/edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        AuxiliaryActions.tapByCoordinates(380, 780, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        el12.clear();
        TextGenerator.typeText("Have a good day", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(2000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и удаление одного из блоков новостей")
    @Description("Открытие экрана с блоками новостей, создание новой новости и ее последующее удаление из блоков новостей")
    public void deleteNews() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        String text = "Delete this news" + AuxiliaryActions.getCurrentTime();

        TextGenerator.typeText(text, driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("This too shall pass", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();
        Thread.sleep(2000);

        Thread.sleep(1000);
        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals(text, actual2);

        Thread.sleep(1000);

        MobileElement el21 = (MobileElement) driver.findElementById("delete_news_item_image_view");
        el21.isDisplayed();
        el21.click();
        Thread.sleep(1000);
        MobileElement el22 = (MobileElement) driver.findElementById("android:id/button1");
        el22.isDisplayed();
        el22.click();
        Thread.sleep(1000);

        Thread.sleep(1000);
        MobileElement el26 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el26.isDisplayed();
        String actual3 = el26.getText();

        Assertions.assertNotEquals(actual2, actual3);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и фильтрация новостей по категории и дате публикации")
    @Description("Открытие экрана с блоками новостей, создание новой новости и фильтрация новостей по категории и дате публикации")
    public void filterNews() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        AuxiliaryActions.tapByCoordinates(380, 1090, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        String text = "Sorting and filtering news" + AuxiliaryActions.getCurrentTime();
        TextGenerator.typeText(text, driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("This too shall pass", driver);
        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(3000);

        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Thread.sleep(2000);

        //====FILTERING MODULE====//

        MobileElement el20 = (MobileElement) driver.findElementById("filter_news_material_button");
        el20.isDisplayed();
        el20.click();

        Thread.sleep(1000);

        MobileElement el21 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el21.isDisplayed();
        el21.click();

        AuxiliaryActions.tapByCoordinates(380, 950, driver);

        MobileElement el22 = (MobileElement) driver.findElementById("news_item_publish_date_start_text_input_edit_text");
        el22.isDisplayed();
        el22.click();
        Thread.sleep(1000);
        MobileElement el23 = (MobileElement) driver.findElementById("android:id/button1");
        el23.isDisplayed();
        el23.click();
        MobileElement el24 = (MobileElement) driver.findElementById("news_item_publish_date_end_text_input_edit_text");
        el24.isDisplayed();
        el24.click();
        Thread.sleep(1000);
        MobileElement el25 = (MobileElement) driver.findElementById("android:id/button1");
        el25.isDisplayed();
        el25.click();

        MobileElement el251 = (MobileElement) driver.findElementById("filter_news_inactive_material_check_box");
        el251.isDisplayed();
        el251.click();

        MobileElement el26 = (MobileElement) driver.findElementById("filter_button");
        el26.isDisplayed();
        el26.click();

        Thread.sleep(1000);

        MobileElement el29 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el29.isDisplayed();
        String actual3 = el29.getText();

        Assertions.assertEquals(actual2, actual3);

        //====DELETING MODULE (OPTIONAL)====//

        Thread.sleep(1000);
        MobileElement el37 = (MobileElement) driver.findElementById("delete_news_item_image_view");
        el37.isDisplayed();
        el37.click();
        Thread.sleep(1000);
        MobileElement el38 = (MobileElement) driver.findElementById("android:id/button1");
        el38.isDisplayed();
        el38.click();
        Thread.sleep(1000);
    }

    @Test
    @Step("2. Переход на экран с блоками новостей и сортировка по дате публикации")
    @Description("Открытие экрана с блоками новостей, создание новой новости и сортировка новостей по дате публикации")
    public void sortNews() throws InterruptedException {
        Thread.sleep(6000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);

        //====FILTERING MODULE (OPTIONAL)====//

        MobileElement el20 = (MobileElement) driver.findElementById("filter_news_material_button");
        el20.isDisplayed();
        el20.click();

        Thread.sleep(1000);

        MobileElement el21 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el21.isDisplayed();
        el21.click();
        Thread.sleep(1000);
        AuxiliaryActions.tapByCoordinates(380, 450, driver);

        MobileElement el22 = (MobileElement) driver.findElementById("news_item_publish_date_start_text_input_edit_text");
        el22.isDisplayed();
        el22.click();
        Thread.sleep(1000);
        MobileElement el23 = (MobileElement) driver.findElementById("android:id/button1");
        el23.isDisplayed();
        el23.click();
        MobileElement el24 = (MobileElement) driver.findElementById("news_item_publish_date_end_text_input_edit_text");
        el24.isDisplayed();
        el24.click();
        Thread.sleep(1000);
        MobileElement el25 = (MobileElement) driver.findElementById("android:id/button1");
        el25.isDisplayed();
        el25.click();

        MobileElement el26 = (MobileElement) driver.findElementById("filter_button");
        el26.isDisplayed();
        el26.click();

        Thread.sleep(1000);

        //====SORTING MODULE====//

        MobileElement el29 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el29.isDisplayed();
        String actual3 = el29.getText();


        MobileElement el30 = (MobileElement) driver.findElementById("sort_news_material_button");
        el30.isDisplayed();
        el30.click();

        Thread.sleep(1000);
        AuxiliaryActions.verticalSwipeByPercentages(40, 90, 50, driver);

        MobileElement el32 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el32.isDisplayed();
        String actual4 = el32.getText();

        Assertions.assertNotEquals(actual3, actual4);
    }
}
