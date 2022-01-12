package com.macy.config;

import com.macy.util.Constants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.DestinationConfigurer;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2XmlMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;;

@Configuration
public class ProducerMessageConfig {

	@Bean
	public TopicExchange getExchange() {

		return new TopicExchange(Constants.EXCHANGE);
	}

	@Bean(name = "xmltemplate")
	public RabbitTemplate getXMLAmqpTemplate(ConnectionFactory connectionFactory) {

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2XmlMessageConverter());
//		rabbitTemplate.setRoutingKey(Constants.ROUTING_XML_KEY);
		return rabbitTemplate;
	}

	@Bean(name = "jsontemplate")
	public RabbitTemplate getJsonAmqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//		rabbitTemplate.setRoutingKey(Constants.ROUTING_JSON_KEY);
		return rabbitTemplate;
	}

	@Bean
	public Binding getXMLBinding(TopicExchange exchange) {
		return BindingBuilder.bind(getXMLQueue()).to(exchange).with(Constants.ROUTING_XML_KEY);
	}

	@Bean
	public Binding getJsonBinding(TopicExchange exchange) {

		return BindingBuilder.bind(getJsonQueue()).to(exchange).with(Constants.ROUTING_JSON_KEY);
	}

	@Bean
	public Queue getXMLQueue() {
		return new Queue(Constants.QUEUE_XML);
	}

	@Bean
	public Queue getJsonQueue() {

		return new Queue(Constants.QUEUE_JSON);
	}

}
