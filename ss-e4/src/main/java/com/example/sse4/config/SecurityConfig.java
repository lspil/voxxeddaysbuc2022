package com.example.sse4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public ReactiveUserDetailsService userDetailsService() {
    var u1 = User.withUsername("bill").password("12345").authorities("read").build();
    return new MapReactiveUserDetailsService(u1);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http.httpBasic()
        .and()
        .authorizeExchange()
          .pathMatchers("/demo").authenticated()
          .anyExchange().authenticated()
        .and().build();
  }
}
