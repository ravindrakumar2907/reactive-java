package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // flux to Mono and Mono to Flux

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().count();

        ReactiveSources.intNumbersFlux().count().subscribe(count -> System.out.println(count));

        // Collect all items of intNumbersFlux into a single list and print it
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().collectList().subscribe(list -> System.out.println(list));

        // Transform to a sequence of sums of adjacent two numbers
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .buffer(2)
                .map(list -> list.get(0) + list.get(1))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
//https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#log--
}
