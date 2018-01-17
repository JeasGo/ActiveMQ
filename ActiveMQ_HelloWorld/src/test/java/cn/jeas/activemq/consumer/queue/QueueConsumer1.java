package cn.jeas.activemq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

//q的消费者监听器
@Component
public class QueueConsumer1 implements MessageListener{

	public void onMessage(Message message) {
		try {
			System.out.println(this.getClass().getSimpleName()+"获取消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
