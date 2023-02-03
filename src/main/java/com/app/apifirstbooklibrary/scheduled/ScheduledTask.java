package com.app.apifirstbooklibrary.scheduled;

import com.app.apifirstbooklibrary.properties.PropertyProperties;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.netty.http.client.HttpClient;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


@Component
@ConditionalOnProperty(value = "scheduler.enable-scheduled-task", havingValue = "enable", matchIfMissing = false)
public class ScheduledTask {

    private static final String[] STATIC_STRING_ARRAY = {"First", "Second", "Third"};
    private int counter = 0;

    private PropertyProperties propertyProperties;


    public ScheduledTask(PropertyProperties propertyProperties) {
        this.propertyProperties = propertyProperties;
    }

    //@Scheduled(fixedDelay = 1000)
    @Scheduled(cron = "${scheduler.cron}")
    public void printMessage() {
        System.out.println(getMaxPropertyValue());
    }

    private URI getUri() {
        URI uri = URI.create("https://www.google.com");
        uri = URI.create(uri.toString() + "aaa");

        return uri;
    }

    private int getMaxPropertyValue() {
        return Arrays.stream(PropertyProperties.class.getDeclaredFields())
                .map(field -> {
                    field.setAccessible(true);

                    Integer fieldValue = null;
                    try {
                        fieldValue = (Integer)field.get(propertyProperties);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }

                    return fieldValue;
                })
                .max(Comparator.comparing(Integer::valueOf))
                .get();
    }
}
