package com.societe.leavemanagement.rest;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.societe.leavemanagement.business.LeaveManagementRemote;

@Stateless
@Path("/leaves")
@PermitAll
public class LeaveManagementController {

	@EJB
	LeaveManagementRemote leaveManagementRemote;

	/**
	 * {@inheritDoc}
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getListCongesCollaborateur(@QueryParam(value = "userName") String userName) {
		return Response.status(Response.Status.OK).entity(leaveManagementRemote.getListCongesCollaborateur(userName))
				.build();

	}

}
