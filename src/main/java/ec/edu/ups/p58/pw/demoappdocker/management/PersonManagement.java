package ec.edu.ups.p58.pw.demoappdocker.management;

import ec.edu.ups.p58.pw.demoappdocker.dao.PersonDAO;
import ec.edu.ups.p58.pw.demoappdocker.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PersonManagement {

    @Inject
    private PersonDAO personDAO;

    public void insertPerson(Person person) {
        personDAO.persist(person);
    }

    public void updatePerson(Person person) {

    }
    public void deletePerson(Person person) {

    }

    public Person getPerson(int id) {
        return personDAO.read(id);
    }

    public Person getPersonByCedula(String cedula) {
        return personDAO.buscarPorCedula(cedula);
    }

    public List<Person> getAllPersons() {
        return personDAO.readAll();
    }

}
