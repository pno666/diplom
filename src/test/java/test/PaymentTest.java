package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.Card;
import data.DataBase;
import data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import page.BuyPage;
import page.TourPage;


import static com.codeborne.selenide.Selenide.open;

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
    @DisplayName(" Оплата по активной карте с валидными данными")
    public void shouldPayWithApprovedCard() {
        TourPage tourPage = new TourPage();
        val pay = tourPage.goToBuyPage();
        pay.inputData(DataHelper.getApprovedCard());
        pay.pushContinueButton();
        pay.massageSuccess();
        Assertions.assertEquals("APPROVED", DataBase.getPaymentStatus());
    }

//    @Test
//    @DisplayName(" Оплата по активной карте с валидными данными, поле имя содержит дефис")
//    public void shouldPayWithApprovedCardOwnerWithDefies() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner("Ivanov-Krutov Ivan");
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageSuccess();
//    }
//
    @Test
    @DisplayName(" Оплата по неактивной карте с валидными данными")
    public void shouldPayWithDeclinedCard() {
        TourPage tourPage = new TourPage();
        val pay = tourPage.goToBuyPage();
        pay.inputData(DataHelper.getDeclinedCard());
        pay.pushContinueButton();
        pay.massageError();
        Assertions.assertEquals("DECLINED", DataBase.getPaymentStatus());
    }
//
//    @Test
//    @DisplayName(" Заполнение поля 'Номер карты' данными, содержащие латиницу")
//    public void shouldPayWithLatInCardNumber() {
//        form.setCardNumber("444444444444444D");
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//
//    @Test
//    @DisplayName(" Заполнение поля 'Номер карты' данными, содержащие кириллицу")
//    public void shouldPayWithKirInCardNumber() {
//        form.setCardNumber("444444444444444Д");
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//
//    @Test
//    @DisplayName(" Заполнение поля 'Номер карты' данными, содержащие спец.символы")
//    public void shouldPayWithSpecSymbolInCardNumber() {
//        form.setCardNumber("444444444444!");
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//
//    @Test
//    @DisplayName(" Заполнение поля 'Владелец' данными, содержащие кириллицу")
//    public void shouldPayWithKirInCardOwner() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner("Иван Иванов");
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//
//    @Test
//    @DisplayName(" Заполнение поля 'Владелец' данными, содержащие цифры")
//    public void shouldPayWithNumberInCardOwner() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner("Iv4n Iv4nov");
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//
//    @Test
//    @DisplayName(" Заполнение поля 'Владелец' данными, содержащие спец. символы")
//    public void shouldPayWithSpecSymbolInCardOwner() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner("Iv!n Iv!nov");
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Месяц' данными, содержащие латиницу")
//    public void shouldPayWithLatInCardMonth() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth("m1");
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Месяц' данными, содержащие кириллицу")
//    public void shouldPayWithKirInCardMonth() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth("м1");
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Месяц' данными, содержащие спец. символы")
//    public void shouldPayWithSpecSymbolInCardMonth() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth("*1");
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Месяц' данными, содержащие одну цифру")
//    public void shouldPayWithOneNumberInCardMonth() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth("1");
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Месяц' данными, содержащие '00'")
//    public void shouldPayWith00InCardMonth() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth("00");
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Месяц' данными, содержащие число больше чем 12")
//    public void shouldPayWithNumberOver12InCardMonth() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth("14");
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongCardValidity();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Год' данными, содержащие латиницу")
//    public void shouldPayWithLatInCardYear() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear("y3");
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Год' данными, содержащие кирилиицу")
//    public void shouldPayWithKirInCardYear() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear("г3");
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Год' данными, содержащие спец. символы")
//    public void shouldPayWithSpecSymbolInCardYear() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear("!3");
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Год' данными, содержащие число меньше чем текущий год")
//    public void shouldPayWithLessCurYearInCardYear() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear("19");
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageExpiredCardValidity();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'Год' данными, содержащие 1 цифру")
//    public void shouldPayWithOneNumberInCardYear() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear("3");
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'CVC/CVV' данными, содержащие кириллицу")
//    public void shouldPayWithKirInCardCVCCVV() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv("12Д");
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'CVC/CVV' данными, содержащие латиницу")
//    public void shouldPayWithLatInCardCVCCVV() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv("12D");
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'CVC/CVV' данными, содержащие спец. символы")
//    public void shouldPayWithSpecSymbolInCardCVCCVV() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv("12!");
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'CVC/CVV' данными, содержащие 2 цифры")
//    public void shouldPayWithTwoNumbersInCardCVCCVV() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv("12");
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение поля 'CVC/CVV' данными, содержащие 1 цифру")
//    public void shouldPayWithOneNumbersInCardCVCCVV() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv("1");
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение всех полей кроме поля 'Номер карты'")
//    public void shouldPayWithEmptyCardNumber() {
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение всех полей кроме поля 'Месяц'")
//    public void shouldPayWithEmptyCardMonth() {
//        form.setCardNumber(validCardNumber);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение всех полей кроме поля 'Год'")
//    public void shouldPayWithEmptyCardYear() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardowner(name);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
//    @Test
//    @DisplayName(" Заполнение всех полей кроме поля 'Владелец'")
//    public void shouldPayWithEmptyCardOwner() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardCvcCvv(cVcCvv);
//        form.pushContinueButton();
//        form.massageRequiredField();
//    }
//    @Test
//    @DisplayName("№30 Заполнение всех полей кроме поля 'CVC/CVV")
//    public void shouldPayWithEmptyCardCvcCvv() {
//        form.setCardNumber(validCardNumber);
//        form.setCardMonth(month);
//        form.setCardYear(year);
//        form.setCardowner(name);
//        form.pushContinueButton();
//        form.massageWrongFormat();
//    }
}
