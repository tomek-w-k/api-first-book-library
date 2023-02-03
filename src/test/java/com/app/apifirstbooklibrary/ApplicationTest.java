package com.app.apifirstbooklibrary;

import com.app.apifirstbooklibrary.properties.PropertyProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private PropertyProperties propertyProperties;

    @Test
    void propertyTest() {
        if (propertyProperties.isSixth())
            System.out.println("works");
        else System.out.println("does not work");
    }
}
