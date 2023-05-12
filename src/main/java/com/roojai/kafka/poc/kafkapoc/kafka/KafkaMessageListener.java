package com.roojai.kafka.poc.kafkapoc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaMessageListener {

    @KafkaListener(topics = "opportunity")
    public void listen(@Payload String message,
                       @Header(KafkaHeaders.RECEIVED_KEY) String messageKey,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) String partition) {
        log.info("MessageKey: " + messageKey);
        log.info("partition: " + partition);
        log.info("Received message: " + message);
        log.info("------------------------");
    }
}
