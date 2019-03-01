package io.openshift.booster;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
@Path("/")
public class FreelancerEndpoint {

//    @GET
//    @Produces("text/plain")
//    public Response doGet() {
//        return Response.ok("Hello from Thorntail REST!").build();
//    }

    @GET
    @Path("/freelancers")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getAllFreelancers() throws MalformedURLException {
//        URL url = new URL("http://localhost:8081");
        URL url = new URL("http://freelancerservice-springboot-smiling-door.b9ad.pro-us-east-1.openshiftapps.com");
        FreelancerService freelancerService = RestClientBuilder.newBuilder().baseUrl(url).build(FreelancerService.class);
//        System.out.println("11xxxxxxxxxxxxxxxxxxxxxxJson=" + projectService.getAllProjects());
        return freelancerService.getAllFreelancers();
    }
    
    @GET
    @Path("/freelancers/{freelancerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getFreelancerById(@PathParam("freelancerId") String freelancerId) throws MalformedURLException {
//        URL url = new URL("http://localhost:8081");
        URL url = new URL("http://freelancerservice-springboot-smiling-door.b9ad.pro-us-east-1.openshiftapps.com");
        FreelancerService freelancerService = RestClientBuilder.newBuilder().baseUrl(url).build(FreelancerService.class);
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxJson=" +"###start"+ projectId+"end##" + projectService.getProjectById(projectId));
        return freelancerService.getFreelancerById(freelancerId);
    }
    
}
