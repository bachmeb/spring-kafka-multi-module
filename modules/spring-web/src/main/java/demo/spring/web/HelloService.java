package demo.spring.web;

import org.springframework.stereotype.Service;

@Service public class HelloService {
    public String hello() {
        return "Greetings from Spring Boot!";
    }
}
