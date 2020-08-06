package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
     //реализуйте настройку соеденения с БД
//    private static final String URL1 = "jdbc:mysql://localhost:3306/my_db_test?serverTimezone=Europe/Moscow&useSSL=false";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "Sentyabr@#11";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres?useSSL=false");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "Sentyabr@#11");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "tread");
                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                if (!sessionFactory.isClosed()) {
                    System.out.println("Session factory is established");
                }


            } catch (Exception e) {
                System.out.println("Не удалось загрузить драйвер");
                e.printStackTrace();
            }

        }
        return sessionFactory;
    }


//    public static Connection connektor() {
//        Connection connection = null;
//        try {
//            Driver driver = new com.mysql.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection(URL1, USERNAME, PASSWORD);
//            if (!connection.isClosed()) {
//                System.out.println("Соединение установлено");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Не удалось загрузить драйвер");
//        }
//        return connection;
//
//    }

    }

