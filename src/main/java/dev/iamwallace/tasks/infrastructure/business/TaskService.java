package dev.iamwallace.tasks.infrastructure.business;

import dev.iamwallace.tasks.infrastructure.business.dto.TaskDTO;
import dev.iamwallace.tasks.infrastructure.business.mapper.TaskConveter;
import dev.iamwallace.tasks.infrastructure.entity.TaskEntity;
import dev.iamwallace.tasks.infrastructure.enums.Status;
import dev.iamwallace.tasks.infrastructure.repository.TaskRepository;
import dev.iamwallace.tasks.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {
  private final TaskRepository taskRepository;
  private final TaskConveter taskConveter;
  private final JwtUtil jwtUtil;

  public TaskDTO create(String token, TaskDTO taskDTO) {
    String email = jwtUtil.extractUsername(token.substring(7));

    taskDTO.setEmail(email);
    taskDTO.setCreatedAt(LocalDateTime.now());
    taskDTO.setStatus(Status.PENDING);

    TaskEntity taskEntity = taskConveter.toTaskEntity(taskDTO);

    return taskConveter.toTaskDTO(taskRepository.save(taskEntity));
  }
}
