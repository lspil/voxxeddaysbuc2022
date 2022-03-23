package com.example.sse5mo.controllers;

import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("/demo")
  public String demo() {
    var a = SecurityContextHolder.getContext().getAuthentication();
    return "Demo";
  }
}
