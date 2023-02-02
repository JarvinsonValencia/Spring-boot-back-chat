package com.backend.chat.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.backend.chat.documents.Message;
import com.backend.chat.service.ChatService;

@Controller
public class ChatController {
	
	private String[] colores = {"red", "green", "blue", "magenta", "purple", "orange"};
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	//Recibe los mensajes del cliente
	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje") //nombre evento
	public Message getMessage(Message message) {
		message.setDate(new Date().getTime());
		if(message.getTipo().equals("NUEVO_USUARIO")) {
			message.setColor(colores[new Random().nextInt(colores.length)]);
			message.setText("Nuevo usuario");
		} else {
			chatService.save(message);
		}
		message.setText(message.getText());
		
		return message;
	}
	
	//Recibe los mensajes del cliente
	@MessageMapping("/escribiendo")
	@SendTo("/chat/escribiendo") //nombre evento
	public String estaEscribiendo(String username) {
		return username.concat(" Escribiendo...");
	}
	
	@MessageMapping("/historial")
	public void historial(String clientId){
		messagingTemplate.convertAndSend("/chat/historial" + clientId, chatService.getLast10Messages());
	}
	
}
