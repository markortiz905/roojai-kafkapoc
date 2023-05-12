package com.roojai.kafka.poc.kafkapoc.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message, String key) {
        kafkaTemplate.send(topic,key,  message);
    }
}
