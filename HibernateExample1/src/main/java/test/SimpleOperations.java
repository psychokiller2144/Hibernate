/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.Persona;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Arturo
 */
public class SimpleOperations {

    public static void main(String[] args) {

        //si no se agrega el nombre, este debe ser hibernate.cfg
        //en caso contrario, proveer dicho nombre
        SessionFactory myFactory = new Configuration().configure().addAnnotatedClass(Persona.class).buildSessionFactory();

        Session mySession = myFactory.openSession();

        try {

            //insert
            /*
            Persona persona = new Persona("Santiago", "Cortes","santi@mail.com","1346798546");
            mySession.beginTransaction();
            mySession.save(persona);
            mySession.getTransaction().commit();
            System.out.println("<Registro insertado>");*/
            //select
            /*
            mySession.beginTransaction();
            Persona personaReaded = mySession.get(Persona.class, 17);
            System.out.println("Informacion: " + personaReaded);
            mySession.getTransaction().commit();
             */
            //HQL From Sentence
            /*mySession.beginTransaction();
            List<Persona> personas = mySession.createQuery("from Persona").getResultList();
            //personas = mySession.createQuery("from Persona p where p.nombre='Arturo'").getResultList();
            //personas = mySession.createQuery("from Persona p where p.apellido='Escobar' or p.apellido='Cortes'").getResultList();
            //personas = mySession.createQuery("from Persona p where p.idPersona > 15  order by p.idPersona DESC").getResultList();
            
            personas.forEach((p) -> {
                System.out.println("Persona: " + p);
            });
            
            mySession.getTransaction().commit();
             */
            
            //HQL Update & Delete Sentence
            mySession.beginTransaction();
            //mySession.createQuery("update Persona set apellido='Escobedo' where apellido like 'E%'").executeUpdate();
            mySession.createQuery("delete Persona where apellido='Escobedo'").executeUpdate();
            
            List<Persona> personas = mySession.createQuery("from Persona").getResultList();
            personas.forEach((p) -> {
                System.out.println("Persona: " + p);
            });
            
            mySession.getTransaction().commit();
            mySession.close();

        } finally {
            myFactory.close();
        }

    }
}
