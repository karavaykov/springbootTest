package io.hexlet.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.annotation.*;
import java.lang.reflect.Method;





@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    String home() {
        return "Добро пожаловать в Hexlet Spring Blog!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is simple Spring blog!";
    }
}