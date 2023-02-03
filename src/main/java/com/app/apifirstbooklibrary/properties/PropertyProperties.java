package com.app.apifirstbooklibrary.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;


@ConfigurationProperties(prefix = "property")
public class PropertyProperties {

    private final Integer first;
    private final Integer second;
    private final Integer third;
    private final Integer fourth;
    private final Integer fifth;
    private final boolean sixth;


    @ConstructorBinding
    public PropertyProperties(Integer first, Integer second, Integer third, Integer fourth, Integer fifth, boolean sixth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public Integer getThird() {
        return third;
    }

    public Integer getFourth() {
        return fourth;
    }

    public Integer getFifth() {
        return fifth;
    }

    public boolean isSixth() {
        return sixth;
    }
}
