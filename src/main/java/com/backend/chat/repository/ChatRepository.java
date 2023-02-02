package com.backend.chat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.chat.documents.Message;

public interface ChatRepository extends MongoRepository<Message, String> {
	
	public List<Message> findFirts10ByOrderByDateDesc();
}
