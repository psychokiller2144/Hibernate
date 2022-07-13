package test;

import com.mycompany.Persona;
import javax.persistence.*;
import java.util.List;

public class HelloWorldHibernate {
    public static void main(String[] args) {
        
        String hql = "SELECT p FROM Persona p";
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager entityManager = fabrica.createEntityManager();
        
        Query query = entityManager.createQuery(hql);
        
        List <Persona> personas = query.getResultList();
        
        for(Persona p: personas)
            System.out.println("Persona: " + p);
        
    }
}
