package java8;


import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface FunctionalIntTest {
    public String appendStringWithTimeStamp(String input);
}

public class Java8FuncIntFlatMap {
    public static void main(String[] args) {

//Functional Interface with multi-line implementation
        FunctionalIntTest fit = (input) -> {
            input = input+" "+ LocalDateTime.now().toString();
            return input;
        };
        log(fit.appendStringWithTimeStamp("Funky"));

//Functional interface example with single line implementation
        Runnable runnableTest = () -> System.out.println("Runnable with functional interface example "+Thread.currentThread().toString());
        new Thread(runnableTest).start();

//Custom Predicate Example - with filter, map
        Predicate<String> nameStartswithA = nameS -> nameS.startsWith("A");
        List<String> namesList = Arrays.asList("Tom","Jerry","Amigo", "Lam", "Aniken");
        String filteredNames = namesList
                .stream()
                .filter(nameStartswithA)
                .map(String::toUpperCase)   //Map to apply uppercase operation on each resulting string //this can be predicate
                .collect(Collectors.joining(" , "));
        log(filteredNames);

//Flat map example and REDUCE example
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1,2), Arrays.asList(3,4));
        Integer finalSum = listStream
                .flatMap(List::stream)  //converting list of streams into list<int>
                .map(i -> 1+1)          //adding each element with 1
                .reduce(0,Integer::sum);   //reduced the array to a whole sum
        log("Flat Map, reduce Example "+finalSum);

//Streams on STRINGS :: Count words
        String splitAndCount = "Hello my name is umakanth, hello! my name is tom, hello my name is jerry";
        log("Stream string count all words in string "+Arrays.stream(splitAndCount.split( " ")).count());

        Map<String,Integer> wordCountMap = Arrays.stream(splitAndCount.split(" "))
                .map(String::toUpperCase)
                .collect(Collectors.toMap(word -> word ,word->1, Integer::sum));

        log(wordCountMap);


//Streams on STRINGS :: Count characters
        Map<String,Integer> charCountMap = Stream.of(splitAndCount.split(""))
                .filter(c -> !c.trim().isEmpty())
                .collect(Collectors.toMap(c -> c ,c->1,Integer::sum));

        log(charCountMap.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .findFirst());


    }

    static void log(Object input){
        System.out.println(input);
    }
}
