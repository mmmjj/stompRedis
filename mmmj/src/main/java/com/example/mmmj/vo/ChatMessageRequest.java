package com.example.mmmj.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageRequest {

    String type;
    String roomId;
    String message;

    String nickName;
    String userId;

}
