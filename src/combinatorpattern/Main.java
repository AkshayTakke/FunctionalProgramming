package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.isEmailValid;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+028343439382483947",
                LocalDate.of(2015, 1, 1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid we cam store customer in db

        // Using Combinator pattern

        CustomerRegistrationValidator.ValidationResult validationResult = isEmailValid()
                    .and(CustomerRegistrationValidator.isPHONENUMBERValid())
                    .and(CustomerRegistrationValidator.isAnAdult())
                    .apply(customer);

        System.out.println(validationResult);

        if (validationResult != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(validationResult.name());
        }
    }
}
