package com.app.apifirstbooklibrary;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;


public class TestingTest {

    @Test
    void test() {
        IntStream.range(0, 10).forEach(i -> System.out.println(i));
    }
}
