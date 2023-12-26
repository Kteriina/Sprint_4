package ru.yandex.praktikum.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class TestOrder {
    WebDriver driver;

    @BeforeClass
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setup(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void checkOrderFromHeader() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создание объекта класса главной страницы приложения
        HomePageScooter objHomePage = new HomePageScooter(driver);

        // клик на кнопку куки
        objHomePage.clickButtonCookie();

        //клик на кнопку "Заказать" в заголовке страницы
        objHomePage.clickButtonOrderHeader();

        //возможно ожидание здесь сделать

        // создание объекта класса ForWhoScooterPage страницы "Для кого самокат"
        ForWhoScooterPage objForWho = new ForWhoScooterPage(driver);
        objForWho.fillForWhoData("Катя", "Воронина", "Москва", 1, "89616137854");//заполнение данных на странице "Для кого самокат"

        // создание объекта класса AboutRent страницы "Про аренду"
        AboutRentPage objRentPage = new AboutRentPage(driver);
        objRentPage.fillAboutRentData("27.12.2023", 1, 1, "Comment");//заполнение данных на странице "Про аренду"

        // создание объекта класса SubmitPopUp попапа, появляющегося после нажатия "Заказать" на странице "Про аренду"
        SubmitPopUp objSubmitPopUp = new SubmitPopUp(driver);

        //клик на кнопку подтверждения заказа
        objSubmitPopUp.clickSubmitOrderButton();

        //проверка, что заказ создаз оформлен - появился текст "Заказ оформлен"
        objSubmitPopUp.successOrderMessageDisplays();


    }

    @Test
    public void checkOrderFromBelow() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создай объект класса главной страницы приложения
        HomePageScooter objHomePage = new HomePageScooter(driver);

        // клик на кнопку куки
        objHomePage.clickButtonCookie();

        //скрол до кнопки "Заказать" внизу страницы
        objHomePage.scrollButtonOrderBelow();

        //клик на кнопку "Заказать" внизу страницы
        objHomePage.clickButtonOrderBelow();

        //возможно ожидание здесь сделать

        // создание объекта класса ForWhoScooterPage страницы "Для кого самокат"
        ForWhoScooterPage objForWho = new ForWhoScooterPage(driver);
        objForWho.fillForWhoData("Маргарита", "Иванова", "Москва набережная Бережковская", 34, "89018337854");//заполнение данных на странице "Для кого самокат"

        // создание объекта класса SubmitPopUp попапа, появляющегося после нажатия "Заказать" на странице "Про аренду"
        AboutRentPage objRentPage = new AboutRentPage(driver);
        objRentPage.fillAboutRentData("27.12.2023", 0, 3, "Хотелось бы быструю доставку");//заполнение данных на странице "Про аренду"

        // создание объекта класса SubmitPopUp попапа, появляющегося после нажатия "Заказать" на странице "Про аренду"
        SubmitPopUp objSubmitPopUp = new SubmitPopUp(driver);

        //клик на кнопку подтверждения заказа
        objSubmitPopUp.clickSubmitOrderButton();

        //проверка, что заказ создаз оформлен - появился текст "Заказ оформлен"
        objSubmitPopUp.successOrderMessageDisplays();



    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}