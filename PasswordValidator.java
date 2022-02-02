package chapter8;

/* ************INSTRUCTIONS**************
*Validate the complexity of a password by assuring it meets the following rules:
* at least 8 characters long
* contains an uppercase letter
* contains a special character
* not contain the username
* not the same as the old password
* ***************************************
*/


import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {

        //Set the rules.
        System.out.println("Welcome to the password changer. Your new password must follow the following rules:");
        System.out.println("Your password must contain an uppercase letter.");
        System.out.println("Your password must use at least on of these special characters: ! @ $ %");
        System.out.println("Your password must be at least 8 characters long.");
        System.out.println("Your password must NOT contain your username.");
        System.out.println("Your password must NOT be the same as your old password.");

        //Get the username.
        String username = getUsername();

        //Get the old password.
        String lastPassword = oldPassword();

        //Get the new password.
        String password = newPassword();

        //Verify that the new password has an uppercase letter.
        String upperCase = hasUpperCase(password);
        System.out.println(upperCase);

        //Verify that the new password is at least 8 characters long.
        String passwordLength = minimumCharacters(password);
        System.out.println(passwordLength);

        //Verify that the new password contains a special character.
        String specialCharacters1 = "!";
        String specialCharacters2 = "@";
        String specialCharacters3 = "$";
        String specialCharacters4 = "%";
        String containsSpecialCharacters = containsSpecialCharacters(specialCharacters1, specialCharacters2, specialCharacters3, specialCharacters4, password);
        System.out.println(containsSpecialCharacters);

        //Verify that the new password does not contain the username.
        String containsUsername = containsUsername(username, password);
        System.out.println(containsUsername);

        //Verify that the new password is not the same as the old password.
        String differentPassword = unchangedPassword(password, lastPassword);
        System.out.println(differentPassword);
    }

    public static String getUsername() {
        System.out.println("Enter your username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.println("Username: " + username);
        return username;
    }

    public static String oldPassword() {
        System.out.println("Enter your old password: ");
        Scanner scanner = new Scanner(System.in);
        String oldPassword = scanner.next();
        System.out.println("Old Password: " + oldPassword);
        return oldPassword;
    }

    public static String newPassword() {
        System.out.println("Enter your new password: ");
        Scanner scanner = new Scanner(System.in);
        String newPassword = scanner.next();
        System.out.println("New Password: " + newPassword);
        return newPassword;
    }

    /*
    *Remember that "i" is always a number.
    * Make sure to use the variable assigned as "char" (c in this function) when searching each character
    * for the uppercase letter!
    */
    public static String hasUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                String upperCaseFound = "Uppercase letter found.";
                return upperCaseFound;
            }
        }
        String notFound = "Error! You must use at least 1 uppercase letter in your password!";
        return notFound;
    }

    /*
    *The computer doesn't know what to do with a boolean value, I need to tell it what to do.
    * It needs precise instructions, and remember to use == for "exactly equals"
    * when comparing variables/objects. Also remember NOT to add un-needed variables to the
    * MAIN variables.
    */
    public static String unchangedPassword(String lastPassword, String password){

        var x = lastPassword.equals(password);

        if(x == true){
            String unchangedPassword = "Error! The new password cannot be the same as the old password!";
            return unchangedPassword;

        }
        String notSameAsOldPassword = "Great, the new password is different than the old password!";
        return notSameAsOldPassword;
        }

    public static String containsUsername(String username, String password) {

        var x = password.contains(username);

        if(x == true){
            String containsUsername = "Error! The new password cannot contain your username!";
            return containsUsername;
        }
        String doesNotContainUsername = "Great! The new password does not contain your username!";
        return doesNotContainUsername;
    }

    //Checks to see if the new password contains a special character.
    public static String containsSpecialCharacters(String specialCharacters1, String specialCharacters2, String specialCharacters3, String specialCharacters4, String password){
         var a = password.contains(specialCharacters1);
         var b = password.contains(specialCharacters2);
         var c = password.contains(specialCharacters3);
         var d = password.contains(specialCharacters4);

         if(a == true || b == true || c == true || d == true){
             String containsSpecialCharacters = "Great! A special character was found!";
             return containsSpecialCharacters;
         }
         String doesNotContainSpecialCharacters = "Error! A special character was not found! Please enter a new password containing at least one of the required special characters.";
         return doesNotContainSpecialCharacters;
    }

    //Checks to make sure the new password is at least 8 characters long.
    public static String minimumCharacters(String password){

        var x = password.length();

        if(x >= 8){
            String minimunLength = "Your password contains at least 8 characters!";
            return minimunLength;
        }
        String notLongEnough = "Password too short! Your new password must contain at least 8 characters!";
        return notLongEnough;
    }
}



