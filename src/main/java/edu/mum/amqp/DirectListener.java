package edu.mum.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.domain.Message;

@Service
public class DirectListener {
	@Autowired
	private MessageService msgService;

	public void listen(Message message) {
		System.out.println("\n\n" + message.getMessage());
	}
}
