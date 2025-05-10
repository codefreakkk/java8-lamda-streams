package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public void waysToCreateStream() {

        // method 1
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = list.stream();

        // method 2
        Integer[] nums = {1, 2, 3};
        Stream<Integer> stream2 = Arrays.stream(nums);

        // method 3
        Stream<Integer> stream3 = Stream.of(nums);

        // method 4
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(10);
        streamBuilder.add(20);

        Stream<Integer> stream4 = streamBuilder.build();
    }

    public static void streamIntermediateMethods() {

        /*
         filter method
         */
        List<String> words = List.of("HI", "WORLD", "MY", "NAME", "IS", "HARSH");
        long count = words.stream()
                .filter((String word) -> word.length() > 2)
                .count();

        System.out.println("Words greater than count 2 -> " + count);

        /*
        Function :  <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        Description: The **map()** method in Java Streams is an intermediate operation that
                     transforms each element of the stream using a function.
         */

        List<String> lowerCaseWords = words.stream()
                .map((String word) -> word.toLowerCase())
                .collect(Collectors.toList());

        System.out.println("Lowercase words " + lowerCaseWords);

        /*
        Function:       flatMap
        Description:    **flatMap()** method in Java Streams is like a combination of map() and flatten().
                        It is used when each element of the stream is mapped to a stream itself, and
                        you want to flatten the resulting nested structure into a single stream.
         */

        List<List<Integer>> _2dList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );

        List<Integer> list = _2dList.stream()
                .flatMap((List<Integer> currentList) -> currentList.stream())
                .collect(Collectors.toList());

        System.out.println("Flatmap List " + list);

        /*
        Arrays.stream()
         */

        Integer[] arr = {3, 4, 2, 1, 6, 3};
        Stream<Integer> streamArray = Arrays.stream(arr);

        /*
        Function:       peek()
        Description:    helps you to see intermediate result of the stream which is getting passed
         */

        list.stream()
                .map((Integer num) -> num * -1)
                .peek((Integer num) -> System.out.println("Peek num " + num))
                .limit(2)
                .collect(Collectors.toList());

        /*
        limit: limits the record by given count
        skip: skips the starting record by given count
         */

        /*
        Function:      mapToInt
        Description:   The **mapToInt()** method in Java Streams is a specialized map operation
                       that is used when you want to convert elements of a stream to primitive
                       int values.
         */

        int[] array1 = list.stream()
                .mapToInt(num -> num)
                .toArray();

        System.out.println("mapToInt Array " + Arrays.toString(array1));

        /*
        Function:       min
        Description:    Returns the first element from list
         */

        Optional<Integer> minElement = list.stream()
                .min((Integer num1, Integer num2) -> num2 - num1);

        System.out.println("Min element " + minElement.get());

        /*
        Function:       max
        Description:    Returns the last element from list
         */

        Optional<Integer> maxElement = list.stream()
                .min((Integer num1, Integer num2) -> num2 - num1);

        System.out.println("Min element " + maxElement.get());
    }

    public static void main(String[] args) {
        streamIntermediateMethods();
    }
}
