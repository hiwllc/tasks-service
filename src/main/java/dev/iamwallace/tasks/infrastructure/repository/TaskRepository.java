package dev.iamwallace.tasks.infrastructure.repository;

import dev.iamwallace.tasks.infrastructure.entity.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, String> {

}
