package fr.simplex_software.wlserver.javaee7.jaxrs.basic;

import java.util.*;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.resources.*;
import io.swagger.jaxrs.config.*;

@ApplicationPath("/basic")
public class BasicApp extends Application
{
  public BasicApp()
  {
    init();
  }

  private void init()
  {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0.0");
    beanConfig.setSchemes(new String[] { "http" });
    beanConfig.setHost("localhost:7001");
    beanConfig.setBasePath("/jaxrs-basic/resources");
    beanConfig.setResourcePackage(this.getClass().getPackage().getName());
    beanConfig.setTitle("JAX-RS Basic");
    beanConfig.setDescription("Operations pertaining on the JAX-RS Basic API");
    beanConfig.setScan(true);
  }

  @Override
  public Set<Class<?>> getClasses()
  {
    final Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(PressReleaseResource.class);
    return classes;
  }
}
