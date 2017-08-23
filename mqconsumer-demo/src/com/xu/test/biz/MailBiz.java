package com.xu.test.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.xu.test.bean.MailBean;

/** 
 * @author  许帅杰
 * @version 1.0
 * 邮件发送 
 */
@Component("mailBiz")
public class MailBiz {

    @Autowired
    private JavaMailSender mailSender;//Spring中定义
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    @Autowired
    private ThreadPoolTaskExecutor thredPool;
    
    public void mailSend(final MailBean mail) {
        thredPool.execute(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
               try {
                   System.out.println("邮件发送开始啦!");
                   simpleMailMessage.setFrom(simpleMailMessage.getFrom());
                   simpleMailMessage.setTo(mail.getTo());
                   simpleMailMessage.setSubject(mail.getSubject());
                   simpleMailMessage.setText(mail.getContent());
                   mailSender.send(simpleMailMessage);
               } catch (MailException e) {
                   throw e;
               }
            }
        });
    }
}
