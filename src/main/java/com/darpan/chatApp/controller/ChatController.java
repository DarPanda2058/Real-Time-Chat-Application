package com.darpan.chatApp.controller;

import com.darpan.chatApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
        @MessageMapping("/sendMessage")
        @SendTo("/topic/messages")
        public ChatMessage sendMessage(ChatMessage chatMessage){
            return chatMessage;
        }

        //for thymeleaf template
        @GetMapping("chat")
        public String chat(){
            return "chat";
        }
}
