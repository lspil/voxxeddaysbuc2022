package com.example.sse5mo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .oauth2ResourceServer(j -> j.jwt().jwkSetUri("http://localhost:8080/realms/master/protocol/openid-connect/certs"))
        .authorizeRequests()
          .anyRequest().authenticated()
        .and().build();
  }

}
