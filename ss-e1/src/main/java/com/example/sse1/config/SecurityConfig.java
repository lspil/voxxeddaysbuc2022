package com.example.sse1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager();

    UserDetails u1 = User.withUsername("bill")
        .password(passwordEncoder().encode("12345"))
        .authorities("read")
        .build();

    uds.createUser(u1);

    return uds;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
