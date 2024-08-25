package com.example.demo.web.rest;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloResource {
    @GetMapping("/calculate")
    public double calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam char operation) {

        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    @PostMapping("/uppercase")
    public Map<String, String> convertToUpperCase(@RequestBody Map<String, String> input) {
        input.replaceAll((k, v) -> v.toUpperCase());
        return input;
    }
}

