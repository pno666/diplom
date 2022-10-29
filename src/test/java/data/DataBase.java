package data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {

    private static String url = System.getProperty("db.url");
    private static String userDB = System.getProperty("app.userDB");
    private static String password = System.getProperty("app.password");

    public static void clearAll() {
        val runner = new QueryRunner();
        try (val connect = DriverManager.getConnection(url, userDB, password)) {
            runner.update(connect, "DELETE FROM credit_request_entity;");
            runner.update(connect, "DELETE FROM order_entity");
            runner.update(connect, "DELETE FROM payment_entity;");
        } catch (Exception e) {
            System.out.println("SQL exception in clearALL");
        }
    }
    private static String getData(String query) {
        String data = "";
        val runner = new QueryRunner();
        try (val connect = DriverManager.getConnection(url, userDB, password)) {
            data = runner.query(connect, query, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static String getPaymentStatus() {
        val codeSQL = "SELECT status FROM payment_entity;";
        return getData(codeSQL);
    }
    public static String getCreditRequestStatus() {
        val codeSQL = "SELECT status FROM credit_request_entity;";
        return getData(codeSQL);
    }
    public static String getOrderCount() {
        Long count = null;
        val codeSQL = "SELECT COUNT(*) FROM order_entity;";
        val runner = new QueryRunner();
        try (val connect = DriverManager.getConnection(url, userDB, password)) {
            count = runner.query(connect, codeSQL, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Long.toString(count);
    }
}
