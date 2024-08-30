package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReverseJsonService implements JsonProcessingService {

    @Override
    public Map<String, String> processJson(Map<String, String> input) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            if (entry.getValue() instanceof String) {
                String reversed = new StringBuilder(entry.getValue()).reverse().toString();
                result.put(entry.getKey(), reversed);
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
