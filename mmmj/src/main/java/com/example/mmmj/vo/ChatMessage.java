package com.example.mmmj.vo;

import lombok.Builder;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Builder
public class ChatMessage {

    ChatRoom chatRoom;
    SecurityProperties.User user;
    String message;

}
