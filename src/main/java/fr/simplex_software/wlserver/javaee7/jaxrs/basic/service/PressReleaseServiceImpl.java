package fr.simplex_software.wlserver.javaee7.jaxrs.basic.service;

import java.util.*;
import java.util.stream.*;
import javax.ejb.*;
import javax.persistence.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.data.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.domain.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.mapper.*;

@Stateless
public class PressReleaseServiceImpl implements PressReleaseService
{
  @PersistenceContext(unitName = "jta")
  private EntityManager entityManager;
  
  @Override
  public List<PressRelease> getPressReleasesByName(String name)
  {
    List<PressReleaseEntity> pressReleaseEntities = entityManager.createQuery("SELECT pr FROM PressReleaseEntity pr where pr.pressReleaseName = :name", PressReleaseEntity.class).setParameter ("name", name).getResultList();
    return pressReleaseEntities.stream().map(pre -> PressReleaseMapper.INSTANCE.toPressRelease(pre)).collect(Collectors.toList());
  }

  @Override
  public Optional<PressRelease> getPressReleaseById(Long pressReleaseId)
  {
    PressReleaseEntity pressReleaseEntity = entityManager.createQuery("SELECT pr FROM PressReleaseEntity pr where pr.id = :id", PressReleaseEntity.class).setParameter ("id", pressReleaseId).getSingleResult();
    return Optional.ofNullable(PressReleaseMapper.INSTANCE.toPressRelease(pressReleaseEntity));
  }

  @Override
  public List<PressRelease> getPressReleases()
  {
    List<PressReleaseEntity> pressReleaseEntities = entityManager.createQuery("SELECT pr FROM PressReleaseEntity pr", PressReleaseEntity.class).getResultList();
    return pressReleaseEntities.stream().map(pre -> PressReleaseMapper.INSTANCE.toPressRelease(pre)).collect(Collectors.toList());
  }

  @Override
  public void deletePressReleaseById(Long pressReleaseId)
  {
    PressReleaseEntity pressReleaseEntity = entityManager.createQuery("SELECT pr FROM PressReleaseEntity pr where pr.id = :id", PressReleaseEntity.class).setParameter ("id", pressReleaseId).getSingleResult();
    entityManager.remove(pressReleaseEntity);
  }

  @Override
  public Optional<PressRelease> saveOrUpdatePressRelease(PressRelease pressRelease)
  {
    return Optional.ofNullable(PressReleaseMapper.INSTANCE.toPressRelease(entityManager.merge(PressReleaseMapper.INSTANCE.fromPressRelease(pressRelease))));
  }
}
