package ru.yandex.praktikum.scooter;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestQuestionsSection {
    WebDriver driver;
    private int index;
    private String text;

    public TestQuestionsSection(int index, String text){

        this.index = index;
        this.text = text;

    };

    @Parameterized.Parameters
    public static Object[][] dataToTest() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

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
    public void checkQuestionsSection() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создание объекта класса главной страницы приложения
        HomePageScooter objHomePage = new HomePageScooter(driver);

        // клик на кнопку куки
        objHomePage.clickButtonCookie();

        //скролл страницы до раздела "Вопросы о важном"
        objHomePage.scrollToQuestions();

        //возможно ожидание здесь сделать

        // кликнуть на элемент в списке в разделе «Вопросы о важном»
        objHomePage.clickDropDownList(index);
        // проверить что текст отобразился
        assertEquals(text,objHomePage.checkDropDownText(index));
    }


    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
