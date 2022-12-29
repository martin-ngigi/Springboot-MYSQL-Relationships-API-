package com.martin.sqlrelationships;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This will enable us to see the database UI in the browser,
 */
@Configuration
public class WebConfiguration {
    //http://localhost:8080/console/
    @Bean
    ServletRegistrationBean h2ServletRegistration(){
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(new WebdavServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
