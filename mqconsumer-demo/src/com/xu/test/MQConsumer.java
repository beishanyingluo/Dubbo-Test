package com.xu.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * @author  xu
 * @version 1.0 
 * ActiveMQ≤‚ ‘∆Ù∂Ø¿‡
 */
public class MQConsumer {
    private static final Log log = LogFactory.getLog(MQConsumer.class);
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
            context.start();
        } catch (Exception e) {
            log.error("¥Ìƒƒ¡À??");
            System.exit(0);
        }
    }
}
