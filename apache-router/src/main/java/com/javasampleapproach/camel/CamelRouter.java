package com.javasampleapproach.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {
	
	String queueIn = "jms:queue:IN";
	
	String queueOut_1 = "jms:queue:OUT_1";
	
	String queueOut_2 = "jms:queue:OUT_2";
	
	String queueOut_3 = "jms:queue:OUT_3";
	
    @Override
    public void configure() throws Exception {
        from(queueIn)
        .choice()
        	.when()
        		.simple("${body} contains 'o1'")
        		.to(queueOut_1)
        	.when()
         	 	.simple("${body} contains 'o2'")
         	 	.to(queueOut_2)
         	.otherwise()
         		.to(queueOut_3)
        .endChoice();
    }
}