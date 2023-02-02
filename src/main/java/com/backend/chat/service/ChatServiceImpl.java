package com.backend.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.chat.documents.Message;
import com.backend.chat.repository.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatRepository chatRepository;

	@Override
	public List<Message> getLast10Messages() {
		return chatRepository.findFirts10ByOrderByDateDesc();
	}

	@Override
	public Message save(Message message) {
		return chatRepository.save(message);
	}

}
