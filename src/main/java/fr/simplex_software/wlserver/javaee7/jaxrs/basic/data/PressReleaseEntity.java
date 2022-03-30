package fr.simplex_software.wlserver.javaee7.jaxrs.basic.data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "PRESS_RELEASE")
public class PressReleaseEntity
{
  private int pressReleaseId;
  private String pressReleaseName;
  private String author;
  private String publisher;

  public PressReleaseEntity()
  {
  }

  public PressReleaseEntity(String pressReleaseName, String author, String publisher)
  {
    this.pressReleaseName = pressReleaseName;
    this.author = author;
    this.publisher = publisher;
  }
  
  

  public PressReleaseEntity(int pressReleaseId, String pressReleaseName, String author, String publisher)
  {
    this (pressReleaseName, author, publisher);
    this.pressReleaseId = pressReleaseId;
  }

  @Id
  @SequenceGenerator(name = "PRESS_RELEASE_ID_GENERATOR", sequenceName = "PRESS_RELEASE_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESS_RELEASE_ID_GENERATOR")
  public int getPressReleaseId()
  {
    return pressReleaseId;
  }

  public void setPressReleaseId(int pressReleaseId)
  {
    this.pressReleaseId = pressReleaseId;
  }

  @NotEmpty
  public String getPressReleaseName()
  {
    return pressReleaseName;
  }

  public void setPressReleaseName(String pressReleaseName)
  {
    this.pressReleaseName = pressReleaseName;
  }

  @NotEmpty
  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  @NotEmpty
  public String getPublisher()
  {
    return publisher;
  }

  public void setPublisher(String publisher)
  {
    this.publisher = publisher;
  }
}
