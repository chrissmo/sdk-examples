package com.smoope.sdk.examples.config;

import com.smoope.sdk.SmoopeClient;
import com.smoope.sdk.impl.SmoopeClientImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SmoopeConfiguration {

    @Bean
    @Profile("!local")
    SmoopeClient smoopeClient(@Value("${smoope.api.auth.clientId}") String clientId,
                              @Value("${smoope.api.auth.clientSecret}") String secret) {
        return new SmoopeClientImpl(
                clientId,
                secret,
                true
        );
    }

    @Bean
    @Profile("local")
    SmoopeClient localSmoopeClient(@Value("${smoope.api.auth.clientId}") String clientId,
                                   @Value("${smoope.api.auth.clientSecret}") String secret,
                                   @Value("${smoope.api.auth.url}") String authUrl,
                                   @Value("${smoope.api.url}") String apiUrl) {
        return new SmoopeClientImpl(
                clientId,
                secret,
                authUrl,
                apiUrl
        );
    }
}
