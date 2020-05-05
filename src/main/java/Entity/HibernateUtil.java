package Entity;

import builder.Drug;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public SessionFactory sessionFactory;

    public void setup() {
        // code to load Hibernate Session factory
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);

        }
    }

    public void exit() {
        // code to close Hibernate Session factory
        sessionFactory.close();
    }

    public void create(Drug drug) {
        // code to save a book
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(drug);

        session.getTransaction().commit();
        session.close();
    }

    public void read() {
        // code to get a book
    }

    public void update() {
        // code to modify a book
    }

    public void delete() {
        // code to remove a book
    }
}
