package cn.jeas.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class ActiveMQProducer {

	@Test
	public void demo01() throws Exception{
		//获取消息连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		
		//获取 一个消息连接
		Connection connection = connectionFactory.createConnection();
		
		//开启连接(默认开启)
		connection.start();
		
		//建立消息会话  参数1:是否使用事务
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		
		//创建队列(话题)对象
		Queue queue = session.createQueue("HelloWorld");
		
		//创建生产者(或消费者)
		MessageProducer producer = session.createProducer(queue);
		
		//发送10条消息
		for (int i = 0; i < 10; i++) {
			producer.send(session.createTextMessage("你好啊,activeMQ!"+i));
		}
		
		//提交会话
		session.commit();
		
		//关闭连接
		producer.close();
		session.close();
		connection.stop();
		connection.close();
	}
}
