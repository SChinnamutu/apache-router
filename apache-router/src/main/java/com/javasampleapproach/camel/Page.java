package com.javasampleapproach.camel;

import lombok.Data;

@Data
public class Page {
	
	private String uuid;
	private String pageId;
	private String location;
	private String country = "Gernamny";
	
}
