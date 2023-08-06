package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Flux is publisher 0 or N Items

        // Mono 0 or 1 items

        // Use ReactiveSources.intNumbersFlux()


        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        List<Integer> integers = ReactiveSources.intNumbersFlux().toStream().toList();
        System.out.println("List is: " + integers);

        List<Integer> integers1 = ReactiveSources
                .intNumbersFlux()
                .log()
                .toStream()
                .toList();

        System.out.println("List is: " + integers1);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
