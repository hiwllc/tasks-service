package dev.iamwallace.tasks.infrastructure.controller;

import dev.iamwallace.tasks.infrastructure.business.TaskService;
import dev.iamwallace.tasks.infrastructure.business.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
  private final TaskService taskService;

  @PostMapping
  public ResponseEntity<TaskDTO> create(
    @RequestBody TaskDTO taskDTO,
    @RequestHeader("Authorization") String token
  ) {
    return ResponseEntity.ok(taskService.create(token, taskDTO));
  }
}
