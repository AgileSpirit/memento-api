package io.memento.infra.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = {"io.memento"})
public class ApplicationConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${environment}")
    private String environment;

    @PostConstruct
    public void doBootstrap() {
        LOGGER.info("Application is up on environment '" + environment + "' !");
    }

}
