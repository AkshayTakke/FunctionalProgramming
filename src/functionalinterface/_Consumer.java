package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Normal java Function
        Customer maria = new Customer("Maria", "9999");
        greetCustomer(maria);

        // Normal multiple input java Function
        greetCustomer(maria, true);

        // Consumer Functional interface
        greetCustomerConsumer.accept(new Customer("Maria", "9999"));

        // Bi Consumer implementation Function
        greetCustomerBiConsumer.accept(maria, false);
    }

    // Bi Consumer implementation
    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = ((customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName + ", " +
                    "thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "*****"))
            );

    // Consumer Functional interface
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + ", " +
                    "thanks for registering phone number " + customer.customerPhoneNumber);

    // Normal java Function
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", " +
                "thanks for registering phone number " + customer.customerPhoneNumber);
    }

    // Normal java Function of multiple input
    static void greetCustomer(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName + ", " +
                "thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "*****"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
