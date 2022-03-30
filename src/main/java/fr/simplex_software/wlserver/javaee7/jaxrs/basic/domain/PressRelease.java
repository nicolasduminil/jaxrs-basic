package fr.simplex_software.wlserver.javaee7.jaxrs.basic.domain;

public class PressRelease
{
  private Long pressReleaseId;
  private String name;
  private String author;
  private String publisher;

  public PressRelease() {}

  public PressRelease(String name, String author, String publisher)
  {
    this.name = name;
    this.author = author;
    this.publisher = publisher;
  }

  public PressRelease(Long pressReleaseId, String name, String author, String publisher)
  {
    this (name, author, publisher);
    this.pressReleaseId = pressReleaseId;
  }

  public Long getPressReleaseId()
  {
    return pressReleaseId;
  }

  public void setPressReleaseId(Long pressReleaseId)
  {
    this.pressReleaseId = pressReleaseId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String getPublisher()
  {
    return publisher;
  }

  public void setPublisher(String publisher)
  {
    this.publisher = publisher;
  }
}
