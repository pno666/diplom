package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class TourPage {
    private SelenideElement heading = $$("h2").find(Condition.text("Путешествие дня"));
    private SelenideElement buyButton = $$(".button__content").find(exactText("Купить"));
    private SelenideElement creditButton = $$(".button__content").find(exactText("Купить в кредит"));

    public TourPage() {
        heading.shouldBe(visible);
    }

    public BuyPage goToBuyPage() {
        buyButton.click();
        return new BuyPage();
    }

    public CreditPage goToCreditPage() {
        creditButton.click();
        return new CreditPage();
    }
}
