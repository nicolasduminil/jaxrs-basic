package fr.simplex_software.wlserver.javaee7.jaxrs.basic.tests;

import static org.junit.Assert.*;
import java.net.*;
import java.util.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import org.apache.http.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.domain.*;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPressReleaseResource
{
  private static WebTarget webTarget;
  
  @BeforeClass
  public static void beforeClass() throws URISyntaxException
  {
    webTarget = ClientBuilder.newClient().target(new URI("http://localhost:7001/jaxrs-basic/basic/api").toString());
  }
  
  @Test
  public void testCreatePressReleaseShouldSucceed()
  {
    Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(new PressRelease("AWS Lambda", "Nicolas DUMINIL", "ENI"), MediaType.APPLICATION_JSON));
    assertEquals(HttpStatus.SC_CREATED, response.getStatus());
  }
  
  @Test
  public void testGetAllPressReleasesShouldSucceed()
  {
    Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get();
    assertEquals(HttpStatus.SC_OK, response.getStatus());
    List<PressRelease> pressReleases = response.readEntity(new GenericType<List<PressRelease>>(){});
    assertNotNull(pressReleases);
    assertFalse(pressReleases.isEmpty());
  }
  
  @Test
  public void testGetSinglePressReleaseShouldSucceed()
  {
    Response response = webTarget.path("name/AWS Lambda").request().accept(MediaType.APPLICATION_JSON).get();
    assertEquals(HttpStatus.SC_OK, response.getStatus());
    List<PressRelease> pressReleases = response.readEntity(new GenericType<List<PressRelease>>(){});
    assertNotNull(pressReleases);
    assertFalse(pressReleases.isEmpty());
    PressRelease pressRelease = pressReleases.get(0);
    assertNotNull(pressRelease);    
    assertEquals("AWS Lambda", pressRelease.getName());
    assertTrue("ENI".equals(pressRelease.getPublisher()) || "Manning".equals(pressRelease.getPublisher()));
  }
  
  @Test 
  public void testUpdatePressReleaseShouldSucceed()
  {
    Response response = webTarget.path("name/AWS Lambda").request().accept(MediaType.APPLICATION_JSON).get();
    assertEquals(HttpStatus.SC_OK, response.getStatus());
    List<PressRelease> pressReleases = response.readEntity(new GenericType<List<PressRelease>>(){});
    assertNotNull(pressReleases);
    assertFalse(pressReleases.isEmpty());
    PressRelease pressRelease = pressReleases.get(0);
    pressRelease.setPublisher("Manning");
    response = webTarget.request().accept(MediaType.APPLICATION_JSON).put(Entity.entity(pressRelease, MediaType.APPLICATION_JSON));
    assertEquals(HttpStatus.SC_OK, response.getStatus());
    pressRelease = response.readEntity(PressRelease.class);
    assertEquals("Manning", pressRelease.getPublisher());
  }
  
  @Test
  public void testZeroPressReleaseShouldSucceed()
  {
    Response response = webTarget.path("name/AWS Lambda").request().accept(MediaType.APPLICATION_JSON).get();
    assertEquals(HttpStatus.SC_OK, response.getStatus());
    List<PressRelease> pressReleases = response.readEntity(new GenericType<List<PressRelease>>(){});
    assertNotNull(pressReleases);
    assertFalse(pressReleases.isEmpty());
    PressRelease pressRelease = pressReleases.get(0);
    response = webTarget.path(Long.toString(pressRelease.getPressReleaseId())).request().accept(MediaType.APPLICATION_JSON).delete();
    assertEquals(HttpStatus.SC_OK, response.getStatus());    
  }
}
