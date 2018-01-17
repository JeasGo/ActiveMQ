package cn.jeas.activemq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-mq-consumer.xml")
public class ConsumerTest {
	
	@Test
	public void testSendMessage(){
		while(true){
			//junit退出时方防止该程序进程都被释放。
		}
	}

}
