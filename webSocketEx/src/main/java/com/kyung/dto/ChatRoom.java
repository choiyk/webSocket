package com.kyung.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.lang.NonNull;
import org.springframework.web.socket.WebSocketSession;

public class ChatRoom {

	private String id;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    // 채팅방 생성
    public static ChatRoom create(@NonNull String name) {
        ChatRoom created = new ChatRoom();
        created.id = UUID.randomUUID().toString();
        created.name = name;
        return created;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<WebSocketSession> getSessions() {
		return sessions;
	}

	public void setSessions(Set<WebSocketSession> sessions) {
		this.sessions = sessions;
	}

}
