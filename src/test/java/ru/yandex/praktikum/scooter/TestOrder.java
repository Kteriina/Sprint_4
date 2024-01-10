package ru.yandex.praktikum.scooter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestOrder extends CommonTest{
    private final String name;
    private final String surname;
    private final String address;
    private final int metroNumber;
    private final String phoneNumber;
    private final String date;
    private final int indexOfRentTime;
    private final int indexOfColour;
    private final String comment;

    final String SCOOTER_APP = "https://qa-scooter.praktikum-services.ru/";

    @Parameterized.Parameters
    public static Object[][] setOrderData() {
        return new Object[][] {

                {"Катя", "Воронина", "Москва", 1, "89616137854","27.12.2023", 1, 1, "Comment"},
                {"Маргарита", "Иванова", "Москва набережная Бережковская", 34, "89018337854", "27.12.2023", 0, 1, "Хотелось бы быструю доставку"},


        };
    }
    public TestOrder(String name, String surname, String address, int metroNumber, String phoneNumber, String date, int indexOfRentTime, int indexOfColour, String comment){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroNumber = metroNumber;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.indexOfRentTime = indexOfRentTime;
        this.indexOfColour = indexOfColour;
        this.comment = comment;


    };

    @Test
    public void checkOrderFromHeader() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get(SCOOTER_APP);

        // создание объекта класса главной страницы приложения
        HomePageScooter objHomePage = new HomePageScooter(driver);

        // клик на кнопку куки
        objHomePage.clickButtonCookie();

        //клик на кнопку "Заказать" в заголовке страницы
        objHomePage.clickButtonOrderHeader();

        //возможно ожидание здесь сделать

        // создание объекта класса ForWhoScooterPage страницы "Для кого самокат"
        ForWhoScooterPage objForWho = new ForWhoScooterPage(driver);
        objForWho.fillForWhoData(name, surname, address, metroNumber, phoneNumber);//заполнение данных на странице "Для кого самокат"

        // создание объекта класса AboutRent страницы "Про аренду"
        AboutRentPage objRentPage = new AboutRentPage(driver);
        objRentPage.fillAboutRentData(date, indexOfRentTime, indexOfColour, comment);//заполнение данных на странице "Про аренду"

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
        driver.get(SCOOTER_APP);

        // создай объект класса главной страницы приложения
        HomePageScooter objHomePage = new HomePageScooter(driver);

        // клик на кнопку куки
        objHomePage.clickButtonCookie();

        //скрол до кнопки "Заказать" внизу страницы
        objHomePage.scrollButtonOrderBelow();

        //клик на кнопку "Заказать" внизу страницы
        objHomePage.clickButtonOrderBelow();

        // создание объекта класса ForWhoScooterPage страницы "Для кого самокат"
        ForWhoScooterPage objForWho = new ForWhoScooterPage(driver);

        //проверка, что страница "Для кого заказ" отобразилась
        objForWho.forWhoScooterPageDisplays();
    }


}