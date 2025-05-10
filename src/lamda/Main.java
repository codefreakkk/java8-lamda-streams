package lamda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        // Consumer
        Consumer<String> consumer = (String s) -> {
            System.out.println(s);
        };
        consumer.accept("hello from consumer");

        // Supplier
        Supplier<String> supplier = () -> "hello from Supplier";
        String msg = supplier.get();
        System.out.println(msg);

        // Function
        Function<Integer, String> function = String::valueOf;
        String num = function.apply(69);
        System.out.println("Number converted to string : " + num);

        // Predicate
        Predicate<Integer> predicate = (Integer i) -> i % 2 == 0;
        System.out.println("Even " + predicate.test(10));

    }

}
