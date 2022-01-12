package com.macy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.macy.controller.OrderMessageController;
import com.macy.dto.FulFillmentOrder;
import com.macy.dto.OrderJsonDto;
import com.macy.util.Constants;

@WebMvcTest(OrderMessageController.class)
public class OrderMessageControllerTest {
	@MockBean
	@Qualifier("jsontemplate")
	RabbitTemplate rabbitJsonTemplate;

	@MockBean
	@Qualifier("xmltemplate")
	RabbitTemplate rabbitXmlTemplate;
	
	@Autowired
	MockMvc mockMvc;
	
	
	private XmlMapper objectMapper = new XmlMapper();
	
	private JsonMapper jsonObjectMapper = new JsonMapper();

	
	FulFillmentOrder fulFillmentOrder1 = new FulFillmentOrder(1, "Digital", "SAM123", "Created", null, null, 0, null, 0, 0, null, null, null);
	OrderJsonDto orderJsonDto1 = new OrderJsonDto(1, "", "", "", "", 0, 0, 0, 0, null, null, 0, null, null);

	@Test
	public void testPumpXmlMessage() throws Exception {
		Mockito.doNothing().when(rabbitXmlTemplate).convertAndSend(fulFillmentOrder1);
		mockMvc.perform(MockMvcRequestBuilders.post("/ordermessageproducer/producexmlordermessage").contentType(MediaType.APPLICATION_XML_VALUE).content(objectMapper.writeValueAsString(fulFillmentOrder1))).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testPumpJsonMessage() throws Exception {
		Mockito.doNothing().when(rabbitJsonTemplate).convertAndSend(orderJsonDto1);
		mockMvc.perform(MockMvcRequestBuilders.post("/ordermessageproducer/producejsonordermessage").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonObjectMapper.writeValueAsString(fulFillmentOrder1))).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
