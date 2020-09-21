package com.capgemini.capsules.server.v1.mappers;

import com.capgemini.capsules.client.models.CapsuleResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseModelMapper {
    com.capgemini.capsules.repositories.models.Capsule convert(CapsuleResponse response);
}
