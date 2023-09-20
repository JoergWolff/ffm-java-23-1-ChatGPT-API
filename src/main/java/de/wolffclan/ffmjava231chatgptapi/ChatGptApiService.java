package de.wolffclan.ffmjava231chatgptapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ChatGptApiService {

    @Value("${chatGptApiKey}")
    private String apiKey;
    @Value("${chatGptApiGroup}")
    private String apiGroup;


    public String askChatGpt(String question) {
        WebClient webClient = WebClient.create();

        ChatGptRequest request = new ChatGptRequest("gpt-3.5-turbo", List.of(new ChatGptMessage("user", question)));
        System.out.println(request);
        ChatGptResponse chatGptResponse =
                webClient.post()
                        .uri("https://api.openai.com/v1/chat/completions")
                        .header("Authorization", "Bearer " + apiKey)
                        .header("OpenAI-Organization", apiGroup)
                        .bodyValue(request)
                        .retrieve()
                        .toEntity(ChatGptResponse.class)
                        .block()
                        .getBody();

        return chatGptResponse.choices().get(0).message().content();
    }
}
