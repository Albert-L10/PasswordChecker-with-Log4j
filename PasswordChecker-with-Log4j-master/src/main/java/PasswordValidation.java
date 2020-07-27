import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class PasswordValidation {
    private static final Logger logger = LogManager.getLogger(PasswordValidation.class.getName());public static void main(String[] args) {


        String password;
        Scanner key=new Scanner(System.in);

        System.out.println("Password specifications:");
        System.out.println("-password should exist");
        System.out.println("-password should be longer than than 8 characters");
        System.out.println("-password should have at least one lowercase letter");
        System.out.println("-password should have at least one uppercase letter");
        System.out.println("-password should at least have one digit");
        System.out.println("-password should have at least one special character\n");

        System.out.println("Enter password: ");
        password=key.next();

        try
        {

            validatePassword(password);


        }
        catch (PasswordException e)
        {
            logger.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void validatePassword(String password)throws Exception {

        boolean checkUpper = false;
        boolean checkLower = false;
        boolean checkNumber = false;
        boolean specCharacters = false;



        if (password.length() < 8) {

            throw new PasswordException("password should be longer than than 8 characters");
        }


        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {


                checkUpper = true;
            }

            if (Character.isLowerCase(c)) {

                checkLower = true;
            }

            if (Character.isDigit(c)) {

                checkNumber = true;
            }
            if (password.matches("(?=.*[~!@#$%^&*()_-" + "]).*")) {

                specCharacters = true;

            }
        }

        if (!checkUpper) {
            throw new PasswordException("password should have at least one uppercase letter");
        }
        if (!checkLower) {
            throw new PasswordException("password should have at least one lowercase letter");
        }
        if (!checkNumber) {
            throw new PasswordException("password should at least have one digit");
        }
        if (!specCharacters) {
            throw new PasswordException("password should have at least one special character");
        }

        System.out.println("User password is ok");



    }



}

