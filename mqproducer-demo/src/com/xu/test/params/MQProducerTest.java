package com.xu.test.params;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xu.test.MQProducer;

/** 
 * @author  xu
 * @version 1.0 
 */
public class MQProducerTest {

    private static final Log log = LogFactory.getLog(MQProducerTest.class);
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
            context.start();
            
            MQProducer mqProducer = (MQProducer) context.getBean("mqProducer");
            //�ʼ�����
            Mailparam mail = new Mailparam();
            mail.setTo("beishanyingluo@foxmail.com");
            mail.setSubject("ActiveMq���Թ�");
            mail.setContent("ͨ��ActionMQ�첽�����ʼ�ѽ!");
            
            mqProducer.sendMessage(mail);
            context.stop();
        } catch (Exception e) {
            log.error("������:", e);
            System.exit(0);
        } finally {
            log.info("�����ˣ�������");
            System.exit(0);
        }
    }
    
    
}
