package jm.task.core.jdbc.util;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/my_db_test?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sentyabr@#11";

    public static Connection connektor() {
        Connection connection = null;
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить драйвер");
        }
        return connection;

    }
}
