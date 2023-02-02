package com.backend.chat.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Message implements Serializable{
	
	@Id
	private String id;
	
	private String text;
	private Long date;
	private String username;
	private String tipo;
	private String color;
	
}
