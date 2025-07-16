package dev.iamwallace.tasks.infrastructure.business.mapper;

import dev.iamwallace.tasks.infrastructure.business.dto.TaskDTO;
import dev.iamwallace.tasks.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskConveter {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "eventDate", target = "eventDate")
  @Mapping(source = "createdAt", target = "createdAt")
  TaskEntity toTaskEntity(TaskDTO taskDTO);
  TaskDTO toTaskDTO(TaskEntity taskEntity);

  List<TaskEntity> toListTaskEntity(List<TaskDTO> taskDTOS);
  List<TaskDTO> toListTaskDTO(List<TaskEntity> taskEntities);
}
