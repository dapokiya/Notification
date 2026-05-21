package valtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import valtech.service.GreetingService;


@RestController
public class Notification {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greet")
    public String greet() {
        return greetingService.getMessage();
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }

}
