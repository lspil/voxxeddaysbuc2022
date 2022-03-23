package com.example.sse2.services;

import com.example.sse2.entities.User;
import com.example.sse2.model.security.SecurityUser;
import com.example.sse2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findUserByUsername(username)
        .map(SecurityUser::new)
        .orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
  }
}
