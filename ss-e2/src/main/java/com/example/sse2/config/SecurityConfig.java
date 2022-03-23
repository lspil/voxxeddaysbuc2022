package com.example.sse2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig /* extends WebSecurityConfigurerAdapter */ {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.httpBasic(); // DSL method for authentication
//
//    /*
//    1. mcvMatcher() ->>>> ANT expressions
//    2. antMatcher() ->>>> ANT expressions
//    3. regexMatcher() ->>>> nu foloseste ANT, foloseste un regex
//     */
//
//    http.authorizeRequests() // authorization
//        .mvcMatchers( "/demo").authenticated()
//        .anyRequest().permitAll();
//  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.httpBasic()
                  .and()
                .authorizeRequests()
                  .anyRequest().permitAll()
                  .mvcMatchers("/demo/**").hasAnyAuthority("read", "write")
                  .mvcMatchers("/test/**").authenticated()
                  .anyRequest().authenticated()
        .and().build();
  }
}
