package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private WebDriver driver;
    private final By dateInput = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");//поле для выбота даты - "Когда привезти самокат"
    private final By twentySevenDecember = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--027 react-datepicker__day--selected']");//локатор для конкретной даты - 27.12.2023
    private final By rentTimeDropDown = By.className("Dropdown-placeholder"); //поле для выбора срока аренды
    private final By [] rentTimeValues = {By.xpath(".//*[text()='сутки']"),
            By.xpath(".//*[text()='двое суток']"),
            By.xpath(".//*[text()='трое суток']"),
            By.xpath(".//*[text()='четверо суток']"),
            By.xpath(".//*[text()='пятеро суток']"),
            By.xpath(".//*[text()='шестеро суток']")}; //массив со значениями для поля срока аренды
    private final By [] colourValues = {By.id("black"), By.id("grey")};//массив со значениями цвета самоката
    private final By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']"); //поле для ввода комментария к заказу
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() ='Заказать']"); //кнопка "Заказать"

    public AboutRentPage(WebDriver driver){
        this.driver = driver;
    }

    //метод для заполнения данных на странице "Про аренду"
    public void fillAboutRentData(String date, int index, int i, String comment){
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(twentySevenDecember).click();
        driver.findElement(rentTimeDropDown).click();
        driver.findElement(rentTimeValues[index]).click();
        driver.findElement(colourValues[index]).click();
        driver.findElement(commentInput).sendKeys(comment);
        driver.findElement(orderButton).click();
    }

}
