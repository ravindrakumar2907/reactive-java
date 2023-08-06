package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        /*
        ReactiveSources.intNumbersFlux().subscribe(
                item -> System.out.println(item),
                e -> System.out.println(e.getMessage()),
                () -> System.out.println("done")
        );


        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(
                user -> System.out.println(user),
                e -> System.out.println(e.getMessage()),
                () -> System.out.println("Done")
        );
*/
        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscriber(Subscription subscription) {
        System.out.println("subscription event");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println("Value :" + value.toString());
        request(1);// backpressor contoller
    }

}