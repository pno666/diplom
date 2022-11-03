package data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {

    private static String url = System.getProperty("db.url");
    private static String user = System.getProperty("db.user");
    private static String password = System.getProperty("db.password");

    public static void clearAll() {
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(url, user, password)) {
            runner.update(conn, "DELETE FROM payment_entity;");
            runner.update(conn, "DELETE FROM credit_request_entity;");
            runner.update(conn, "DELETE FROM order_entity;");
        } catch (Exception e) {
            System.out.println("SQL exception in clearDB");
        }
    }

    private static String getData(String query) {
        String data = "";
        val runner = new QueryRunner();
        try (val connect = DriverManager.getConnection(url, user, password)) {
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
        try (val connect = DriverManager.getConnection(url, user, password)) {
            count = runner.query(connect, codeSQL, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Long.toString(count);
    }
}
