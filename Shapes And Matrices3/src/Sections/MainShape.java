package Sections;

import Shape.*;

import java.util.Scanner;

import static Color.RGB.Error;
import static Color.RGB.*;
import static Run.App.Main;
import static exception.Handle.NUMBER_OF_TRY;
import static exception.Handle.getLength;

public class MainShape {
    private static final Scanner scan = new Scanner(System.in);
    private static Shapes shape; // interface seven shapes
    private static String NofShape; // number of shape
    // number of option(Area, Perimeter, Area and Perimeter, Laws, Back, Exit)
    private static char get;

    public static void chooseShape() {
        System.out.println(Line());
        System.out.println(Title2("Choose The Shape"));
        System.out.println(Line());
        System.out.println(Choose(1, "Square"));
        System.out.println(Choose(2, "Triangle"));
        System.out.println(Choose(3, "Circle"));
        System.out.println(Choose(4, "Rectangle"));
        System.out.println(Choose(5, "Rhombus"));
        System.out.println(Choose(6, "Parallelogram"));
        System.out.println(Choose(7, "Trapezoidal"));
        System.out.println(Choose(8, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            NofShape = scan.nextLine().trim();  // choose shape(get number from user).
            switchShape(); // this function try to validate NofShape Not return when is valid
            if (--NofTry != 0) WarningAndError(NofTry, true);
        } while (NofTry != 0);
        System.out.println(ErrorMsg(true));
        Main();
    }

    // main switch
    public static void switchShape() {
        switch (NofShape) {
            case "1": // Square
                get = get(); // get option
                switch (get) {
                    case '1': //area
                    case '2': //perimeter
                    case '3': //area and perimeter
                        // get from user length if try's out return -1
                        double length = getLength("Enter Length : ");
                        if (length == -1) break; // if try's out
                        shape = new Square(length); // make value to interface
                        printValues(); // print (area or perimeter or both)
                        break;
                    case '4': //show laws
                        laws(new Square());
                        break;
                    default:
                        System.out.println("XXX Error 1"); // exception to unexpected Error
                        System.exit(1);
                }
                switchShape(); // return the last menu (main menu)
                break;
            case "2": // Triangle
                get = get();
                switch (get) {
                    case '1': // area
                    case '2': // perimeter
                    case '3': // area and perimeter
                        double side1 = getLength("Enter Side 1 : ");
                        if (side1 == -1) break;
                        double side2 = getLength("Enter Side 2 : ");
                        if (side2 == -1) break;
                        double side3 = getLength("Enter Side 3 : ");
                        if (side3 == -1) break;
                        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
                            System.out.println(Shape("-->") + Error(" Error : This Is Not Triangle. Please Enter Valid Numbers."));
                            break;
                        }
                        shape = new Triangle(side1, side2, side3);
                        printValues();
                        break;
                    case '4': // laws
                        laws(new Triangle());
                        break;
                    default:
                        System.out.println("XXX Error 2");
                        System.exit(2);
                }
                switchShape(); // main menu
                break;
            case "3": // Circle
                get = get();
                switch (get) {
                    case '1':
                    case '2':
                    case '3':
                        double radius = getLength("Enter Radius : ");
                        if (radius == -1) break;
                        shape = new Circle(radius);
                        printValues();
                        break;
                    case '4':
                        laws(new Circle());
                        break;
                    default:
                        System.out.println("XXX Error 3");
                        System.exit(3);
                }
                switchShape();
                break;
            case "4": // Rectangle
                get = get();
                switch (get) {
                    case '1':
                    case '2':
                    case '3':
                        double width = getLength("Enter Width : ");
                        if (width == -1) break;
                        double height = getLength("Enter Height : ");
                        if (height == -1) break;
                        shape = new Rectangle(width, height);
                        printValues();
                        break;
                    case '4':
                        laws(new Rectangle());
                        break;
                    default:
                        System.out.println("XXX Error 4");
                        System.exit(4);
                }
                switchShape();
                break;
            case "5": // Rhombus
                double length, height;
                get = get();
                switch (get) {
                    case '1':
                    case '3':
                        length = getLength("Enter Length : ");
                        if (length == -1) break;
                        height = getLength("Enter Height : ");
                        if (height == -1) break;
                        shape = new Rhombus(length, height);
                        printValues();
                        break;
                    case '2':
                        length = getLength("Enter Length : ");
                        if (length == -1) break;
                        shape = new Rhombus(length, 0);
                        printValues();
                        break;
                    case '4':
                        laws(new Rhombus());
                        break;
                    default:
                        System.out.println("XXX Error 5");
                        System.exit(5);
                }
                switchShape();
                break;
            case "6": // Parallelogram
                double length1, length2, height1;
                get = get();
                switch (get) {
                    case '1':
                        length1 = getLength("Enter Side : ");
                        if (length1 == -1) break;
                        height1 = getLength("Enter The Height Perpendicular To The Side : ");
                        if (height1 == -1) break;
                        shape = new Parallelogram(length1, 0, height1);
                        printValues();
                        break;
                    case '2':
                        length1 = getLength("Enter Side 1 : ");
                        if (length1 == -1) break;
                        length2 = getLength("Enter Side 2 : ");
                        if (length2 == -1) break;
                        shape = new Parallelogram(length1, length2, 0);
                        printValues();
                        break;
                    case '3':
                        length1 = getLength("Enter Side 1 : ");
                        if (length1 == -1) break;
                        length2 = getLength("Enter Side 2 : ");
                        if (length2 == -1) break;
                        height1 = getLength("Enter The Height Perpendicular To The Side 1 : ");
                        if (height1 == -1) break;
                        shape = new Parallelogram(length1, length2, height1);
                        printValues();
                        break;
                    case '4':
                        laws(new Parallelogram());
                        break;
                    default:
                        System.out.println("XXX Error 6");
                        System.exit(6);
                }
                switchShape();
                break;
            case "7": // Trapezoidal
                double side1, side2, side3, side4, Height;
                get = get();
                switch (get) {
                    case '1':
                        side1 = getLength("Enter Side : ");
                        if (side1 == -1) break;
                        side3 = getLength("Enter The Side That Is Parallel To The First Side : ");
                        if (side3 == -1) break;
                        Height = getLength("Enter The Distance Between Two Sides : ");
                        if (Height == -1) break;
                        shape = new Trapezoidal(side1, 0, side3, 0, Height);
                        printValues();
                        break;
                    case '2':
                        side1 = getLength("Enter Side 1 : ");
                        if (side1 == -1) break;
                        side2 = getLength("Enter Side 2 : ");
                        if (side2 == -1) break;
                        side3 = getLength("Enter Side 3 : ");
                        if (side3 == -1) break;
                        side4 = getLength("Enter Side 4 : ");
                        if (side4 == -1) break;
                        shape = new Trapezoidal(side1, side2, side3, side4, 0);
                        printValues();
                        break;
                    case '3':
                        System.out.println(Shape("-->") + Hint +
                                " Hint : The First Side Should Be Parallel To The Third Side." + Default);
                        side1 = getLength("Enter Side 1 : ");
                        if (side1 == -1) break;
                        side2 = getLength("Enter Side 2 : ");
                        if (side2 == -1) break;
                        side3 = getLength("Enter Side 3 : ");
                        if (side3 == -1) break;
                        side4 = getLength("Enter Side 4 : ");
                        if (side4 == -1) break;
                        Height = getLength("Enter The Distance Between Side(1) And Side(3) : ");
                        if (Height == -1) break;
                        shape = new Trapezoidal(side1, side2, side3, side4, Height);
                        printValues();
                        break;
                    case '4':
                        laws(new Trapezoidal());
                        break;
                    default:
                        System.out.println("XXX Error 7");
                        System.exit(7);
                }
                switchShape();
                break;
            case "8": // return to main menu
                Main();
                break;
            case "0": // Exit program
                System.out.println(Exit());
                System.exit(0);
            default:
                break; // to return choose shape
        }
    }

