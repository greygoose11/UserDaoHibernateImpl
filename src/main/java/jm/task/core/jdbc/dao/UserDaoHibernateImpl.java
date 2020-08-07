package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
        Util ut = new Util();
        Transaction tx = null;
        try (Session session = ut.getSessionFactory().openSession())  {
            tx = session.beginTransaction();
            Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS users(id int primary key , name varchar(40), lastName varchar(40), age int );").addEntity(User.class);
            query.executeUpdate();

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
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS users");
            query.executeUpdate();
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
        User user = new User();
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("delete User where id = :userId");
            query.setParameter("userId", id);
            query.executeUpdate();

        } catch (Exception e) {
            System.out.println("Object was not deleted by id");
        }
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
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("delete from User");
//            query.setParameter("userId", id);
            query.executeUpdate();
            System.out.println("Table is cleaned");

        } catch (Exception e) {
            System.out.println("Object was not deleted by id");
        }
    }
}
