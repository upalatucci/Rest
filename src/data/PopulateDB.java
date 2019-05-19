package data;

import data.Eventi;
import data.Studenti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;

class Main{
    public static void main(String [] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa"); //name of persistence unit here
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();


        Studenti stu = new Studenti();

        stu.setId(1);
        stu.setNome("Ugo");
        stu.setCognome("Palatucci");
        stu.setUsername("upalatucci");
        entityManager.persist(stu);


        Eventi ev = new Eventi();

        ev.setId(1);
        ev.setNome("Esame");
        ev.setData(new GregorianCalendar(2019, 1, 23).getTime());
        ev.addPartecipanti(stu);
        entityManager.persist(ev);

        entityManager.getTransaction().commit();
        return;
    }
}
