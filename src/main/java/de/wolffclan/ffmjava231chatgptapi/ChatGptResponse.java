package de.wolffclan.ffmjava231chatgptapi;

import java.util.List;

public record ChatGptResponse(
        List<ChatGptResponseChoice> choices
) {
}
