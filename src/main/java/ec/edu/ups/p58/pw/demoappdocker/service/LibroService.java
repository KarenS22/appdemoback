package ec.edu.ups.p58.pw.demoappdocker.service;

import ec.edu.ups.p58.pw.demoappdocker.management.LibroManagement;
import ec.edu.ups.p58.pw.demoappdocker.model.Libro;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/libro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LibroService {
    @Inject
    private LibroManagement libroManagement;

    @POST
    public Response addLibro(Libro libro) {
        try {
            libroManagement.insertLibro(libro);
            return Response.ok(libro).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getLibro(int id) {
        try {
            Libro libro = libroManagement.readLibro(id);
            return Response.ok(libro).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/titulo")
    public Response getLibroByTitulo(@QueryParam("q") String titulo) {
        try {
            List<Libro> libros = libroManagement.readLibroByTitulo(titulo);
            return Response.ok(libros).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/all")
    public Response getLibros() {
        try {
            List<Libro> libros = libroManagement.listLibros();
            return Response.ok(libros).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateLibro(@PathParam("id") int id, Libro libro) {
        try {
            libro.setId(id);
            libroManagement.updateLibro(libro);
            return Response.ok(libro).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLibro(@PathParam("id") int id) {
        try {
            libroManagement.deleteLibro(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
