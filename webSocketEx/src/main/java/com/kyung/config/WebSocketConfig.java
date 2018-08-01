package com.kyung.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.enableSimpleBroker("/subscribe");
        config.setApplicationDestinationPrefixes("/publish");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
    }

}

/*
setApplicationDestinationPrefixes : client에서 SEND 요청을 처리한다.
Spring Reference에서는 /topic, /queue가 주로 등장하는데 여기서는 이해를 돕기 위해 /publish로 지정하였다.
/topic : 암시적으로 1:N 전파를 의미한다.
/queue : 암시적으로 1:1 전파를 의미한다.
enableSimpleBroker : 해당 경로로 SimpleBroker를 등록한다. SimpleBroker는 해당하는 경로를 SUBSCRIBE하는 client에게 메시지를 전달하는 간단한 작업을 수행한다.
enableStompBrokerRelay : SimpleBroker의 기능과 외부 message broker(RabbitMQ, ActiveMQ 등)에 메시지를 전달하는 기능을 가지고 있다.
*/