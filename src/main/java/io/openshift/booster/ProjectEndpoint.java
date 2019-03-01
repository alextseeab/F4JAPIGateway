package io.openshift.booster;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
@Path("/")
public class ProjectEndpoint {

//    @GET
//    @Produces("text/plain")
//    public Response doGet() {
//        return Response.ok("Hello from Thorntail REST!").build();
//    }

    @GET
    @Path("/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getAllProjects() throws MalformedURLException {
//        URL url = new URL("http://localhost:8081");
        URL url = new URL("http://projectservice-vertx-better-carriage.4b63.pro-ap-southeast-2.openshiftapps.com");
        ProjectService projectService = RestClientBuilder.newBuilder().baseUrl(url).build(ProjectService.class);
//        System.out.println("11xxxxxxxxxxxxxxxxxxxxxxJson=" + projectService.getAllProjects());
        return projectService.getAllProjects();
    }
    
    @GET
    @Path("/projects/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getProjectById(@PathParam("projectId") String projectId) throws MalformedURLException {
//        URL url = new URL("http://localhost:8081");
        URL url = new URL("http://projectservice-vertx-better-carriage.4b63.pro-ap-southeast-2.openshiftapps.com");
        ProjectService projectService = RestClientBuilder.newBuilder().baseUrl(url).build(ProjectService.class);
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxJson=" +"###start"+ projectId+"end##" + projectService.getProjectById(projectId));
        return projectService.getProjectById(projectId);
    }
    
    @GET
    @Path("/projects/status/{thisStatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getProjectByStatus(@PathParam("thisStatus") String thisStatus) throws MalformedURLException {
//        URL url = new URL("http://localhost:8081");
        URL url = new URL("http://projectservice-vertx-better-carriage.4b63.pro-ap-southeast-2.openshiftapps.com");
        ProjectService projectService = RestClientBuilder.newBuilder().baseUrl(url).build(ProjectService.class);
//        System.out.println("xxxxxxxxxxxxJson=" + projectService.getProjectByStatus(thisStatus));
        return projectService.getProjectByStatus(thisStatus);
    }
}
