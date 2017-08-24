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
            //邮件发送
            Mailparam mail = new Mailparam();
            mail.setTo("beishanyingluo@foxmail.com");
            mail.setSubject("ActiveMq测试哈");
            mail.setContent("通过ActionMQ异步发送邮件呀!");
            
            mqProducer.sendMessage(mail);
            context.stop();
        } catch (Exception e) {
            log.error("出错了:", e);
            System.exit(0);
        } finally {
            log.info("结束了，哈哈！");
            System.exit(0);
        }
    }
    
    
}
