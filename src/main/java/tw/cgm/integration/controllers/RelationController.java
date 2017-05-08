package tw.cgm.integration.controllers;

import tw.cgm.integration.dao.MemberDataDao;
import tw.cgm.integration.dao.RelationshipDao;
import tw.cgm.integration.model.Relationship;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Sample Relationship REST API.
 */
@Path("/api/v1/relation")
@Produces(MediaType.APPLICATION_JSON)
public class RelationController {

    private final MemberDataDao mDao;
    private final RelationshipDao rDao;

    public RelationController(MemberDataDao mDao, RelationshipDao rDao) {
        this.mDao = mDao;
        this.rDao = rDao;
    }

    @GET
    @Path("/family/{id}")
    public Response getFamily(@PathParam("id") long id) {
        Map<String, Long> result = new HashMap<>();
        result.put("Me", id);
        result.put("Mother", 111L);
        result.put("Father", 222L);
        result.put("Sister", 223L);
        return Response.ok(result).build();
    }

    @GET
    @Path("/couple/{id1}/{id2}")
    public Response setCouple(@PathParam("id1") long id1, @PathParam("id2") long id2) {
        Map<String, Long> result = new HashMap<>();
        result.put("Husband", id1);
        result.put("Wife", id2);
        return Response.ok(result).build();
    }

    @GET
    @Path("/child/{id1}/{id2}")
    public Response setChild(@PathParam("id1") long id1, @PathParam("id2") long id2) {
        Map<String, Long> result = new HashMap<>();
        result.put("Parent", id1);
        result.put("Child", id2);
        return Response.ok(result).build();
    }
}
