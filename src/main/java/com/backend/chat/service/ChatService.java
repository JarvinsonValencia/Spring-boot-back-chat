package com.backend.chat.service;

import java.util.List;

import com.backend.chat.documents.Message;

public interface ChatService {
	
	public List<Message> getLast10Messages();
	public Message save(Message message);
}
