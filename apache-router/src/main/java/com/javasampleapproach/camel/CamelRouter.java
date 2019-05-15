package com.javasampleapproach.camel;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {
	
	private Logger logger = Logger.getLogger(CamelRouter.class.getName());
	
	String queueIn = "jms:queue:IN";
	
	String queueOut_1 = "jms:queue:OUT_1";
	
	String queueOut_2 = "jms:queue:OUT_2";
	
	String queueOut_3 = "jms:queue:OUT_3";
	
    @Override
    public void configure() throws Exception {
    	System.out.println("Success starts");
       /* from(queueIn)
        .choice()
        	.when()
        		.simple("${body} contains 'Berlin'")
        		.to(queueOut_1)
        	.when()
         	 	.simple("${body} contains 'Newyork'")
         	 	//.to("jolt:/spec.json?inputType=JsonString&outputType=JsonString")
         	 	//.to("file://transformed.json")
         	 	.to(queueOut_2)
         	.otherwise()
         		.to("jolt:/spec.json?inputType=JsonString&outputType=JsonString")
         		.to("file://transformed.json")	
         		.to(queueOut_3)
        .endChoice();*/
        
        logger.info("Started routing input json");
        try {
        	from("file://scanned?fileName=input.json")
        	.process(new MyTransform())
        	.to("jolt:/spec.json?inputType=JsonString&outputType=JsonString").to("file://transformed");
        	logger.info("Transformed routing input json");
        }catch(Exception e){
        	logger.log(Level.SEVERE,e.getMessage());
        } 
        
        System.out.println("Success comma");
    }
}