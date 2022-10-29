package data;


import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {
    private static String approvedCardNumber = "4444444444444441";
    private static String declinedCardNumber = "4444444444444442";
    private static String month = getCardMonth();
    private static String year = "23";
    private static String cardHolder = getCardHolderName();
    private static String cvcCvv = getCvcCvv();
    public static Card getApprovedCard() {
        return new Card(approvedCardNumber, month, year, cardHolder, cvcCvv);
    }

    public static Card getDeclinedCard() {
        return new Card(declinedCardNumber, month, year, cardHolder, cvcCvv);
    }

    public static Card getEmptyCard() {
        return new Card("", "", "", "", "");
    }

    public static Card getEmptyCardNumber() {
        return new Card("", month, year, cardHolder, cvcCvv );
    }
    public static Card getEmptyMonthNumber() {
        return new Card(approvedCardNumber, "", year, cardHolder, cvcCvv);
    }
    public static Card getEmptyYearNumber() {
        return new Card(approvedCardNumber, month, "", cardHolder, cvcCvv);
    }
    public static Card getEmptyCardHolder() {
        return new Card(approvedCardNumber, month, year, "", cvcCvv);
    }
    public static Card getEmptyCvcCvvNumber() {
        return new Card(approvedCardNumber, month, year, cardHolder, "");
    }

    private static String getCardMonth() {
        int change = (int) (Math.random() * 10);
        return LocalDate.now().plusMonths(change).format(DateTimeFormatter.ofPattern("MM"));
    }
    private static String getCardHolderName() {
        Faker faker = new Faker();
        return faker.name().lastName() + " " + faker.name().firstName();
    }
    private static String getCvcCvv() {
        Faker faker = new Faker();
        return faker.number().digits(3);
    }
}
