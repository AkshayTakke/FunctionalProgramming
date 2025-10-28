package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        // Java way simple method
        System.out.println(getDBConnectionUrl());

        // Supplier way
        System.out.println(getDBConnectionUrlsSupplier.get());
    }

    // Java way simple method
    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    // Supplier way
    static Supplier<List<String>> getDBConnectionUrlsSupplier = ()
            -> List.of(
                    "jdbc://localhost:5432/users",
                    "jdbc://localhost:5432/customer");

}
