package com.example.sse4.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class DemoController {

  @GetMapping(value = "/demo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<String> demo() {
    return Flux.just("A", "B", "C", "D", "E")
        .delayElements(Duration.ofSeconds(1));
  }
}
