package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ForWhoScooterPage {
    private WebDriver driver;

    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']"); //поле для ввода имени
    private final By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']"); //поле для ввода фамилии
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //поле для ввода адреса
    private final By metroInput = By.className("select-search");//поле для выбора станции метро
    private final By station = By.className("select-search__row");//локатор для конкретной станции метро

    private final By phoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //поле для ввода номера телефона
    private final By nextButton = By.className("Button_Middle__1CSJM"); //кнопка "Далее"

    public ForWhoScooterPage(WebDriver driver){
        this.driver = driver;
    }

    //метод для заполнения данных на странице "Для кого самокат"
    public void fillForWhoData(String name, String surname, String address, int metroNumber, String phoneNumber){
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(surnameInput).sendKeys(surname);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroInput).click();
        List <WebElement> stations = driver.findElements(station);
        stations.get(metroNumber).click();
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        driver.findElement(nextButton).click();
    }



}