    // process menu
    public static char get() {
        System.out.println(Line());
        System.out.println(Title2("Operations"));
        System.out.println(Line());
        System.out.println(Choose(1, "Area"));
        System.out.println(Choose(2, "Perimeter"));
        System.out.println(Choose(3, "Area and Perimeter"));
        System.out.println(Choose(4, "Laws"));
        System.out.println(Choose(5, "Back"));
        System.out.println(Choose(6, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1":
                    return '1';
                case "2":
                    return '2';
                case "3":
                    return '3';
                case "4":
                    return '4';
                case "5":
                    chooseShape();
                    break;
                case "6":
                    Main();
                    break;
                case "0":
                    System.out.println(Exit());
                    System.exit(0);
                default:
                    if (--NofTry != 0)
                        WarningAndError(NofTry, true);
                    break;
            }
        } while (NofTry != 0);
        System.out.println(ErrorMsg(true));
        System.out.println("            Your Tries Is Out.");
        chooseShape();
        return ' '; // Just In Case The Function chooseShape Finished. This is Not Happened ☻.
    }

    // print Area or perimeter or both
    public static void printValues() {
        if (get == '1' || get == '3')
            System.out.println(Shape("--> ") + Hint("Area = " + shape.area() + " cm"));

        if (get == '2' || get == '3')
            System.out.println(Shape("--> ") + Hint("Perimeter = " + shape.perimeter() + " cm"));

        System.out.print(PressEnterKey());
        scan.nextLine();
        chooseProcess();
    }

