package fr.simplex_software.wlserver.javaee7.jaxrs.basic.resources;

import java.net.*;
import java.util.*;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.domain.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.service.*;
import io.swagger.annotations.*;

@Path("api")
@Consumes(value = "application/json,application/xml")
@Produces(value = "application/json,application/xml")
@Api(value = "Press Release API", description = "Operations pertaining on the Press release API")
public class PressReleaseResource
{
  @EJB
  private PressReleaseService pressReleaseService;

  @POST
  @ApiOperation(value = "createPressRelease", notes = "Create a new press release")
  @ApiResponses(value = {@ApiResponse(code = 201, message = "Successfully created press release", response = PressRelease.class), @ApiResponse(code = 500, message = "Server internal erro, see the log file")})
  public Response createPressRelease(PressRelease pressRelease)
  {
    return Response.created(URI.create("/prs/")).entity(pressReleaseService.saveOrUpdatePressRelease(pressRelease)).build();
  }
  
  @GET
  @ApiOperation(value = "getPressReleases", notes = "Get all press releases")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list", response = List.class), @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  public Response getPressReleases()
  {
    GenericEntity<List<PressRelease>> pressReleases = new GenericEntity<List<PressRelease>>(pressReleaseService.getPressReleases()){};
    return Response.ok().entity(pressReleases).build();    
  }
  
  @GET
  @Path("{id}")
  @ApiOperation(value = "getPressRelease", notes = "Get a press release by its ID")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved press release", response = PressRelease.class), @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  public Response getPressReleaseById(@PathParam("id") Long id)
  {
    return Response.ok(pressReleaseService.getPressReleaseById(id)).build();
  }
  
  @PUT
  @ApiOperation(value = "updatePressRelease", notes = "Update a press release")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully updated press release"), @ApiResponse(code = 500, message = "Server internal erro, see the log file")})
  public Response updatePressRelease (PressRelease pressRelease)
  {
    return Response.ok(pressReleaseService.saveOrUpdatePressRelease(pressRelease)).build();
  }
  
  @DELETE
  @Path("{id}")
  @ApiOperation(value = "deletePressRelease", notes = "Remove a press release by its ID")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully removed press release"), @ApiResponse(code = 500, message = "Server internal erro, see the log file")})
  public Response deletePressRelease (@PathParam("id") Long id)
  {
    return Response.ok().build();
  }
  
  @GET
  @Path("name/{name}")
  @ApiOperation(value = "getPressReleasesByName", notes = "Get a all the press releases having a given name")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved press releases", response = List.class), @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  public Response getPressReleasesByName(@PathParam("name") String name)
  {
    GenericEntity<List<PressRelease>> pressReleases = new GenericEntity<List<PressRelease>>(pressReleaseService.getPressReleasesByName(name)){};
    return Response.ok().entity(pressReleases).build();
  }
}
