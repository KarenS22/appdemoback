package ec.edu.ups.p58.pw.demoappdocker.service;

import ec.edu.ups.p58.pw.demoappdocker.management.PersonManagement;
import ec.edu.ups.p58.pw.demoappdocker.model.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonService {

    @Inject
    private PersonManagement personManagement;

    @POST
    public Response addPerson(Person person) {
        try {
            personManagement.insertPerson(person);
            return Response.ok(person).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getPerson(@PathParam("id") int id) {
        try {
            Person person = personManagement.getPerson(id);
            return Response.ok(person).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/id/{cedula}")
    public Response getPersonByCedula(@PathParam("cedula") String cedula) {
        try {
            Person person = personManagement.getPersonByCedula(cedula);
            return Response.ok(person).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/all")
    public Response getAllPersons() {
        try {
            List<Person> persons = personManagement.getAllPersons();
            return Response.ok(persons).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
