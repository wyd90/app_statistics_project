package com.bawei.app_logs_collect_web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap.servers}")
    public String bootStrapServer;

    @Value("${spring.kafka.acks}")
    public String acks;

    @Value("${spring.kafka.retries}")
    public Integer retries;

    @Value("${spring.kafka.batch.size}")
    public Integer batchSize;

    @Value("${spring.kafka.linger.ms}")
    public Integer lingerMs;

    @Value("${spring.kafka.buffer.memory}")
    public Integer bufferMemory;

    @Value("${spring.kafka.key.serializer}")
    public String keySerializer;

    @Value("${spring.kafka.value.serializer}")
    public String valueSerializer;

}
