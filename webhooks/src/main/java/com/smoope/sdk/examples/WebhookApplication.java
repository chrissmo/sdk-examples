package com.smoope.sdk.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class WebhookApplication {

    private final RestTemplate slack = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(WebhookApplication.class, args);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<?> webhook(@RequestBody Map<?, ?> data) {
        Iterable<?> parts = (Iterable<?>) data.get("parts");
        Map<?, ?> part = (Map<?, ?>) parts.iterator().next();

        HashMap<Object, Object> slackPayload = new HashMap<>();
        slackPayload.put("username", data.get("userName"));
        slackPayload.put("icon_emoji", ":red_circle:");
        slackPayload.put("text", part.get("body").toString()
                .replaceFirst("/" + data.get("command"), ""));

        slack.postForEntity("https://hooks.slack.com/services/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",
                slackPayload, String.class);

        return ResponseEntity.noContent()
                .build();
    }

}
