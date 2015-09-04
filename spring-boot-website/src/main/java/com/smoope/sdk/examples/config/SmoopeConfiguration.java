package com.smoope.sdk.examples.config;

import com.smoope.sdk.SmoopeClient;
import com.smoope.sdk.impl.SmoopeClientImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SmoopeConfiguration {

    @Autowired
    Environment env;

    @Bean
    SmoopeClient smoopeClient() {
        return new SmoopeClientImpl(
                env.getProperty("smoope.api.auth.clientId"),
                env.getProperty("smoope.api.auth.clientSecret"),
                env.getProperty("smoope.api.auth.url"),
                env.getProperty("smoope.api.url")
        );
    }
}
