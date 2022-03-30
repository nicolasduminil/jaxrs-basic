package fr.simplex_software.wlserver.javaee7.jaxrs.basic.producers;

import javax.activation.*;
import javax.annotation.*;
import javax.annotation.sql.*;
import javax.ejb.*;
import javax.enterprise.inject.*;

//@Singleton
//@DataSourceDefinition(name = "press-release", className = "oracle.jdbc.OracleDriver", url = "jdbc:oracle:thin:@//localhost:49161/xe", user = "system", password = "oracle", databaseName = "xe")
public class DataSourceProducer
{
  //@Resource(lookup = "jdbc/press-release")
  private DataSource ds;

  //@Produces
  public DataSource getDatasource()
  {
    return ds;
  }
}
