package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function takes one argument and produces one result
        int increment = increment(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10);

        System.out.println(addBy1AndMultiplyBy10.apply(4));

        // BiFunction takes two argument and produces one result
        System.out.println(increamentByOneAndMultiplyBiFunction.apply(4, 100));
    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10 =
            number -> number * 10;

    static int increment(int number) {
        return number + 1;
    }

    static int increamentByOneAndMultiply(int number, int multiplyBy) {
        return  (number + 1) * multiplyBy;
    }

    static BiFunction<Integer, Integer, Integer> increamentByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiply)
            -> (numberToIncrementByOne + 1) * numberToMultiply;
}
