package com.smoope.sdk.examples;

import com.smoope.sdk.examples.config.SmoopeConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        SmoopeConfiguration.class
})
public class SpringBootWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebsiteApplication.class, args);
    }
}
