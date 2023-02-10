package com.javatest.restapi.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseService {
    public ResponseEntity<Map<String, Object>> success(String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", message);
        response.put("statusCode", status.value());
        return new ResponseEntity<>(response, status);
    }

    public ResponseEntity<Map<String, Object>> error(String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", message);
        response.put("statusCode", status.value());
        return new ResponseEntity<>(response, status);
    }
}
