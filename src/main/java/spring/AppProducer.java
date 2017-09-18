package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuyu on 2017/9/18.
 */
public class AppProducer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService servcie = context.getBean(ProducerService.class);
        for(int i =0 ;i<100 ;i++){
            servcie.sendMessage("test");
        }
    }
}
