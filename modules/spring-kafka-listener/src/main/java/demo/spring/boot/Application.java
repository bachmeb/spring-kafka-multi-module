package demo.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @KafkaListener(id = "listener1", topics = "topic1")
    public void listen(String in) {
        System.out.println(in);
    }

    @KafkaListener(id = "listener2", topics = "topic2")
    public void listen2(String in) {
        System.out.println(in);
    }
}

