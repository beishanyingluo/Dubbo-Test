package com.xu.test.bean;
/** 
 * @author  xu
 * @version 1.0 
 */
public class MailBean {

    /** ������ **/
    private String from;
    /** �ռ��� **/
    private String to;
    /** ���� **/
    private String subject;
    /** �ʼ����� **/
    private String content;
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
}
