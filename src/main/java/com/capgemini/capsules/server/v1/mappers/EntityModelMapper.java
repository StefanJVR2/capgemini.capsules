package com.capgemini.capsules.server.v1.mappers;

import com.capgemini.capsules.repositories.models.Capsule;
import com.capgemini.capsules.repositories.models.Mission;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface EntityModelMapper {
    List<com.capgemini.capsules.server.v1.models.Capsule> convert(List<Capsule> entity);

    com.capgemini.capsules.server.v1.models.Capsule convert(Capsule capsuleEntity);

    Set<com.capgemini.capsules.server.v1.models.Mission> convert(Set<Mission> missionEntity);

    com.capgemini.capsules.server.v1.models.Mission convert(Mission missionEntity);
}
