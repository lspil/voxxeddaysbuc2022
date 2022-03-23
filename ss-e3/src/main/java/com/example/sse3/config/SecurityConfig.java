package com.example.sse3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

  /*
  ROLES_ALLOWED
  SECURED
  PRE/POST  --> pe astea le folosim
   */

  @Bean
  public UserDetailsService userDetailsService() {
    var service = new InMemoryUserDetailsManager();

    var u1 = User.withUsername("bill")
        .password(passwordEncoder().encode("12345"))
        .authorities("read")
        .build();

    var u2 = User.withUsername("john")
        .password(passwordEncoder().encode("12345"))
        .authorities("write")
        .build();

    service.createUser(u1);
    service.createUser(u2);

    return service;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http.httpBasic()
          .and().csrf().disable()
          .build();
  }

//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    return http.httpBasic()
//        .and()
//          .authorizeRequests()
//            .mvcMatchers(HttpMethod.GET, "/api/product").hasAuthority("read")
//            .mvcMatchers(HttpMethod.POST, "/api/product").hasAuthority("write")
//        .anyRequest().authenticated()
//          .and().csrf().disable()
//        .build();
//  }

}
