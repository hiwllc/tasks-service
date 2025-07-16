package dev.iamwallace.tasks.infrastructure.business.dto;

import dev.iamwallace.tasks.infrastructure.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
  private String id;
  private String name;
  private String description;
  private String email;
  private Status status;
  private LocalDateTime eventDate;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
