package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitPopUp {
    private WebDriver driver;
    private final By submitOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() ='Да']"); //кнопка "Да" для подтверждения заказа
    private final By successOrderMessage = By.xpath(".//*[text()='Заказ оформлен']"); //сообщение об успешном заказе
    public SubmitPopUp(WebDriver driver){
        this.driver = driver;

    }
    //кликнуть на кнопку "Да" для подтверждения заказа
    public void clickSubmitOrderButton(){

        driver.findElement(submitOrderButton).click();
    }

    //проверка, что сообщение "Заказ оформлен"  появляется
    public void successOrderMessageDisplays(){

        driver.findElement(successOrderMessage).isDisplayed();
    }
}

