package com.roojai.kafka.poc.kafkapoc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roojai.kafka.poc.kafkapoc.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Endpoint {

    @Autowired
    private KafkaProducer producer;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity endpoint(@RequestBody Map<String, Object> body) throws JsonProcessingException {
        String sessionId = "test2";
        producer.sendMessage("opportunity", mapper.writeValueAsString(body), sessionId);
        return ResponseEntity.ok().build();
    }
}
