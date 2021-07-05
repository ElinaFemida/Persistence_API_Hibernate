package Hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Hibernate.PrepareDataApplication;

public class CrudApplication {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            init();
            createExample();
            readAndPrintExample(1L);
            updateExample(1L, 1000);
            deleteExample(2L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void init() {
        PrepareDataApplication.forcePrepareData();
        factory = new Configuration()
                .configure("conf/crud/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown() {
        factory.close();
    }

    public static void createExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = new Product(7L, "Product 6", 600);
            System.out.println(product);
            session.saveOrUpdate(product);
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println(product);
        }
    }

    public static void readAndPrintExample(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println(product);
        }
    }

    public static void updateExample(long id, int cost) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.evict(product);
            product.setPrice(cost);
            System.out.println(product);
            session.update(product);
            session.getTransaction().commit();
            System.out.println(product);

        }
    }

    public static void deleteExample(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }


}
