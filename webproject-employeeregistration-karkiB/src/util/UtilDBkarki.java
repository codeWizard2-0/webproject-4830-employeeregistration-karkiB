/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.Employeekarki;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDBkarki {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<Employeekarki> listEmployees() {
      List<Employeekarki> resultList = new ArrayList<Employeekarki>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> employees = session.createQuery("FROM Employeekarki").list();
         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
            Employeekarki employeekarki = (Employeekarki) iterator.next();
            resultList.add(employeekarki);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<Employeekarki> listEmployees(String keyword) {
      List<Employeekarki> resultList = new ArrayList<Employeekarki>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> employees = session.createQuery("FROM Employeekarki").list();
         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
            Employeekarki employeekarki = (Employeekarki) iterator.next();
            if (employeekarki.getFirstName().startsWith(keyword) || employeekarki.getLastName().startsWith(keyword) || employeekarki.getUserName().startsWith(keyword) || employeekarki.getPassword().startsWith(keyword) || employeekarki.getAddress().startsWith(keyword)  ) {
               resultList.add(employeekarki);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createEmployees(String firstName, String lastName, String userName, String password, String address, String contact) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         //session.save(new Employeekarki(firstName, lastName, userName, password, address, Integer.valueOf(contact)));
         session.save(new Employeekarki(firstName, lastName, userName, password, address, contact));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
