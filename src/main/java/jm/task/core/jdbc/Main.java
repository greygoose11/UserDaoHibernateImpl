package jm.task.core.jdbc;

//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
//import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        UserServiceImpl userServiceImpl = new UserServiceImpl() ;
//        userServiceImpl.createUsersTable();
//        userServiceImpl.saveUser("Fedor", "Dostoevskiy", (byte) 88);
//        userServiceImpl.saveUser("Nikolay", "Nekrasov", (byte) 55);
//        userServiceImpl.saveUser("Anton", "Chehov", (byte) 45);
//        System.out.println(userServiceImpl.getAllUsers());
//        userServiceImpl.cleanUsersTable();
//        userServiceImpl.dropUsersTable();
        //Util.getSessionFactory();

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
//        User user = new User("Anton", "Chehov", (byte) 45);
//        userDaoHibernate.saveUser("Anton", "Chehov", (byte) 45);
        System.out.println(userDaoHibernate.getAllUsers());
//
//        userDaoHibernate.saveUser(user);




    }
}
