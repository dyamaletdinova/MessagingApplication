/**
 * 
 */
package edu.mum.domain;

import java.io.Serializable;

/**
 * @author Diana Yamaletdinova
 * May 25, 2017
 */
public class Message implements Serializable{
	
	private String sender;
	private String receiver;
	private String message;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
