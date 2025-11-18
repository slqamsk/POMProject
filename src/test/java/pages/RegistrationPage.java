package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPage {
    SelenideElement
        flightInfo = $("#flightRegistrationInfo"),
        buttonFinishRegistration = $x("//button[contains(.,'Завершить регистрацию')]");

    public void isFlightDataCorrect(String cityFrom, String cityTo) {
        flightInfo
            .shouldBe(visible)
            .shouldHave(text(cityFrom + " → " + cityTo));
    }

    public void successRegistration() {
        buttonFinishRegistration.click();
        Alert alert= switchTo().alert();
        assertTrue(alert.getText().contains("Бронирование завершено"));
        alert.accept();
        $("#registrationMessage").shouldHave(text("Регистрация успешно завершена!"));
    }
}
