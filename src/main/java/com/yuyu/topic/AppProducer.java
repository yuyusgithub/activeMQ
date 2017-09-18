package com.yuyu.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by yuyu on 2017/9/18.
 */
public class AppProducer {

    private static final String url ="tcp://127.0.0.1:61616";

    private static final String  queueName = "topic-test";

    public static void main(String[] args) throws JMSException{
        //创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //创建connection
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//是否在事务中处理，自动应答模式
        //创建一个目标  目的地
        Destination destination =  session.createTopic(queueName);
        //创建一个生产者
        MessageProducer producer =  session.createProducer(destination);

        for(int i = 0 ;i<100 ;i++){
            TextMessage textMessage = session.createTextMessage("test"+i);
            producer.send(textMessage);
            System.out.println("发送消息"+textMessage.getText());
        }
        connection.close();

    }
}
