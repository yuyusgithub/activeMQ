package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuyu on 2017/9/18.
 */
public class AppComsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
