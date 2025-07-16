package dev.iamwallace.tasks.infrastructure.business.mapper;

import dev.iamwallace.tasks.infrastructure.business.dto.TaskDTO;
import dev.iamwallace.tasks.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskConveter {
  TaskEntity toTaskEntity(TaskDTO taskDTO);
  TaskDTO toTaskDTO(TaskEntity taskEntity);
}
