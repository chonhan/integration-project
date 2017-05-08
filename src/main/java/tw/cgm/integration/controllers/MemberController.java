package tw.cgm.integration.controllers;

import tw.cgm.integration.dao.MemberDataDao;
import tw.cgm.integration.enums.ChurchDepartment;
import tw.cgm.integration.enums.Country;
import tw.cgm.integration.json.Member;
import tw.cgm.integration.json.Result;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Sample Member REST API.
 */
@Path("/api/v1/member")
@Produces(MediaType.APPLICATION_JSON)
public class MemberController {

    private final MemberDataDao mDao;

    public MemberController(MemberDataDao mDao) {
        this.mDao = mDao;
    }

    @GET
    @Path("/{id}")
    public Response getMember(@PathParam("id") long id) {
        Member member = new Member();
        member.setId(id);
        member.setNameReal("Real Name");
        member.setChurch("LordsLight");
        member.setCountry(Country.TAIWAN);
        member.setDepartment(ChurchDepartment.FAMILY);
        return Response.ok(member).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMember(@PathParam("id") long id) {
        Result result = new Result();
        result.setId(id);
        result.setMessage("Update Member: " + id);
        return Response.ok(result).build();
    }

    @POST
    @Path("/{id}")
    public Response insertMember(@PathParam("id") long id) {
        Result result = new Result();
        result.setId(id);
        result.setMessage("Insert New Member");
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMember(@PathParam("id") long id) {
        Result result = new Result();
        result.setId(id);
        result.setMessage("Member Deleted");
        return Response.ok(result).build();
    }

}
