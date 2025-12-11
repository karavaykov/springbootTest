package io.hexlet.spring;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// BEGIN (write your solution here)
@Component
@ConfigurationProperties(prefix = "users")
@Getter
@Setter
public class DefaultUserProperties {
    @Getter
    private List<String> admins;



    // Дополнительный метод для проверки

}

// END