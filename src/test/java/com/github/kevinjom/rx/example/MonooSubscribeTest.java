package com.github.kevinjom.rx.example;

import org.junit.jupiter.api.Nested;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class MonooSubscribeTest {

    @Nested
    class ReactorMono {
        @Test
        void monoSubscribe() {

            Mono<Integer> publisher = Mono.just(1);

            List<String> invocation = new ArrayList<>();

            Consumer<Integer> valueConsumer = i -> {
                invocation.add("onNext:" + i);
            };

            Consumer<Throwable> errorConsumer = null;

            Runnable completeConsumer = () -> {
                invocation.add("onComplete");
            };

            publisher.subscribe(valueConsumer, errorConsumer, completeConsumer);

            assertThat(invocation).containsExactly(
                    "onNext:1",
                    "onComplete"
            );
        }

    }


    @Test
    void monooSubscribe() {

        Monoo<Integer> publisher = Monoo.just(1);

        List<String> invocation = new ArrayList<>();

        Consumer<Integer> valueConsumer = i -> {
            invocation.add("onNext:" + i);
        };

        Consumer<Throwable> errorConsumer = null;

        Runnable completeConsumer = () -> {
            invocation.add("onComplete");
        };

        publisher.subscribe(valueConsumer, errorConsumer, completeConsumer);

        assertThat(invocation).containsExactly(
                "onNext:1",
                "onComplete"
        );
    }
}