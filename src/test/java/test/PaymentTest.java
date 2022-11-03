package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataBase;
import data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import page.TourPage;


import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {
    private static String url = System.getProperty("sut.url");

    @BeforeEach
    public void setup() {
        open(url);
    }

    @BeforeAll
    static void setupAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void clearAll() {
        DataBase.clearAll();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Payment with approved card")
    public void WithApprovedCard() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getApprovedCard());
        form.pushContinueButton();
        form.massageSuccess();
        assertEquals("APPROVED", DataBase.getPaymentStatus());
    }

    @Test
    @DisplayName("Payment with approved card, card holder with defies")
    public void WithApprovedCardHolderWithDefies() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardHolder());
        form.setCardHolder("Ivanov-Krutov Ivan");
        form.pushContinueButton();
        form.massageSuccess();
        assertEquals("APPROVED", DataBase.getPaymentStatus());
    }

    @Test
    @DisplayName("Payment with declined card")
    public void WithDeclinedCard() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getDeclinedCard());
        form.pushContinueButton();
        form.massageError();
        assertEquals("DECLINED", DataBase.getPaymentStatus());
    }

    @Test
    @DisplayName("Latin in card number")
    public void WithLatInCardNumber() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardNumber());
        form.setCardNumber("444444444444444D");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }

    @Test
    @DisplayName("Cyrillic in card number")
    public void WithCyrillicInCardNumber() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardNumber());
        form.setCardNumber("444444444444444Д");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }

    @Test
    @DisplayName("Card number with special characters")
    public void WithSpecCharInCardNumber() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardNumber());
        form.setCardNumber("444444444444444!");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }

    @Test
    @DisplayName("Cyrillic in card holder")
    public void WithCyrillicInCardHolder() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardHolder());
        form.setCardHolder("Иванов Иван");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("1 word in  card holder")
    public void With1WordInCardHolder() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardHolder());
        form.setCardHolder("Ivanov");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }

    @Test
    @DisplayName("Card holder with numbers")
    public void WithNumbersInCardHolder() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardHolder());
        form.setCardHolder("Iv4nov Iv4n");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }

    @Test
    @DisplayName("Card holder with special characters")
    public void WithSpecCharInCardHolder() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardHolder());
        form.setCardHolder("Iv!nov Iv!n");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Latin in month")
    public void WithLatInCardMonth() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyMonthNumber());
        form.setCardMonth("m1");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Cyrillic in month")
    public void WithCyrInCardMonth() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyMonthNumber());
        form.setCardMonth("м1");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Special characters in month")
    public void WithSpecCharInCardMonth() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyMonthNumber());
        form.setCardMonth("*1");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("1 number in month")
    public void WithOneNumberInCardMonth() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyMonthNumber());
        form.setCardMonth("1");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("'00' in month")
    public void With00InCardMonth() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyMonthNumber());
        form.setCardMonth("00");
        form.pushContinueButton();
        form.massageWrongCardValidity();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Value above 12 in month")
    public void WithValueAbove12InCardMonth() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyMonthNumber());
        form.setCardMonth("14");
        form.pushContinueButton();
        form.massageWrongCardValidity();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Latin in year")
    public void WithLatInCardYear() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyYearNumber());
        form.setCardYear("y3");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Cyrillic in year")
    public void WithCyrInCardYear() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyYearNumber());
        form.setCardYear("г3");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Year with special characters")
    public void WithSpecCharInCardYear() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyYearNumber());
        form.setCardYear("!3");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Value in year less than the current year")
    public void WithLessCurYearInCardYear() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyYearNumber());
        form.setCardYear("20");
        form.pushContinueButton();
        form.massageExpiredCardValidity();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("1 number in year")
    public void WithOneNumberInCardYear() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyYearNumber());
        form.setCardYear("3");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Cyrillic in 'CVC/CVV'")
    public void WithCyrInCardCVCCVV() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCvcCvvNumber());
        form.setCardCvcCvv("12Ц");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Latin in 'CVC/CVV'")
    public void WithLatInCardCVCCVV() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCvcCvvNumber());
        form.setCardCvcCvv("12D");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Special characters in 'CVC/CVV'")
    public void WithSpecCharInCardCVCCVV() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCvcCvvNumber());
        form.setCardCvcCvv("12!");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("2 numbers in 'CVC/CVV'")
    public void WithTwoNumbersInCardCVCCVV() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCvcCvvNumber());
        form.setCardCvcCvv("12");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("1 number in 'CVC/CVV'")
    public void WithOneNumbersInCardCVCCVV() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCvcCvvNumber());
        form.setCardCvcCvv("1");
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Empty card number")
    public void WithEmptyCardNumber() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardNumber());
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Empty month")
    public void WithEmptyCardMonth() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyMonthNumber());
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Empty year")
    public void WithEmptyCardYear() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyYearNumber());
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Empty card holder")
    public void WithEmptyCardHolder() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCardHolder());
        form.pushContinueButton();
        form.massageRequiredField();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Empty 'CVC/CVV")
    public void WithEmptyCardCvcCvv() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCvcCvvNumber());
        form.pushContinueButton();
        form.massageWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
    @Test
    @DisplayName("Empty form")
    public void WithEmptyForm() {
        val tp = new TourPage();
        val form = tp.goToBuyPage();
        form.inputData(DataHelper.getEmptyCard());
        form.pushContinueButton();
        form.massageAllWrongFormat();
        assertEquals("0", DataBase.getOrderCount());
    }
}
