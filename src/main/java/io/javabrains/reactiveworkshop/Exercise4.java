package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(e -> System.out.println(e));

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Integer integer = ReactiveSources.intNumberMono().block();
        System.out.println(integer);

        Optional<Integer> integer1 = ReactiveSources.intNumberMono().blockOptional();
        System.out.println(integer1);

        User block = ReactiveSources.userMono().block();
        System.out.println(block);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