    // print laws area and perimeter
    public static void laws(Shape.Shapes shape) {
        System.out.println(Shape("--> ") + Hint(shape.areaLaw()));
        System.out.println(Shape("--> ") + Hint(shape.perimeterLaw()));
        System.out.print(PressEnterKey());
        scan.nextLine();
    }

    // choose if you want laws or back
    public static void chooseProcess() {
        System.out.println(Line());
        System.out.println(Title2("Choose The Process"));
        System.out.println(Line());
        System.out.println(Choose(1, "Law"));
        System.out.println(Choose(2, "Choose Shape"));
        System.out.println(Choose(3, "Back"));
        System.out.println(Choose(4, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1": // law
                    if (get == '1' || get == '3')
                        System.out.println(Shape("--> ") + Hint(shape.areaLaw()));
                    if (get == '2' || get == '3')
                        System.out.println(Shape("--> ") + Hint(shape.perimeterLaw()));
                    System.out.print(PressEnterKey());
                    scan.nextLine();
                    submenu();
                    chooseProcess();
                    return;
                case "2": // main menu
                    chooseShape();
                    break;
                case "3": // back to previous menu
                    switchShape();
                    chooseShape();
                    break;
                case "4": // back to previous menu
                    Main();
                    break;
                case "0":
                    System.out.println(Exit());
                    System.exit(0);
                default:
                    if (--NofTry != 0)
                        WarningAndError(NofTry, true);
                    break;
            }
        } while (NofTry != 0);
        System.out.println(ErrorMsg(true));
        System.out.println("            Your Tries Is Out.");
    }

    // submenu
    public static void submenu() {
        System.out.println(Line());
        System.out.println(Title2("Choose The Process"));
        System.out.println(Line());
        System.out.println(Choose(1, "Choose Shape"));
        System.out.println(Choose(2, "Back"));
        System.out.println(Choose(3, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1": // main menu
                    chooseShape();
                    break;
                case "2": // back to previous menu
                    return;
                case "3": // back to Main menu
                    Main();
                    break;
                case "0": // exit
                    System.out.println(Exit());
                    System.exit(0);
                default:
                    if (--NofTry != 0) WarningAndError(NofTry, true);
                    break;
            }
        } while (NofTry != 0);
        System.out.println(ErrorMsg(true));
        System.out.println("            Your Tries Is Out.");
    }
}