package com.xu.test;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xu.test.params.Mailparam;

/** 
 * @author  xu
 * @version 1.0 
 */
@Service("mqProducer")
public class MQProducer {

    @Autowired
    private JmsTemplate activeMqJmsTemplate;
    
    /**
     * ·¢ËÍÏûÏ¢
     */
    public void sendMessage(final Mailparam mail) {
        activeMqJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(JSONObject.toJSONString(mail));
            }
        });
    }
    
    /*public void sendMessage(Destination destination, final String message) {
        activeMqJmsTemplate.send(destination,new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
    }*/
}
