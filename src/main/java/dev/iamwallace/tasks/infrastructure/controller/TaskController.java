package dev.iamwallace.tasks.infrastructure.controller;

import dev.iamwallace.tasks.infrastructure.business.TaskService;
import dev.iamwallace.tasks.infrastructure.business.dto.TaskDTO;
import dev.iamwallace.tasks.infrastructure.entity.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

  @GetMapping("/events")
  public ResponseEntity<List<TaskDTO>> getTasksByEventDate(
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
  ) {
    return ResponseEntity.ok(taskService.getTasksByEventDate(start, end));
  }

  @GetMapping
  public ResponseEntity<List<TaskDTO>> getTasksByEmail(@RequestHeader("Authorization") String token) {
    return ResponseEntity.ok(taskService.getTasksByEmail(token));
  }
}
