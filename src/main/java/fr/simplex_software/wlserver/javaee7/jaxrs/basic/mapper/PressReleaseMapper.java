package fr.simplex_software.wlserver.javaee7.jaxrs.basic.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.data.*;
import fr.simplex_software.wlserver.javaee7.jaxrs.basic.domain.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PressReleaseMapper
{
  PressReleaseMapper INSTANCE = Mappers.getMapper(PressReleaseMapper.class);
  @Mapping(source = "pressReleaseName", target = "name")
  PressRelease toPressRelease(PressReleaseEntity PressReleaseEntity);
  @InheritInverseConfiguration
  PressReleaseEntity fromPressRelease(PressRelease PressRelease);
}
