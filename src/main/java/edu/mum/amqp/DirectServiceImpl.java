package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.mum.domain.Message;

@Service
public class DirectServiceImpl implements MessageService {
	
	@Autowired
	@Qualifier("msgRouter")
	private RabbitTemplate msgRouter;

	public void publish(Message message) {
	    	msgRouter.convertAndSend(message);		
	}
}