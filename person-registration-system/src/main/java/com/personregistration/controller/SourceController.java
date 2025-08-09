package com.personregistration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SourceController {

    @GetMapping("/source")
    public Map<String, String> getSourceLink() {
        return Map.of("source", "https://github.com/JordanaNadur/Test-Person-registration-system");
    }
}
