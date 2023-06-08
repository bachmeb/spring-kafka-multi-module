package org.example;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        var app = SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate template) {
        return args -> {
            System.out.println("asdfasdfasdfasdfasdf");
            template.send("topic1", "message1");
//            template.send("two", "thing2".getBytes());
        };
    }

    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // See https://kafka.apache.org/documentation/#producerconfigs for more properties
        return props;
    }

    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate() {
        return new KafkaTemplate<Integer, String>(producerFactory());
    }

//    @Bean
//    public KafkaTemplate<String, String> stringTemplate(ProducerFactory<String, String> pf) {
//        return new KafkaTemplate<>(pf);
//    }

//    @Bean
//    public KafkaTemplate<String, byte[]> bytesTemplate(ProducerFactory<String, byte[]> pf) {
//        return new KafkaTemplate<>(pf,
//                Collections.singletonMap(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class));
//    }
//
//
//
    public void sendToKafka(final MyOutputData data) {
        final ProducerRecord<String, String> record = createRecord(data);

        var template = kafkaTemplate();

        String topic = "topic-1";
        String dataa = "dataaaaa";

        CompletableFuture<SendResult<Integer, String>> future = template.send(topic, dataa);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                handleSuccess(data);
            }
            else {
                handleFailure(data, record, ex);
            }
        });
    }

    private void handleFailure(MyOutputData data, ProducerRecord<String, String> record, Object ex) {
    }

    private void handleSuccess(MyOutputData data) {
    }

    private ProducerRecord<String, String> createRecord(MyOutputData data) {
        String key = "asdf";
        String value = data.getData();
        ProducerRecord<String,String> record = new ProducerRecord<String,String>(key,value);
        return record;
    }

}

