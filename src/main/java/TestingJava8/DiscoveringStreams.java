package TestingJava8;

import TestingJava8.Model.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class DiscoveringStreams {

    public static void main(String[] args) {

        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Java 8", 150));
        courses.add(new Course("Python", 45));
        courses.add(new Course("Java Script", 113));
        courses.add(new Course("C", 55));

        /** Sorting list by number of students - using object data and his getter **/
        courses.sort(Comparator.comparing(Course::getStudents));
        //courses.forEach(course -> System.out.println(course.getCourseName()));

        /** Filtering list by number of students using Stream **/
        courses.stream()
                .filter(course -> course.getStudents() >= 100)
                .forEach(course -> System.out.println(course.getCourseName()));


        /** Filtering list by number of students using Stream, mapping the number of students of each course
            filtered and printing them at the end **/
        courses.stream()
                .filter(course -> course.getStudents() >= 100) //Predicate is a criteria for the filter
                .map(Course::getStudents)
                .forEach(System.out::println);

        /** Filtering list by number of students using IntStream, mapping the number of students of each course
         filtered and printing them at the end **/
        int sum = courses.stream()
                .filter(course -> course.getStudents() >= 100) //Predicate is a criteria for the filter
                .mapToInt(Course::getStudents).sum();
        System.out.println("Filtering list by number of students, mapping using IntStream and getting the sum. Sum = " + sum);


        /** Performing an action for each elements using PEEK,
            mapping the number after the action and printing them at the end **/
        courses.stream()
                .peek(course -> course.setStudents(course.getStudents() + 1)) // could be any action
                .map(Course::getStudents)
                .forEach(System.out::println);


        /** Performing a filter and returing a new List using Collectors **/
        List<Course> filteredCourses = courses.stream()
                .filter(course -> course.getStudents() >= 100)
                .collect(Collectors.toList());

        /** Utilising Optional Object functions **/
        courses.stream()
                .filter(course -> course.getStudents() >= 100)
                .findAny() //return an Optional Object
                .ifPresent(course -> System.out.println(course.getCourseName())); //Optional Function `if present`
    }
}
