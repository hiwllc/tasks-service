package dev.iamwallace.tasks.infrastructure.security.client;

import dev.iamwallace.tasks.infrastructure.business.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user", url = "${user.url}")
public interface UserClient {
  @GetMapping("/users")
  UserDTO getUserByEmail(
    @RequestParam("email") String email,
    @RequestHeader("Authorization") String token
  );
}
