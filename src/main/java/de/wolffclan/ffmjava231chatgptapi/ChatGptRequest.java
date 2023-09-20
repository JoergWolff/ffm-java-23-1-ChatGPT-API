package de.wolffclan.ffmjava231chatgptapi;

import java.util.List;

public record ChatGptRequest(
        String model,
        List<ChatGptMessage> messages
) {
}
