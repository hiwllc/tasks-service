package dev.iamwallace.tasks.infrastructure.repository;

import dev.iamwallace.tasks.infrastructure.entity.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, String> {
  List<TaskEntity> findByEventDateBetween(LocalDateTime start, LocalDateTime end);
  List<TaskEntity> findByEmail(String email);
}
