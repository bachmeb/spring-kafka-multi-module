package demo.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired HelloService service;

	@GetMapping("/")
	public String index() {
		return service.hello();
	}

}