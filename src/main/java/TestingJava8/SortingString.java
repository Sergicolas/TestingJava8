package TestingJava8;

import TestingJava8.Utils.ComparingBySize;
import TestingJava8.Utils.InLinePrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SortingString {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("Sergio");
        words.add("Castello");
        words.add("Zanellato");

        /** Spring implements Comparable that will always compare from A to Z **/
        Collections.sort(words);
        System.out.println("\nSorted list using Spring Comparable and Collections");
        System.out.println(words);

        /** Customising Sort using Comparator and the Java 8 default method "sort" of List Interface **/
        Comparator<String> comparator = new ComparingBySize();
        words.sort(comparator);
        System.out.println(words);

        /** Iterating a list with the Java 8 default method "forEach" of List Interface **/
        Consumer<String> consumer = new InLinePrint();
        words.forEach(consumer);

        /** Iterating a list with the Java 8 default method "forEach" and also using an Anonymous class **/
        Consumer<String> anonymousConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        words.forEach(anonymousConsumer);

        /** Iterating a list using "forEach" and also using an "ugly" Lambda **/
        System.out.println("\nSorted list by size using an ugly Lambda");
        words.forEach((String s) -> {
            System.out.println(s);
        });

        /** Iterating a list using "forEach" and also using a good Lambda **/
        System.out.println("\nSorted list by size using a good Lambda");
        words.forEach(s -> System.out.println(s)
        );

        /** Iterating a list using "forEach" and also using the best Lambda **/
        System.out.println("\nSorted list by size using the best Lambda");
        words.forEach(System.out::println);

        /** Customising Sort using comparator as an "ugly" Lambda **/
        words.sort((String s1, String s2) -> {
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())
                return 1;
            return 0;
        });
        System.out.println("\nSorted list using Lambda as Comparator Interface: ");
        System.out.println(words);

        /** Customising Sort using comparator as a "better" Lambda using Integer class method "Compare"**/
        words.sort((s1, s2) -> {
            return Integer.compare(s1.length(), s2.length());
        });
        System.out.println("\nSorted list using Lambda and Integer.compare: ");
        System.out.println(words);


        /** Customising Sort using comparator as the best Lambda using Integer class method "Compare"**/
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("\nSorted list using Lambda and Integer.compare: ");
        System.out.println(words);

        /** Customising Sort using Method Reference from Comparator Interface and lambda**/
        //words.sort(Comparator.comparing(s -> s.length()));
        words.sort(Comparator.comparing(String::length));
        System.out.println("\nSorted list using Lambda and Method Rerefence: ");
        System.out.println(words);
    }
}





