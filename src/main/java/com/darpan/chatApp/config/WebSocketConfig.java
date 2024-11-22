package com.darpan.chatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //enables websocket managing in spring boot.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") //endpoint
                .setAllowedOrigins("http://localhost:8080") //defining the frontend url, makes it secure blocking unauthorized broadcasting
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); //broker added, means that clients subscribed to /topic will get the broadcast of messages sent in the chat
        registry.setApplicationDestinationPrefixes("/app"); //any messaages with the prefix /app process it
    }
}
