package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // TODO: Write code here
        /*
        ReactiveSources.intNumbersFlux()
                .log()
                .filter(n -> n > 5)
                .subscribe(System.out::println);

                ReactiveSources.intNumbersFlux()
                .filter(n -> n > 5)
                .log()
                .subscribe(System.out::println);
*/


        // Print 10 multiply by each value from intNumbersFlux that's greater than 5
        // TODO: Write code here
        /*
        ReactiveSources.intNumbersFlux()
                .filter(n -> n > 5)
                .map(n -> n * 10)
                .subscribe(System.out::println);
*/


        // Print 10 multiply by each value from intNumbersFlux for the first 3 numbers
        // emitted that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(n -> n > 5)
                .map(n -> n * 10)
                .take(3) // limit
                .subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(n -> n > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);

        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .flatMap(n -> ReactiveSources.userFlux().filter(u -> u.getId() == n))
                .subscribe(System.out::println);

        //get 1 element
        ReactiveSources.intNumbersFlux()
                .flatMap(n -> ReactiveSources.userFlux().filter(u -> u.getId() == n)).take(1)
                .subscribe(System.out::println);


        // Print only distinct numbers from intNumbersFluxWithRepeat
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .log()
                .subscribe();

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        // TODO: Write code here

        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged() // not same repeat
                .log()
                .subscribe();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
