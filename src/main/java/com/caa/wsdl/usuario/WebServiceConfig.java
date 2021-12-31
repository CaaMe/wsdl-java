package com.caa.wsdl.usuario;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs

public class WebServiceConfig extends WsConfigurerAdapter{
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}
	
	
	@Bean
	public XsdSchema customerSchema() {		
		return new SimpleXsdSchema(new ClassPathResource("wsdl-information.xsd"));
	}	
	
	//http://localhost:8080/ws/usuarios.wsdl
	@Bean(name = "usuarios")
	@CrossOrigin(origins = {"*", "http://localhost:4200"}, allowCredentials = "false")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema usuariosSchema)  {
		DefaultWsdl11Definition definition =  new DefaultWsdl11Definition();
		definition.setPortTypeName("UsuariosPort");
		definition.setTargetNamespace("http://com.wsdl");
		definition.setLocationUri("/ws");
		definition.setSchema(usuariosSchema);
		return definition;
	}

}
