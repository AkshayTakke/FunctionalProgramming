package optionals;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
       Object value1 =  Optional.ofNullable("Hello Optionals")
                .orElseGet(() -> "default value");
        System.out.println(value1);

        Object value2 =  Optional.ofNullable("world")
                .orElseThrow( () -> new IllegalArgumentException("Exception"));
        System.out.println(value2);

        Optional.ofNullable(null)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Email not present"));


    }
}
