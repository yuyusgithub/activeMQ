package com.yuyu.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by yuyu on 2017/9/18.
 */
public class AppComsumer2 {

    private static final String url ="tcp://127.0.0.1:61616";

    private static final String  queueName = "queue-test";

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
        Destination destination =  session.createQueue(queueName);
        //创建一个消费者
        MessageConsumer consumer =  session.createConsumer(destination);

        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
//        connection.close();

    }
}
