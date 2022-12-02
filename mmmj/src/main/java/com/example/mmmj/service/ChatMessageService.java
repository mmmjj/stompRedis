package com.example.mmmj.service;

import com.example.mmmj.repository.ChatMessageRepository;
import com.example.mmmj.repository.ChatRoomRepository;
import com.example.mmmj.vo.ChatMessage;
import com.example.mmmj.vo.ChatMessageRequest;
import com.example.mmmj.vo.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatMessageService {

    ChatRoomRepository chatRoomRepository;
    ChatMessageRepository chatMessageRepository;
    ChannelTopic channelTopic;
    private final RedisTemplate redisTemplate;

    @Transactional
    public void sendMessage(ChatMessageRequest chatMessageRequest, SecurityProperties.User user) {
        ChatRoom chatRoom = new ChatRoom(); //chatRoomRepository.findById(chatMessageRequest.getRoomId()).orElseThrow(RuntimeException::new);

        //채팅 생성 및 저장
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .user(user)
                .message(chatMessageRequest.getMessage())
                .build();

        //chatMessageRepository.save(chatMessage);
        String topic = channelTopic.getTopic();

        // ChatMessageRequest에 유저정보, 현재시간 저장
//        chatMessageRequest.setNickName(user.getNickname());
//        chatMessageRequest.setUserId(user.getId());

        if (chatMessageRequest.getType() == "TALK") {
            // 그륩 채팅일 경우
            redisTemplate.convertAndSend(topic, chatMessageRequest);
        }
    }
}
