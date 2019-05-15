package com.javasampleapproach.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.google.gson.Gson;

public class MyTransform implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String myString = exchange.getIn().getBody(String.class);
		Gson gson = new Gson();
		Page page = gson.fromJson(myString, Page.class);
		System.out.println("MyProcessor complete " +page.toString());
        exchange.getIn().setBody(gson.toJson(page));

	}

}
