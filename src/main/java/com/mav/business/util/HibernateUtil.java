package com.mav.business.util;

import com.mav.business.crud.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {

  public static SessionFactory getSessionFactory() {
    SessionFactory sessionFactory = null;
    Properties properties = getProperties();
    Configuration configuration = new Configuration();
    configuration.addAnnotatedClass(com.mav.business.crud.Employee.class);
    configuration.setProperties(properties);
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()) // configures settings from hibernate.cfg.xml
            .build();
    try {
      Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
      sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    catch (Exception e) {
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy( registry );
    }

    return sessionFactory;
  }

  private static Properties getProperties() {
    Properties properties = new Properties();
    properties.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
    properties.put(Environment.URL,"jdbc:mysql://localhost:3306/honey");
    properties.put(Environment.USER,"root");
    properties.put(Environment.PASS,"root");
    properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
    properties.put(Environment.SHOW_SQL,"true");
    properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
    properties.put(Environment.POOL_SIZE,"20");
    properties.put(Environment.HBM2DDL_AUTO,"create");
    return properties;
  }
}
