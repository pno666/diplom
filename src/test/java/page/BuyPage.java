package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Card;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class BuyPage {
    private SelenideElement heading = $$("h3").find(exactText("Оплата по карте"));
    private SelenideElement wrongFormat = $$(".input__sub").find(exactText("Неверный формат"));
    private ElementsCollection allWrongFormat = $$(byText("Неверный формат"));
    private SelenideElement expiredValidity = $(byText("Истёк срок действия карты"));
    private SelenideElement wrongRequiredField = $$(".input__sub")
            .find(exactText("Поле обязательно для заполнения"));
    private SelenideElement wrongValidity = $$(".input__sub")
            .find(exactText("Неверно указан срок действия карты"));
    private SelenideElement successSend = $$(".notification__title").find(exactText("Успешно"));
    private SelenideElement errorSend = $(byText("Ошибка! Банк отказал в проведении операции.")).parent().$("[class=\"notification__content\"]");
    private SelenideElement continueButton = $$(".button__content").find(exactText("Продолжить"));
    List<SelenideElement> input = $$(".input__control");
    SelenideElement cardNumber = input.get(0);
    SelenideElement monthNumber = input.get(1);
    SelenideElement yearNumber = input.get(2);
    SelenideElement cardHolder = input.get(3);
    SelenideElement cvcCvv = input.get(4);

    public BuyPage() {
        heading.shouldBe(visible);
    }


    public void inputData(Card card) {
        cardNumber.setValue(card.getCardNumber());
        monthNumber.setValue(card.getMonth());
        yearNumber.setValue(card.getYear());
        cardHolder.setValue(card.getCardHolder());
        cvcCvv.setValue(card.getCvcCvv());
    }

    public void massageWrongFormat() {
        wrongFormat.shouldBe(visible);
    }

    public void massageAllWrongFormat() {
        allWrongFormat.shouldHaveSize(4);
        wrongRequiredField.waitUntil(visible, 15000);
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
        successSend.waitUntil(visible, 15000);
    }

    public void massageError() {
        errorSend.waitUntil(visible, 15000);
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

    public void setCardHolder(String cHolder) {
        cardHolder.setValue(cHolder);
    }

    public void setCardCvcCvv(String cCvcCvv) {
        cvcCvv.setValue(cCvcCvv);
    }

    public void pushContinueButton() {
        continueButton.click();
    }
}
