package ru.yandex.praktikum.scooter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestQuestionsSection extends CommonTest {
    private int index;
    private String text;

    public TestQuestionsSection(int index, String text){

        this.index = index;
        this.text = text;

    };

    @Parameterized.Parameters
    public static Object[][] getMessageText() {
        return new Object[][] {

                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}

        };
    }


    @Test
    public void checkQuestionsSection() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

}
