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
public class ClaimsPageTest extends SettingLoginTest {

//    public AndroidDriver driver;
//
//    @BeforeEach
//    public void setUp() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("appium:deviceName", "API29");
//        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
//        desiredCapabilities.setCapability("appium:appPackage", "ru.iteco.fmhandroid");
//        desiredCapabilities.setCapability("appium:appActivity", "ru.iteco.fmhandroid.ui.AppActivity");
//        desiredCapabilities.setCapability("appium:unicodeKeyboard", true);
//        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//
//        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//
//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//
//        Thread.sleep(6000);
//
//        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
//        el1.isDisplayed();
//        el1.click();
//        TextGenerator.typeText("login2", driver);
//
//        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
//        el2.isDisplayed();
//        el2.click();
//        TextGenerator.typeText("password2", driver);
//
//        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
//        el3.isDisplayed();
//        el3.click();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    @Step("2. Переход на экран с блоками претензий")
    @Description("Открытие и пролистывание экрана с блоками претензий")
    public void claimsPageNavActions() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(30, 90, 50, driver);

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и создание претензии")
    @Description("Открытие экрана с блоками претензий и добавление новой претензии с заполнением всех полей корректными значениями")
    public void addNewClaimWithCorrectFillingFields() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("add_new_claim_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(1000);

        MobileElement el5 = (MobileElement) driver.findElementById("title_edit_text");
        el5.isDisplayed();
        TextGenerator.typeText("New claim", driver);

        MobileElement el6 = (MobileElement) driver.findElementById("executor_drop_menu_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        TextGenerator.typeText("John Galt", driver);

        MobileElement el7 = (MobileElement) driver.findElementById("date_in_plan_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        Thread.sleep(1000);
        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
        el8.isDisplayed();
        el8.click();

        MobileElement el9 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("description_edit_text");
        el11.isDisplayed();
        el11.click();
        TextGenerator.typeText("New claim description", driver);

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(1000);
        MobileElement el13 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и попытка создания претензии с пустым полем Nсполнитель")
    @Description("Открытие экрана с блоками претензий и попытка добавления новой претензии с заполнением всех полей корректными значениями. Поле Nсполнитель не заполнено")
    public void addNewClaimExecutorFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("add_new_claim_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(1000);

        MobileElement el5 = (MobileElement) driver.findElementById("title_edit_text");
        el5.isDisplayed();
        TextGenerator.typeText("New claim", driver);


        MobileElement el7 = (MobileElement) driver.findElementById("date_in_plan_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        Thread.sleep(1000);
        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
        el8.isDisplayed();
        el8.click();

        MobileElement el9 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("description_edit_text");
        el11.isDisplayed();
        el11.click();
        TextGenerator.typeText("New claim description", driver);

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);
        MobileElement el13 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и попытка создания претензии с пустым текстовым полем")
    @Description("Открытие экрана с блоками претензий и попытка добавления новой претензии с заполнением всех (кроме одного текстового поля Описание) полей корректными значениями")
    public void addNewClaimOneTextFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("add_new_claim_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(1000);

        MobileElement el5 = (MobileElement) driver.findElementById("title_edit_text");
        el5.isDisplayed();
        TextGenerator.typeText("New claim", driver);

        MobileElement el6 = (MobileElement) driver.findElementById("executor_drop_menu_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        TextGenerator.typeText("John Galt", driver);

        MobileElement el7 = (MobileElement) driver.findElementById("date_in_plan_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        Thread.sleep(1000);
        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
        el8.isDisplayed();
        el8.click();

        MobileElement el9 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("description_edit_text");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);

        MobileElement el13 = (MobileElement) driver.findElementById("android:id/message");
        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);

        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("cancel_button");
        el15.click();
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и попытка создания претензии с пустым полем Дата")
    @Description("Открытие экрана с блоками претензий и попытка добавления новой претензии с заполнением всех полей корректными значениями. Поле Дата не заполнено")
    public void addNewClaimDateFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("add_new_claim_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(1000);

        MobileElement el5 = (MobileElement) driver.findElementById("title_edit_text");
        el5.isDisplayed();
        TextGenerator.typeText("New claim", driver);

        MobileElement el6 = (MobileElement) driver.findElementById("executor_drop_menu_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        TextGenerator.typeText("John Galt", driver);

        MobileElement el9 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("description_edit_text");
        el11.isDisplayed();
        el11.click();
        TextGenerator.typeText("New claim description", driver);

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);

        MobileElement el13 = (MobileElement) driver.findElementById("android:id/message");
        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);

        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("cancel_button");
        el15.click();
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и изменение статуса одной из них")
    @Description("Открытие экрана с блоками претензий, фильтрация претензий по статусу, изменение статуса одной из претензий")
    public void changeClaimStatus() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el31 = (MobileElement) driver.findElementById("filters_material_button");
        el31.isDisplayed();
        el31.click();

        Thread.sleep(1000);
        //MobileElement el32 = (MobileElement) driver.findElementById("item_filter_in_progress");
        MobileElement el32 = (MobileElement) driver.findElementById("item_filter_open");
        el32.isDisplayed();
        el32.click();
        MobileElement el33 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el33.isDisplayed();
        el33.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el41 = (MobileElement) driver.findElementById("title_text_view");
        el41.isDisplayed();
        String actual1 = el41.getText();

        MobileElement el5 = (MobileElement) driver.findElementById("status_processing_image_button");
        el5.isDisplayed();
        el5.click();
        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(1000);

        MobileElement el9 = (MobileElement) driver.findElementById("editText");
        el9.isDisplayed();
        el9.click();
        TextGenerator.typeText("done", driver);
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(1000);

        MobileElement el11 = (MobileElement) driver.findElementById("close_image_button");
        el11.isDisplayed();
        el11.click();

        AuxiliaryActions.verticalSwipeByPercentages(40, 90, 50, driver);
        Thread.sleep(1000);

        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el12.isDisplayed();
        el12.click();

        MobileElement el13 = (MobileElement) driver.findElementById("title_text_view");
        el13.isDisplayed();
        String actual2 = el13.getText();

        Thread.sleep(1000);

        Assertions.assertNotEquals(actual1, actual2);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и редактирование одной из претензий")
    @Description("Открытие экрана с блоками претензий и редактирование одной из претензий")
    public void changeClaimTextFields() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(2000);

        MobileElement el71 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el71.isDisplayed();
        el71.click();

        MobileElement el8 = (MobileElement) driver.findElementById("edit_processing_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);

        MobileElement el9 = (MobileElement) driver.findElementById("title_edit_text");
        el9.isDisplayed();
        el9.click();
        el9.clear();
        TextGenerator.typeText("add change to claim", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("executor_drop_menu_auto_complete_text_view");
        el10.isDisplayed();
        el10.click();
        el10.clear();
        TextGenerator.typeText("John Galt", driver);

        MobileElement el15 = (MobileElement) driver.findElementById("description_edit_text");
        el15.isDisplayed();
        el15.click();
        el15.clear();
        TextGenerator.typeText("add change to claim description", driver);

        MobileElement el16 = (MobileElement) driver.findElementById("save_button");
        el16.isDisplayed();
        el16.click();

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el17 = (MobileElement) driver.findElementById("close_image_button");
        el17.isDisplayed();
        el17.click();

        AuxiliaryActions.verticalSwipeByPercentages(40, 90, 50, driver);
        Thread.sleep(1000);

        MobileElement el18 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el18.isDisplayed();
        el18.click();

        MobileElement el19 = (MobileElement) driver.findElementById("title_text_view");
        el19.isDisplayed();
        String actual2 = el19.getText();

        Thread.sleep(1000);

        Assertions.assertEquals("add change to claim", actual2);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и попытка редактирования претензии с пустым текстовым полем")
    @Description("Открытие экрана с блоками претензий, фильтрация претензий по статусу и попытка редактирования претензии с заполнением всех (кроме одного текстового поля Заголовок) полей корректными значениями")
    public void changeClaimTextFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(1000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        MobileElement el8 = (MobileElement) driver.findElementById("edit_processing_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);

        MobileElement el9 = (MobileElement) driver.findElementById("title_edit_text");
        el9.isDisplayed();
        el9.clear();

        MobileElement el16 = (MobileElement) driver.findElementById("save_button");
        el16.isDisplayed();
        el16.click();

        Thread.sleep(2000);

        MobileElement el17 = (MobileElement) driver.findElementById("android:id/message");
        boolean actual = el17.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и попытка редактирования претензии с пустым полем Время")
    @Description("Открытие экрана с блоками претензий, фильтрация претензий по статусу и попытка редактирования претензии с заполнением всех полей корректными значениями. Поле Время не заполнено")
    public void changeClaimTimeFieldIsEmpty() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(1000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        MobileElement el8 = (MobileElement) driver.findElementById("edit_processing_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el13.isDisplayed();
        el13.clear();

        MobileElement el16 = (MobileElement) driver.findElementById("save_button");
        el16.isDisplayed();
        el16.click();

        Thread.sleep(2000);

        MobileElement el17 = (MobileElement) driver.findElementById("android:id/message");
        boolean actual = el17.isDisplayed();
        Assertions.assertTrue(actual);

        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("cancel_button");
        el15.click();
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и попытка фильтрации претензий")
    @Description("Открытие экрана с блоками претензий и попытка фильтрации претензий при отсутствии выбранных параметров")
    public void filterClaimsByStatusCheckboxesAreEmpty() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_open");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el6.isDisplayed();
        el6.click();

        MobileElement el7 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el7.isDisplayed();
        el7.click();

        Thread.sleep(2000);
        MobileElement el8 = (MobileElement) driver.findElementById("empty_claim_list_text_view");
        boolean actual = el8.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и добавление комментария к претензии")
    @Description("Открытие экрана с блоками претензий, фильтрация претензий по статусу и добавления комментария к претензии")
    public void addCommentToClaim() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(1000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        MobileElement el8 = (MobileElement) driver.findElementById("add_comment_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        el9.isDisplayed();
        el9.click();
        TextGenerator.typeText("Very important comment", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Very important comment\")");
        el11.isDisplayed();
        el11.click();
        String actual = el11.getText();
        Assertions.assertEquals("Very important comment", actual);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и попытка добавления комментария к претензии")
    @Description("Открытие экрана с блоками претензий, фильтрация претензий по статусу и попытка добавления пустого комментария к претензии")
    public void addEmptyCommentToClaim() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(2000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        MobileElement el8 = (MobileElement) driver.findElementById("add_comment_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(2000);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(2000);

        MobileElement el11 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el11.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и изменения комментария к претензии")
    @Description("Открытие экрана с блоками претензий, фильтрация претензий по статусу, создание комментария и редактирование ранее созданного комментария к претензии")
    public void changeCommentToClaim() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(2000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 30, driver);

        MobileElement el8 = (MobileElement) driver.findElementById("add_comment_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("comment_text_input_layout");
        el9.isDisplayed();
        el9.click();
        TextGenerator.typeText("Very important comment", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("edit_comment_image_button");
        el11.isDisplayed();
        el11.click();

        Thread.sleep(1000);
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        el12.isDisplayed();
        el12.clear();
        el12.click();
        TextGenerator.typeText("New very important comment", driver);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(1000);
        MobileElement el14 = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"New very important comment\")");
        el14.isDisplayed();
        el14.click();
        String actual = el14.getText();

        Assertions.assertEquals("New very important comment", actual);
    }

    @Test
    @Step("2. Переход на экран с блоками претензий и попытка изменения комментария к претензии")
    @Description("Открытие экрана с блоками претензий, фильтрация претензий по статусу, создание комментария и редактирование ранее созданного комментария к претензии путем очистки поля")
    public void changeToEmptyCommentToClaim() throws InterruptedException {
        Thread.sleep(6000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(2000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 30, driver);

        MobileElement el8 = (MobileElement) driver.findElementById("add_comment_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("comment_text_input_layout");
        el9.isDisplayed();
        el9.click();
        TextGenerator.typeText("Not a great comment", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("edit_comment_image_button");
        el11.isDisplayed();
        el11.click();

        Thread.sleep(1000);
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        el12.isDisplayed();
        el12.clear();

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(2000);

        MobileElement el14 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el14.isDisplayed();
        Assertions.assertTrue(actual);
    }
}
