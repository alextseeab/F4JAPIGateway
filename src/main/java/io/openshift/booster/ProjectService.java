package io.openshift.booster;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/projects")
public interface ProjectService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getAllProjects();

	@GET
	@Path("/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getProjectById(@PathParam("projectId") String projectId);
	
	@GET
	@Path("/status/{thisStatus}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getProjectByStatus(@PathParam("thisStatus") String thisStatus);
}
