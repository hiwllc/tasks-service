package dev.iamwallace.tasks.infrastructure.security;

import dev.iamwallace.tasks.infrastructure.business.dto.UserDTO;
import dev.iamwallace.tasks.infrastructure.security.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

  @Autowired
  private UserClient userClient;

  public UserDetails loadUserByUsername(String email, String token) {
    UserDTO user = userClient.getUserByEmail(email, token);
    return User.withUsername(user.getEmail()).password(user.getPassword()).build();
  }
}
