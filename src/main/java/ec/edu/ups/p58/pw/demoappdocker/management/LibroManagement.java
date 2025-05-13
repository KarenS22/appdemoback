package ec.edu.ups.p58.pw.demoappdocker.management;

import ec.edu.ups.p58.pw.demoappdocker.dao.LibroDAO;
import ec.edu.ups.p58.pw.demoappdocker.model.Libro;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class LibroManagement {
    @Inject
    private LibroDAO libroDAO;

    public void insertLibro(Libro libro) {
        libroDAO.guardar(libro);
    }

    public Libro readLibro(int id) {
        return libroDAO.buscarPorId(id);
    }

    public List<Libro> readLibroByTitulo(String titulo) {
        return libroDAO.buscarPorTitulo(titulo);
    }

    public void updateLibro(Libro libro) {
        libroDAO.actualizar(libro);
    }

    public void deleteLibro(int id) {
        libroDAO.eliminar(id);
    }

    public List<Libro> listLibros() {
        return libroDAO.listarTodos();
    }

}
