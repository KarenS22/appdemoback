package ec.edu.ups.p58.pw.demoappdocker.dao;

import ec.edu.ups.p58.pw.demoappdocker.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PersonDAO {
    @PersistenceContext
    private EntityManager em;

    public void persist(Person person) {
        em.persist(person);
    }

    public void remove(Person person) {
        em.remove(em.merge(person));
    }
    public Person read(int id) {
        return em.find(Person.class, id);
    }

    public Person buscarPorCedula(String cedula) {
        String jpql = "SELECT a FROM Person a WHERE a.cedula = :cedula";
        return em.createQuery(jpql, Person.class)
                .setParameter("cedula", cedula)
                .getSingleResult();
    }

    public List<Person> readAll() {
        String jpql = "SELECT p FROM Person p";
        Query query = em.createQuery(jpql, Person.class);
        return query.getResultList();
    }
}
