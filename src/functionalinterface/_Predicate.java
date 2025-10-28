package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        // Simple java Validation Function
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09000077730"));

        // Predicate Validation Function
        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000077730"));

        System.out.println("With Multiple Predicate Using AND");
        System.out.println("Is phone Number valid and contains Number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("070000000"));

        System.out.println("With Multiple Predicate Using OR");
        System.out.println("Is phone Number valid and contains Number 3 = " +
                isPhoneNumberValidPredicate.or(containsNumber3).test("07000300000"));

        //Bi Predicate
        System.out.println("Bi Predicate");
        System.out.println(isPhoneNumberValidAndStartsWith.test("+3530200309", "+353"));
    }

    // Simple java Validation Function
    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    // Predicate Validation Function
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    // Predicate Validation Function
    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

    // Bi Predicates
    static BiPredicate<String, String> isPhoneNumberValidAndStartsWith =
            (phoneNumber, phoneNumberStartsWith)
                    -> phoneNumber.startsWith(phoneNumberStartsWith) && phoneNumber.length() == 11;

}
