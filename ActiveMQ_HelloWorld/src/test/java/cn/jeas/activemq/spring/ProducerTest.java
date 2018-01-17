package cn.jeas.activemq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jeas.activemq.producer.queue.QueueSender;
import cn.jeas.activemq.producer.topic.TopicSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-mq-producer.xml")
public class ProducerTest {
	@Autowired
	private QueueSender queueSender;
	@Autowired
	private TopicSender topicSender;
	
	@Test
	public void testSendMessage(){
		for (int i = 0; i < 10000000; i++) {
			//只有同时一个消费者来调用
			queueSender.send("spring.queue","你好，贾兵兵-queue"+i);
			//有个有效期，过了有效期，则消费者无法订阅
			topicSender.send("spring.topic", "你好，程序猿-topic"+i);
		}
	
	}

}
