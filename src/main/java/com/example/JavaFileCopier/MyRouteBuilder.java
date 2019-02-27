package com.example.JavaFileCopier;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("quartz://myTimer?trigger.repeatInterval=2000&trigger.repeatCount=-1")
		.setBody().simple("Current time is ${header.firedTime}")
		.to("stream:out");
	}
}
