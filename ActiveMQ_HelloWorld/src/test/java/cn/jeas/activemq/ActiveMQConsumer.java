package cn.jeas.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class ActiveMQConsumer {
	@Test
	public void test01() throws Exception{
		//获取消息连接工厂（jdk的jms规范）
		//默认用户名、密码、路径
		//路径：tcp://host:port,如：tcp://localhost:61616
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
		//获取一个消息连接
		Connection connection = connectionFactory.createConnection();
		//开启连接（消费者必须手动开启）
		connection.start();
		//建立消息会话
		//参数1：必须是手动提交
		//参数2：
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建队列（或者话题）对象
		Queue queue=session.createQueue("helloworld");
		//创建消费者
		MessageConsumer consumer=session.createConsumer(queue);
		//循环接收消息
		while (true) {
			//10s钟接收不到消息则自动退出接收，参数为超时时间
			Message message = consumer.receive(50000);
			if(message!=null){
				System.out.println(((TextMessage)message).getText());
			}else{
				System.out.println("++++退出消息接收。。");
				break;
			}
			
		}
		//关闭连接
		consumer.close();
		session.close();
		connection.stop();
		connection.close();
	}
}
