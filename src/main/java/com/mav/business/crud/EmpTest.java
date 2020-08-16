package com.mav.business.crud;

import com.mav.business.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmpTest {
  public static void main(String[] args) {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();
    Transaction txn = session.getTransaction();
    Employee emp1 = new Employee();
    emp1.setId(1);
    emp1.setEname("gaurav");
    emp1.setEsal("50000");
    emp1.setAddr("punjab");

    try {
      txn.begin();
      session.save(emp1);
      txn.commit();
    } catch (Exception e) {
      txn.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }
}
