package tw.cgm.integration.controllers;

import io.dropwizard.hibernate.UnitOfWork;
import tw.cgm.integration.dao.MemberDataDao;
import tw.cgm.integration.json.Member;
import tw.cgm.integration.json.Result;
import tw.cgm.integration.model.MemberData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.time.ZoneId;
import java.util.Optional;

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
    @UnitOfWork
    @Path("/{id}")
    public Response getMember(@PathParam("id") long id) {
        Optional<MemberData> memberData = mDao.findById(id);
        return Response.ok(memberData).build();
    }

    @PUT
    @UnitOfWork
    public Response updateMember(Member member) {
        Optional<MemberData> memberData = mDao.findById(member.getId());
        MemberData mData = memberData.get();
        mData.setNameReal(member.getNameReal());
        mData.setNameChanged(member.getNameChanged());
        mData.setNamePassport(member.getNamePassport());
        mData.setCountry(member.getCountry());
        mData.setChurch(member.getChurch());
        mData.setDepartment(member.getDepartment());
        mData.setBirthday(Date.valueOf(member.getBirthday()));
        mData.setBaptismday(Date.valueOf(member.getBaptismday()));
        mData = mDao.create(mData);
        return Response.ok(mData).build();
    }

    @POST
    @UnitOfWork
    public Response insertMember(Member member) {
        MemberData mData = new MemberData();
        mData.setNameReal(member.getNameReal());
        mData.setNameChanged(member.getNameChanged());
        mData.setNamePassport(member.getNamePassport());
        mData.setCountry(member.getCountry());
        mData.setChurch(member.getChurch());
        mData.setDepartment(member.getDepartment());
        mData.setBirthday(Date.valueOf(member.getBirthday()));
        mData.setBaptismday(Date.valueOf(member.getBaptismday()));
        mData = mDao.create(mData);
        return Response.ok(mData).build();
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public Response deleteMember(@PathParam("id") long id) {
        Result result = new Result();
        result.setId(id);
        result.setMessage("Member Deleted");
        return Response.ok(result).build();
    }

}
