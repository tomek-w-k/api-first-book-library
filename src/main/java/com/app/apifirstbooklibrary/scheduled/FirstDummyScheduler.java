package com.app.apifirstbooklibrary.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class FirstDummyScheduler {

    private enum TestEnum {
        FIRST,
        SECOND,
        THIRD
    }

    //@Scheduled(fixedDelay = 1000)
    public void firstScheduledTask() {
        final TestEnum testEnum = Math.random() > 0.5 ? TestEnum.FIRST : TestEnum.SECOND;
        System.out.println(testEnum);
    }

    @Scheduled(fixedDelay = 1000)
    public void secondScheduledTask() {
        final double random = Math.random();
        final String msg = random > 0.5 ? "present" : null;

        System.out.print("random :: " + random );
        Optional.ofNullable(msg).ifPresent(v -> System.out.print("\n"));
//        Optional.ofNullable(msg)
//                .ifPresentOrElse(v -> {}, () -> System.out.println("null"));

        final String get = Optional.ofNullable(msg)
                .orElseGet(() -> "null");

        System.out.println(get);
    }

    //@Scheduled(fixedDelay = 1000)
    public void thirdScheduledTask() {
        final TestEnum testEnum = null;
        final String msg = testEnum == TestEnum.FIRST ? "YES" : "NO";

        System.out.println(msg);
    }
}
