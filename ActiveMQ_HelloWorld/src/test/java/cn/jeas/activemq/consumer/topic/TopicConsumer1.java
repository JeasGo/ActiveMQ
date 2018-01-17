package cn.jeas.activemq.consumer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

//t的消费者监听器
@Component
public class TopicConsumer1 implements MessageListener{

	public void onMessage(Message message) {
		try {
			System.out.println(this.getClass().getSimpleName()+"获取消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
