package Run;

import Color.RGB;
import Sections.MainMatrices;
import Sections.MainShape;
import exception.Handle;

import java.util.Scanner;

public class App {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print(RGB.Default);
        System.out.println(RGB.Shape(">") + RGB.Title(" Welcome"));
        System.out.println(RGB.Shape(">") + RGB.Title(" In This Program,"));
        System.out.println(RGB.Title("  We Calculate The Area And Perimeter Of Seven Different Shapes"));
        System.out.println(RGB.Title("  With The Explanation Of The Laws Used In The Calculation."));
        System.out.println(RGB.Title("  And Some Operations On Matrices."));
        System.out.println(RGB.Shape(">") + RGB.Title(" Made By : ") + RGB.Error("Runtime Terror."));
        System.out.print(RGB.PressEnterKey());
        scan.nextLine();
        Main();
    }

    public static void Main() {
        System.out.println(RGB.Line());
        System.out.println(RGB.Title2("Main Menu"));
        System.out.println(RGB.Line());
        System.out.println(RGB.Choose(1, "Shapes"));
        System.out.println(RGB.Choose(2, "Matrices"));
        System.out.println(RGB.Choose(0, "Exit"));
        System.out.println(RGB.Line());
        short NofTry = Handle.NUMBER_OF_TRY;
        do {
            System.out.print(RGB.ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1":
                    MainShape.chooseShape();
                    break;
                case "2":
                    MainMatrices.ChooseProcess();
                    break;
                case "0":
                    System.out.println(RGB.Exit());
                    System.exit(0);
                default:
                    if (--NofTry != 0)
                        RGB.WarningAndError(NofTry, false);
                    break;
            }
        } while (NofTry != 0);
        System.out.println(RGB.ErrorMsg(false));
        System.out.println(RGB.Exit());
        System.exit(-1); // Error : Enter spam
    }
}