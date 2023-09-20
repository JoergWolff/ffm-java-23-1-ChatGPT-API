package de.wolffclan.ffmjava231chatgptapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatGptController {

    private final ChatGptApiService chatGptApiService;

    public ChatGptController(ChatGptApiService chatGptApiService) {
        this.chatGptApiService = chatGptApiService;
    }

    @PostMapping
    public String answerChatMessage(@RequestBody String question){return chatGptApiService.askChatGpt(question);
    }
}
