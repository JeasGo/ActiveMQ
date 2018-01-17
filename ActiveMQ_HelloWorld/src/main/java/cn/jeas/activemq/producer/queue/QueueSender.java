package cn.jeas.activemq.producer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
//生产者：Q消息队列
public class QueueSender {
	
	//注入Q的模版对象
	@Autowired
	@Qualifier("jmsQueueTemplate")//必须按照名字注入
	private JmsTemplate jmsQueueTemplate;
	
	//发送消息
	public void send(String queueName,final String messageStr){
		jmsQueueTemplate.send(queueName,new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(messageStr);
			}
		});
	}

}
