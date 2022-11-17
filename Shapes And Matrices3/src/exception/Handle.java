package exception;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Color.RGB.Error;
import static Color.RGB.*;

public class Handle {
    public static final int NUMBER_OF_TRY = 3; // selected number of try's
    public static final int MAX = Integer.MAX_VALUE;
    private static Scanner scanner = new Scanner(System.in);

    public static double getLength(String printString) {
        int NofTry = Handle.NUMBER_OF_TRY;
        do {
            System.out.println(Shape("-->") + Hint(" Hint : Type (q) To Quit From Input."));
            System.out.print(Shape("# ") + printHandle(printString));
            String input = scanner.nextLine();
            try {
                Exception e = validateString(input);
                if (e != null) throw e; // if validateString return exception throw it
                double number = Double.parseDouble(input);
                // if number is negative value
                if (number <= 0) throw new Exceptions.NegativeNumberException();
                return number; // if everything is right
            } catch (Exceptions.QuitException e) {
                break; // to make user out to input
            } catch (Exception e) {
                System.out.println(Shape("--> ") + Error(e.toString()));
            }
            if (--NofTry != 0) {
                System.out.print(Shape("-->") + Hint(" Warning : The Input Cancel After "));
                System.out.println(Hint(NofTry + (NofTry == 1 ? " Try." : " Tries.")));
            }
        } while (NofTry != 0);
        System.out.println(Shape("-->") + Error(" Input Canceled."));
        return -1;
    }

    public static int Range(String printString, int max) {
        int NofTry = Handle.NUMBER_OF_TRY;
        do {
            System.out.println(Shape("-->") + Hint(" Hint : Type (q) To Quit From Input."));
            System.out.print(Shape("# ") + printHandle(printString));
            String input = scanner.nextLine().trim();
            try {
                Exception e = validateString(input);
                if (e != null) throw e; // if validateString return exception throw it
                if (input.contains(".")) throw new Exceptions.DoubleException();
                int number = Integer.parseInt(input);
                // if number is negative value
                if (number <= 0) throw new Exceptions.NegativeNumberException();
                if (number > max) throw new Exceptions.OutOfRangeException("" + max);
                return number; // if everything is right
            } catch (Exceptions.QuitException e) {
                break; // to make user out to input
            } catch (Exceptions.DotException e) {
                System.out.println(Shape("--> ") + Error("Error : Please Enter Positive Number."));
            } catch (Exception e) {
                System.out.println(Shape("--> ") + Error(e.toString()));
            }
            if (--NofTry != 0) {
                System.out.print(Shape("-->") + Hint(" Warning : The Input Cancel After "));
                System.out.println(Hint(NofTry + (NofTry == 1 ? " Try." : " Tries.")));
            }
        } while (NofTry != 0);
        System.out.println(Shape("-->") + Error(" Input Canceled."));
        return -1;
    }

    public static Exception validateString(String input) {
        // check if include one char with numbers
        Matcher matcher;
        // to clean input in right and left from spaces
        input = input.trim();

        // check if string empty
        if (input.isEmpty()) return new Exceptions.EmptyException();

        // check if include space
        if (input.contains(" ")) return new Exceptions.SpaceException();

        // check if q char or not
        if (input.equalsIgnoreCase("q")) return new Exceptions.QuitException();

        // To match input with regex expiation
        matcher = Pattern.compile("^[+\\-]?[\\d\\.]*([^\\d\\.\\-+*/])[\\d\\.]*$").matcher(input);
        if (matcher.find()) return new Exceptions.OneCharException(matcher.group(1));

        // check if include one char without numbers
        matcher = Pattern.compile("^([^\\d])$").matcher(input);
        if (matcher.find()) return new Exceptions.OneCharException(matcher.group(1));

        // check if include string and spacial character
        matcher = Pattern.compile("([\\d]*[^\\d\\.\\-\\+\\*/]+[\\d]*)|[^\\d]{2,}").matcher(input);
        if (matcher.find()) return new Exceptions.StringException();

        // check if include mathematical operator or not
        matcher = Pattern.compile("[\\+\\-]?[\\d\\.]+([\\+\\-\\*/])[\\d\\.]*").matcher(input);
        if (matcher.find()) return new Exceptions.MathematicalOperationException();

        // check if include more than dot '.' or not
        matcher = Pattern.compile("[\\d]*\\.[\\d]*\\.[\\d]*").matcher(input);
        if (matcher.find()) return new Exceptions.DotException();

        return null;
    }

    public static double round(double number) {
        return Math.round(number * 10E3) / 10E3;
    }
}