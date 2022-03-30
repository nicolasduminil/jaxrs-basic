package fr.simplex_software.wlserver.javaee7.jaxrs.basic.service;

import java.util.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.domain.*;

public interface PressReleaseService
{
  Optional<PressRelease> getPressReleaseById (Long pressReleaseId);
  List<PressRelease> getPressReleases();
  void deletePressReleaseById(Long pressReleaseId);
  Optional<PressRelease> saveOrUpdatePressRelease(PressRelease pressRelease);
  List<PressRelease> getPressReleasesByName (String name);
}
