package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import utils.HibernateSessionFactoryUtil;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Transaction tx = null;
        try (Session session = Util.getSessionFactory().openSession())  {
            tx = session.getTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS user(id int primary key auto_increment, name varchar(40), lastName varchar(40), age int );").executeUpdate();
                System.out.println("Table is created");

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public void dropUsersTable() {
        Transaction tx = null;
        try (Session session = Util.getSessionFactory().openSession())  {
            tx = session.getTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS user");
            System.out.println("Table is deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age ) {
        User user = new User(name, lastName, age);
//        Transaction tx = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            session.close();
            System.out.println("User named "+ name+" added in table");
        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
            System.out.println("Ошибочка");
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
             userList = session.createQuery("From " + User.class.getSimpleName()).list();
//            for (Iterator<User> it = userList.iterator(); it.hasNext();) {
//                User user = (User) it.next();
//                System.out.println(user.toString());
//            }
        } catch (Exception e) {}
        return userList;
    }

    @Override
    public void cleanUsersTable() {

    }
}
