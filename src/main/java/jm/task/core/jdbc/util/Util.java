package jm.task.core.jdbc.util;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/my_db_test?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sentyabr@#11";

    private Connection connection;
    public Util() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Соединения нет");
            e.printStackTrace();
        }

    }
    public Connection getConnection() {
        return connection;
    }

    /*
    public static void Connektor() {

    //    Connection connection;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
    //        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    //        if (!connection.isClosed()) {
    //            System.out.println("Соединение установлено");
    //        }
    //        connection.close();
    //        if (connection.isClosed()) {
   //             System.out.println("Соединение закрыто");
   //         }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить драйвер");
        }
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); Statement statement = connection.createStatement()) {
    //        System.out.println(connection.isClosed());/
            //        int res = statement.executeUpdate("UPDATE my_table_test SET name = 'Fedor' WHERE id = 2;");
            statement.executeUpdate("INSERT INTO my_table_test (name, lastName) VALUES ('Egor', 'Petrov';");
            statement.addBatch("INSERT INTO my_table_test (name, lastName) VALUES ('Semen', 'Semenov')");
   //         System.out.println(res);
            statement.executeBatch();

        }catch (SQLException e) {

        }

    }*/





    }



