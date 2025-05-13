package ec.edu.ups.p58.pw.demoappdocker.dao;

import ec.edu.ups.p58.pw.demoappdocker.model.Libro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LibroDAO {
    @PersistenceContext
    private EntityManager em;

    public void guardar(Libro libro) {
        em.persist(libro);
    }

    public Libro buscarPorId(int id) {
        return em.find(Libro.class, id);
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            // Si no se ingresó título, retornar todos los libros
            String jpql = "SELECT l FROM Libro l";
            return em.createQuery(jpql, Libro.class).getResultList();
        } else {
            // Búsqueda parcial (case insensitive)
            String jpql = "SELECT l FROM Libro l WHERE LOWER(l.titulo) LIKE LOWER(:titulo)";
            return em.createQuery(jpql, Libro.class)
                    .setParameter("titulo", "%" + titulo + "%")
                    .getResultList();
        }
    }


    public List<Libro> listarTodos() {
        return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
    }

    public void actualizar(Libro libro) {
        em.merge(libro);
    }

    public void eliminar(int id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            em.remove(libro);
        }
    }
}
