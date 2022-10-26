package data;

import io.qameta.allure.model.Status;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataBase {

    private static String url = System.getProperty("db.url");
    private static String appURL = System.getProperty("app.url");
    private static String appPORT = System.getProperty("app.port");
    private static String userDB = System.getProperty("app.userDB");
    private static String password = System.getProperty("app.password");
    private static QueryRunner runner;
    private static Connection connect;

    @SneakyThrows
    public static void setup() {
        val runner = new QueryRunner();
        val connect = DriverManager.getConnection(url, userDB, password);
    }

    @SneakyThrows
    public static void clearAll() {
        setup();
        runner.update(connect, "DELETE FROM credit_request_entity;");
        runner.update(connect, "DELETE FROM payment_entity;");
        runner.update(connect, "DELETE FROM order_entity");
    }

    @SneakyThrows
    public static void checkPaymentStatus(Status status) {
        setup();
        val paymentData = "SELECT status FROM payment_entity;";
        val payment = runner.query(connect, paymentData, new BeanHandler<>(PaymentMod.class));
        assertEquals(status, payment.status);
    }

    @SneakyThrows
    public static void checkCreditStatus(Status status) {
        setup();
        val creditData = "SELECT status FROM credit_request_entity;";
        val credit = runner.query(connect, creditData, new BeanHandler<>(CreditMod.class));
        assertEquals(status, credit.status);
    }
}
