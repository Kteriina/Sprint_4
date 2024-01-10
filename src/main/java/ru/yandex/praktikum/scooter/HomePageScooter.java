package ru.yandex.praktikum.scooter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageScooter {
    private WebDriver driver;

    private By buttonOrderHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']"); //кнопка «Заказать» вверху страницы
    private By buttonOrderBelow = By.className("Button_Middle__1CSJM"); //кнопка «Заказать» внизу страницы
    private By buttonCookie = By.id("rcc-confirm-button"); //кнопка для куки "да все привыкли"

    private final String dropDownList = "accordion__heading-%d";//локатор для элемента списка "Вопросы о важном"

    private final String dropDownText = "accordion__panel-%d";//локатор для текста соответствующего элементу списка "Вопросы о важном"

    public HomePageScooter(WebDriver driver){
        this.driver = driver;

    }
    //метод скролла страницы до раздела "Вопросы о важном"
    public void scrollToQuestions(){
        WebElement element = driver.findElement(By.id(String.format(dropDownList, 0)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод нажатия на кнопку куки "да все привыкли" - buttonCookie
    public void clickButtonCookie(){
        driver.findElement(buttonCookie).click();
    }

    //Метод нажатия на кнопку «Заказать» вверху страницы - buttonOrderBelow
    public void clickButtonOrderHeader(){


        driver.findElement(buttonOrderHeader).click();
    }

    //метод скролла страницы до «Заказать» внизу страницы - buttonOrderBelow
    public void scrollButtonOrderBelow(){
        WebElement element = driver.findElement(buttonOrderBelow);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод нажатия на кнопку «Заказать» внизу страницы - buttonOrderBelow
    public void clickButtonOrderBelow(){
        driver.findElement(buttonOrderBelow).click();
    }

    //Метод нажатия на элемент в списке в разделе «Вопросы о важном» - dropDownList
    public void clickDropDownList(int index){
        driver.findElement(By.id(String.format(dropDownList, index))).click();
    }

    //Метод проверки, что отображается текст после нажатия на элемент в списке в разделе «Вопросы о важном» - dropDownText
    public String checkDropDownText(int index){
        driver.findElement(By.id(String.format(dropDownText, index))).isDisplayed();
        return driver.findElement(By.id(String.format(dropDownText, index))).getText();
    }

}
