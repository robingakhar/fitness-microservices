package com.fitness.aiservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class GeminiService {

    private final WebClient webClient;

    //@Value("${gemini.api.url}")
    private String geminiApiUrl="https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";

   // @Value("${gemini.api.key}")
    private String geminiApiKey="AIzaSyCy7Pf3bZdr1Rz_ByWY65uzqS2B_I5GVgc";

    public GeminiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String getAnswer(String question) {
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {
                        Map.of("parts", new Object[]{
                                Map.of("text", question)
                        })
                }
        );

        String response = webClient.post()
                .uri(geminiApiUrl)
                .header("Content-Type", "application/json")
                .header("X-goog-api-key",geminiApiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
