package com.roojai.kafka.poc.kafkapoc.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-4vndj.australia-southeast1.gcp.confluent.cloud:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put("sasl-jaas-config", "org.apache.kafka.common.security.plain.PlainLoginModule required username='HSQEFNRY3FK2434R' password='56kJEKVwvdZJqY9dHEv/vYa067cPnfQK735w2e18jNGLC7i08FVAyvZmZQlC5akH';");
        config.put("security-protocol", "SASL_SSL");
        config.put("sasl-mechanism", "PLAIN");
        config.put("group-id", "local-group");
        config.put("client-id", "local-client");

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
