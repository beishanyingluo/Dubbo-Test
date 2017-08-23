package com.xu.test.listener;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.xu.test.bean.MailBean;
import com.xu.test.biz.MailBiz;

/** 
 * @author  xu
 * @version 1.0 
 * ���м�����
 */
@Component
public class ConsumerActiveMqListener implements SessionAwareMessageListener<Message> {

    private static final Log log = LogFactory.getLog(ConsumerActiveMqListener.class);
    
    @Autowired
    private JmsTemplate activeMqJmsTemplate;
    @Autowired
    private Destination sessionAwareQueue;
    @Autowired
    private MailBiz mailBiz;
    
    public synchronized void onMessage(Message message, Session session) {
        try {
            ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
            final String ms = msg.getText();
            log.info("���ܵ� message:" + ms);
            MailBean mailBean = JSONObject.parseObject(ms, MailBean.class);
            if (mailBean == null ){
                return ;
            }
            
            try {
                mailBiz.mailSend(mailBean);
            } catch (Exception e) {
                
                log.error("ʧ��:", e);
            }
            
        } catch (Exception e) {
            log.error("ʧ�ܣ�");
        }
    }
}
