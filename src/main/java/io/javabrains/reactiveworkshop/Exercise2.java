package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .subscribe(
                        e -> System.out.println(e),
                        err -> System.out.println(err),
                        () -> System.out.println("complete")
                );

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

        // Adding multiple callback
        Flux<User> userFlux = ReactiveSources.userFlux();
        userFlux.subscribe(user -> System.out.println(user));
        userFlux.subscribe(user -> System.out.println("New one" + user));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
