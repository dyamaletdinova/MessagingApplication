package edu.mum.amqp;

import edu.mum.domain.Message;


public interface MessageService {
    public void publish(Message message);
}
