package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class FormPage {
//    private static String url = System.getProperty("db.url");
//    private static String appURL = System.getProperty("app.url");
//    private static String appPORT = System.getProperty("app.port");
//    private static String userDB = System.getProperty("app.userDB");
//    private static String password = System.getProperty("app.password");
    private SelenideElement buyButton = $$(".button__content").find(exactText("Купить"));
    private SelenideElement creditButton = $$(".button__content").find(exactText("Купить в кредит"));
    private SelenideElement wrongFormat = $$(".input__sub").find(exactText("Неверный формат"));
    private SelenideElement expiredValidity = $$(".input__sub").find(exactText("Истек срок действия карты"));
    private SelenideElement wrongRequiredField = $$(".input__sub")
            .find(exactText("Поле обязательно для заполнения"));
    private SelenideElement wrongValidity = $$(".input__sub")
            .find(exactText("Неверно указан срок действия карты"));
    private SelenideElement successSend = $$(".notification__title").find(exactText("Успешно"));
    private SelenideElement errorSend = $$("notification__title").find(exactText("Ошибка"));
    private SelenideElement continueButton = $$(".button_content").find(exactText("Продолжить"));
    List<SelenideElement> input = $$(".input__control");
    SelenideElement cardNumber = input.get(0);
    SelenideElement monthNumber = input.get(1);
    SelenideElement yearNumber = input.get(2);
    SelenideElement cardowner = input.get(3);
    SelenideElement cvcCvv = input.get(4);

    public void openBuyForMoney() {
        buyButton.click();
    }
    public void openBuyOnCredit() {
        creditButton.click();
    }
    public void massageWrongFormat() {
        wrongFormat.shouldBe(visible);
    }
    public void massageRequiredField() {
        wrongRequiredField.shouldBe(visible);
    }
    public void massageExpiredCardValidity() {
        expiredValidity.shouldBe(visible);
    }
    public void massageWrongCardValidity() {
        wrongValidity.shouldBe(visible);
    }
    public void massageSuccess() {
        successSend.shouldBe(visible, Duration.ofSeconds(15000));
    }
    public void massageError() {
        errorSend.shouldBe(visible, Duration.ofSeconds(15000));
    }
    public void setCardNumber(String cNumber) {
        cardNumber.setValue(cNumber);
    }
    public void setCardMonth(String cMonth) {
        monthNumber.setValue(cMonth);
    }
    public void setCardYear(String cYear) {
        yearNumber.setValue(cYear);
    }
    public void setCardowner(String cOwner) {
        cardowner.setValue(cOwner);
    }
    public void setCardCvcCvv(String cCvcCvv) {
        cvcCvv.setValue(cCvcCvv);
    }
    public void pushContinueButton() {
        continueButton.click();
    }
}
