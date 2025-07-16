package dev.iamwallace.tasks.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.iamwallace.tasks.infrastructure.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document("tasks")
public class TaskEntity {
  @Id
  private String id;
  private String name;
  private String description;
  private String email;
  private Status status;
  // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDateTime eventDate;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
