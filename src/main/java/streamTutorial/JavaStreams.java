package streamTutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) throws IOException {

        //1. Integer Stream
        IntStream
                .range(1,10) //exclusive 10
                .forEach(System.out::print);
        System.out.println();
        //2. Integer Stream with skip
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();
        //3. Integer Stream with sum
        System.out.println(
        IntStream
                .range(1,5)
                .sum());
        System.out.println();
        //4. Stream of, sorterd and findFirst
        Stream.of("Hanna", "Krzysztof", "Michal", "Anna", "Krystian", "Martyna", "Adam") // you can stream everything, strings, ints, objects, ect.
                .sorted() //straight alpabetical sort, can be reverse
                .findFirst()
                .ifPresent(System.out::print); //print first item on the list in my case it's Adam
        System.out.println();
        //5. Stream from Array, sort, filter and print
        String [] names = {"Hanna", "Krzysztof", "Michal", "Anna", "Krystian", "Martyna", "Adam"};
        Arrays.stream(names)  //same as Stream.of(names)
                .filter(x->x.startsWith("K"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();
        //6. Average of squares of an int array
        Arrays.stream(new int[] {1,2,3,4,5})
                .map(x->x*x)
                .average()
                .ifPresent(System.out::println); // print double instead of int
        System.out.println();
        //7. Stream from List, filter and pring
        List<String> listOfNames = Arrays.asList("Hanna", "Krzysztof", "Michal", "Anna", "Krystian", "Martyna", "Adam");
        listOfNames.stream()
                .map(String::toLowerCase)
                .filter(x->x.startsWith("a"))
                .forEach(System.out::println);
        System.out.println();
        //8. Stream rows from text file, sort, filter and print
        Stream<String> friends = Files.lines(Paths.get("friends.txt"));
        friends.sorted().filter(x->x.length()>5).forEach(System.out::println);
        friends.close();
        System.out.println();
        //9. Stream rows from text file and save to List
        List<String> friends2 = Files.lines(Paths.get("friends.txt"))
                .filter(x->x.contains("na"))
                .collect(Collectors.toList());
        friends2.forEach(x-> System.out.println(x));
        System.out.println();
        //10. Stream rows from CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get("text.txt"));
        int rowCount = (int)rows1
                .map(x->x.split(","))
                .filter(x->x.length == 3)
                .count(); //count rows in file text.txt where length is 3
        System.out.println(rowCount + " rows.");
        rows1.close();
        System.out.println();
        //11. Stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("text.txt"));
        rows2
                .map(x->x.split(","))
                .filter(x->x.length == 3)
                .filter(x->Integer.parseInt(x[1])>15) //select row 1 greater than 15
                .forEach(x-> System.out.println(x[0] + " " + x[1] + " " + x[2])); // print selected rows
        rows2.close();
        System.out.println();
        //12. Stream rows from CSV file, store fields in HashMap
        Stream<String> rows3 = Files.lines(Paths.get("text.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x->x.split(","))
                .filter(x->x.length == 3)
                .filter(x->Integer.parseInt(x[1])>15)
                .collect(Collectors.toMap(
                        x->x[0], //returns first row in
                        x->Integer.parseInt(x[1]))); //value
        /*
        Usually the parse() method receives some string as input,
        "extracts" the necessary information from it and converts it into an object of the calling class.
        For example, it received a string and returned the date that was "hiding" in this string.
         */
        rows3.close();
        for (String key : map.keySet()){
            System.out.println(key + " " + map.get(key)); //print key and value using for loop
        }
        System.out.println();
        //13. Reduction - sum
        double total = Stream.of(1.2,0.7,1.0)
                .reduce(0.0, (Double a, Double b) -> a + b);
        //0.0 - starting value
        //Double - declare type of value
        //a - total
        //b - new item
        System.out.println("Total " + total);
        System.out.println();
        //14. Reduction - summary statistics (works for integers only)
        IntSummaryStatistics statistics = IntStream.of(10,14,7,19,15,12)
                .summaryStatistics();
        System.out.println(statistics);


    }
}
