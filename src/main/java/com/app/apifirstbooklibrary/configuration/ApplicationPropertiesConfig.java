package com.app.apifirstbooklibrary.configuration;

import com.app.apifirstbooklibrary.properties.PropertyProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties({
        PropertyProperties.class
})
public class ApplicationPropertiesConfig {
}
