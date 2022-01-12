package com.macy.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macy.dto.FulFillmentOrder;
import com.macy.dto.Name;
import com.macy.dto.OrderJsonDto;
import com.macy.dto.OrderStatus;
import com.macy.util.Constants;

@RestController
@RequestMapping("/ordermessageproducer")
public class OrderMessageController {

	@Autowired
	@Qualifier("jsontemplate")
	RabbitTemplate rabbitJsonTemplate;

	@Autowired
	@Qualifier("xmltemplate")
	RabbitTemplate rabbitXmlTemplate;

	@PostMapping(value = "/producexmlordermessage", consumes = MediaType.APPLICATION_XML_VALUE) // produces =
																								// MediaType.APPLICATION_XML_VALUE
	public Boolean pumpXMLMessage(@RequestBody FulFillmentOrder order) {
		rabbitXmlTemplate.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_XML_KEY, order);
		return true;
	}

	@PostMapping(value = "/producejsonordermessage", consumes = MediaType.APPLICATION_JSON_VALUE) // produces =
																									// MediaType.APPLICATION_JSON_VALUE
	public Boolean pumpJSONMessage(@RequestBody OrderJsonDto order) {
		rabbitJsonTemplate.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_JSON_KEY, order);
		return true;
	}
}
