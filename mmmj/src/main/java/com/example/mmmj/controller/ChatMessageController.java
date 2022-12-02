package com.example.mmmj.controller;

import com.example.mmmj.service.ChatMessageService;
import com.example.mmmj.vo.ChatMessageRequest;
import com.example.mmmj.vo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService chatMessageService;
    private final UserRepository userRepository;

    @MessageMapping("/chat/message")
    public void message(
            ChatMessageRequest chatMessageRequest
    ) {
        SecurityProperties.User user = new SecurityProperties.User(); //userRepository.findById(chatMessageRequest.getUserId()).orElseThrow(UserNotFoundException::new);

        chatMessageService.sendMessage(chatMessageRequest, user);
    }

}
