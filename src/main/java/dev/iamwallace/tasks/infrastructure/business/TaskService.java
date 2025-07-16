package dev.iamwallace.tasks.infrastructure.business;

import dev.iamwallace.tasks.infrastructure.business.dto.TaskDTO;
import dev.iamwallace.tasks.infrastructure.business.mapper.TaskConveter;
import dev.iamwallace.tasks.infrastructure.entity.TaskEntity;
import dev.iamwallace.tasks.infrastructure.enums.Status;
import dev.iamwallace.tasks.infrastructure.repository.TaskRepository;
import dev.iamwallace.tasks.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

  public List<TaskDTO> getTasksByEventDate(LocalDateTime start, LocalDateTime end) {
    return taskConveter.toListTaskDTO(taskRepository.findByEventDateBetween(start, end));
  }

  public List<TaskDTO> getTasksByEmail(String token) {
    String email = jwtUtil.extractUsername(token.substring(7));
    return taskConveter.toListTaskDTO(taskRepository.findByEmail(email));
  }
}
