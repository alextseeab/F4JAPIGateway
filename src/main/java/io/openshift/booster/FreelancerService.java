package io.openshift.booster;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/freelancers")
public interface FreelancerService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray getAllFreelancers();

	@GET
	@Path("/{freelancerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getFreelancerById(@PathParam("freelancerId") String freelancerId);
	
}
