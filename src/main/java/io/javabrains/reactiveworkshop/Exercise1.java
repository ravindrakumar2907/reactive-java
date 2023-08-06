package io.javabrains.reactiveworkshop;

import java.util.Arrays;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
        }

        /**
         * Map -- subtitiute 1 element from stream with another element
         * filter - decide for condition and check if certail elements needs to coninue or not
         * flatMap-- allow you to take another stream and flat map it
         * findFirst --> find the first element in the stream that machtes the pattern
         * ...
         */

        numbers.stream().forEach(number -> System.out.print(number));

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println(" Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().forEach(number -> System.out.print(number));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream().filter(num -> num < 5).forEach(num -> System.out.println(num));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(num -> num > 5).skip(1).limit(2).forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println(" Print the first number in intNumbersStream that's greater than 5.");
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(num -> num > 5).findFirst().orElse(-1).intValue();

        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        // TODO: Write code here
        StreamSources.userStream().map(user -> user.getFirstName()).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream().map(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .forEach(System.out::println);

        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream()
                        .filter(user -> user.getId() == id))
                .map(user -> user.getFirstName()).forEach(System.out::println);

        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
                .forEach(u -> System.out.println(u));

    }

}
