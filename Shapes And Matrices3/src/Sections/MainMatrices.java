package Sections;

import Matrix.Matrices;
import Matrix.MatricesWithPair;
import exception.Exceptions.QuitException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Color.RGB.Error;
import static Color.RGB.*;
import static Run.App.Main;
import static exception.Handle.*;

public class MainMatrices {
    final static Scanner scan = new Scanner(System.in);
    static Matrices matrix = new Matrices("Matrices.txt");

    public static void ChooseProcess() {
        System.out.println(Line());
        System.out.println(Title2("Matrices"));
        System.out.println(Line());
        System.out.println(Choose(1, "Operations On Matrices"));
        System.out.println(Choose(2, "Add New Matrix"));
        System.out.println(Choose(3, "Edit Matrix"));
        System.out.println(Choose(4, "Delete Matrix"));
        System.out.println(Choose(5, "Find A Matrix"));
        System.out.println(Choose(6, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1":
                    Operations();
                    ChooseProcess();
                    break;
                case "2":
                    AddMatrix();
                    ChooseProcess();
                    break;
                case "3":
                    Edit();
                    ChooseProcess();
                    break;
                case "4":
                    Delete();
                    ChooseProcess();
                case "5":
                    Find();
                    ChooseProcess();
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
        Main();
    }

    public static void Operation(String title, String Operation) {
        Object ANumber = MatrixOrNumber(title, Operation);
        if (ANumber == null || (ANumber instanceof Integer && (Integer) ANumber == -1)) Operations();
        Integer AIndex = GetList();
        if (AIndex == null || AIndex == -1) Operations();
        if (ANumber instanceof Double) {
            switch (Operation) {
                case "Add":
                    matrix.add(AIndex, (Double) ANumber);
                    break;
                case "Sub":
                    matrix.sub(AIndex, (Double) ANumber);
                    break;
                case "Multi":
                    matrix.multi(AIndex, (Double) ANumber);
                    break;
                default:
                    System.out.println("XXX Error OP 1");
            }
        } else {
            switch (Operation) {
                case "Add":
                    if (matrix.AddCheck(AIndex, (Integer) ANumber)) return;
                    matrix.add(AIndex, (Integer) ANumber);
                    break;
                case "Sub":
                    if (matrix.AddCheck(AIndex, (Integer) ANumber)) return;
                    matrix.sub(AIndex, (Integer) ANumber);
                    break;
                case "Multi":
                    if (matrix.CheekMulti(AIndex, (Integer) ANumber)) return;
                    matrix.multi(AIndex, (Integer) ANumber);
                    break;
                default:
                    System.out.println("XXX Error OP 1");
            }
        }
        System.out.println(Shape("> ") + Title("Result Of " + title + " :"));
        matrix.display(matrix.size() - 1);
        System.out.println(Shape("> ") + Title("Number Of Matrix (" + matrix.size() + ")"));
        System.out.print(PressEnterKey());
        scan.nextLine();
    }

    public static void Operations() {
        System.out.println(Line());
        System.out.println(Title2("Operations"));
        System.out.println(Line());
        System.out.println(Choose(1, "Addition"));
        System.out.println(Choose(2, "Subtraction"));
        System.out.println(Choose(3, "Multiplication"));
        System.out.println(Choose(4, "Determination"));
        System.out.println(Choose(5, "Transpose"));
        System.out.println(Choose(6, "Solve Equation"));
        System.out.println(Choose(7, "Inverse"));
        System.out.println(Choose(8, "Back"));
        System.out.println(Choose(9, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1":
                    Operation("Addition", "Add");
                    Operations();
                    break;
                case "2":
                    Operation("Subtraction", "Sub");
                    Operations();
                    break;
                case "3":
                    Operation("Multiplication", "Multi");
                    Operations();
                    break;
                case "4":
                    Integer DIndex = GetList();
                    if (DIndex == null || DIndex == -1 || matrix.checkSquare(DIndex)) Operations();
                    System.out.println(Shape("> ") + Title("Determine to Matrix = " + matrix.det(matrix.get(DIndex))));
                    System.out.print(PressEnterKey());
                    scan.nextLine();
                    Operations();
                    break;
                case "5":
                    Integer TIndex = GetList();
                    if (TIndex == null || TIndex == -1) Operations();
                    List<List<Double>> l = matrix.transpose(TIndex);
                    matrix.display(l);
                    System.out.println(Shape("--> ") + Error("Do You Want Save Matrix (Y)/(N)?\n") + Shape("> "));
                    if (!scan.nextLine().trim().equalsIgnoreCase("N")) {
                        matrix.add(l);
                        matrix.write();
                        System.out.println(Shape("> ") + Title("Number Of Matrix (" + matrix.size() + ")"));
                        System.out.println(Shape("> ") + Title("Added Successfully."));
                    } else System.out.println(Shape("> ") + Error("Add Canceled."));
                    Operations();
                    break;
                case "6":
                    System.out.println(Shape("> ") + Title("In This Case We Consider The Last Column Is Results Of Equations.\n  And Author Columns Are Anonymous Transactions."));
                    System.out.println(Shape("> ") + Title("Example                  ") + Shape("| ") + Error("x") + Shape(",") + Hint(" y") + Shape(",") + Title(" r") + Shape(" |"));
                    System.out.println(Shape("• ") + Error("5x") + Shape(" + ") + Hint("4y") + Shape(" = ") + Title("3     ") + Shape("-->      | ") + Error("5") + Shape(",") + Hint(" 4") + Shape(",") + Title(" 3") + Shape(" |"));
                    System.out.println(Shape("• ") + Error("2x") + Shape(" + ") + Hint("1y") + Shape(" = ") + Title("4              ") + Shape("| ") + Error("2") + Shape(",") + Hint(" 1") + Shape(",") + Title(" 4") + Shape(" |"));
                    System.out.println(Shape("> ") + Title("Make Sure That The Number of Equations Equals The Number Of Unknowns."));
                    Integer SIndex = GetList();
                    if (SIndex == null || SIndex == -1) Operations();
                    List<List<Double>> list = new ArrayList<>(matrix.get(SIndex));
                    if (list.size() != list.get(0).size() - 1) {
                        System.out.println(Shape("-->") + Error("The Number of Equations Not Equals The Number Of Unknowns."));
                        System.out.println(PressEnterKey());
                        scan.nextLine();
                        Operations();
                    }
                    Matrices.Jordan(list);
                    switch (matrix.checkSolution(list)) {
                        case 0: // 1 sol
                            int c = 0;
                            System.out.println(Shape("> ") + Title("Solutions :"));
                            for (List<Double> lt : list) {
                                System.out.println(Shape("• ") + Title("X" + c++) + " = " + Title(lt.get(lt.size() - 1) + ""));
                            }
                            System.out.print(PressEnterKey());
                            scan.nextLine();
                            break;
                        case 1: // inf sol
                            System.out.println(Shape("• ") + Title("There Are Infinite Solutions."));
                            System.out.println(Shape("> ") + Title("Final Matrix : "));
                            matrix.display(list);
                            System.out.print(PressEnterKey());
                            scan.nextLine();
                            break;
                        case -1: // no sol
                            System.out.println(Shape("• ") + Title("There is No Solution."));
                            System.out.println(Shape("> ") + Title("Final Matrix : "));
                            matrix.display(list);
                            System.out.print(PressEnterKey());
                            scan.nextLine();
                            break;
                        default:
                            System.out.println("XXX Error Op 2");
                    }
                    Operations();
                    break;
                case "7":
                    System.out.println(Shape("> ") + Title("Make Sure That The Matrix Is Square Matrix."));
                    Integer IIndex = GetList();
                    if (IIndex == null || IIndex == -1) Operations();
                    if (matrix.checkSquare(IIndex)) {
                        System.out.print(PressEnterKey());
                        scan.nextLine();
                        Operations();
                        break;
                    }
                    if (matrix.det(matrix.get(IIndex)) == 0) {
                        System.out.println(Shape("• ") + Title("This Matrix Has No Inverse."));
                        System.out.print(PressEnterKey());
                        scan.nextLine();
                        Operations();
                        break;
                    }
                    System.out.println(Shape("> ") + Title("Inverse Matrix : "));
                    matrix.inverse(IIndex);
                    matrix.display(matrix.size() - 1);
                    System.out.println(Shape("> ") + Title("Number Of Matrix (" + matrix.size() + ")"));
                    System.out.print(PressEnterKey());
                    scan.nextLine();
                    Operations();
                    break;
                case "8":
                    ChooseProcess();
                    return;
                case "9":
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
        ChooseProcess();
    }

    public static Object MatrixOrNumber(String title, String operation) {
        System.out.println(Line());
        System.out.println(Title2(title));
        System.out.println(Line());
        System.out.println(Choose(1, operation + " Number To Matrix"));
        System.out.println(Choose(2, operation + " Matrix To Matrix"));
        System.out.println(Choose(3, "Back"));
        System.out.println(Choose(4, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1":
                    int NofTries = NUMBER_OF_TRY;
                    do {
                        System.out.print(Shape("# ") + printHandle("Enter Number : "));
                        try {
                            String input = scan.nextLine();
                            Exception e = validateString(input);
                            if (e != null) throw e;
                            return Double.parseDouble(input);
                        } catch (QuitException e) {
                            System.out.println(Shape("--> ") + Error(e.toString()));
                            return null;
                        } catch (Exception e) {
                            System.out.println(Shape("--> ") + Error(e.toString()));
                            if (--NofTries != 0) {
                                System.out.println(Shape("--> ") + Hint("Warning : " +
                                        NofTries + (NofTries == 1 ? " Try" : " Tries") + " Left"));
                            }
                        }
                    } while (NofTries != 0);
                    return null;
                case "2":
                    return GetList();
                case "3":
                    return null;
                case "4":
                    Main();
                    return null;
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
        return null;
    }

    public static Integer GetList() {
        System.out.println(Shape("# ") + printHandle("Choose The Input Type For The Matrix"));
        System.out.println(Line());
        System.out.println(Title2("Get Matrix"));
        System.out.println(Line());
        System.out.println(Choose(1, "Add New Matrix"));
        System.out.println(Choose(2, "Import Matrix"));
        System.out.println(Choose(3, "Back(Cancel)"));
        System.out.println(Choose(4, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1":
                    return AddMatrix() ? matrix.size() - 1 : GetList();
                case "2":
                    if (matrix.size() == 0) {
                        System.out.println(Shape("> ") + Error("No Matrix Available."));
                        return GetList();
                    }
                    System.out.println(Shape("--> ") + Hint("Hint : To Display Matrices(d) Or Enter Key To Continue"));
                    System.out.print(Shape("> "));
                    if (scan.nextLine().trim().equalsIgnoreCase("D")) DisplayAll();
                    int index = Range("Choose Number Of Matrix : ", matrix.size());
                    if (index-- == -1) return GetList();
                    matrix.display(index);
                    System.out.print(PressEnterKey());
                    scan.nextLine();
                    return index;
                case "3":
                    return -1;
                case "4":
                    Main();
                    return -1;
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
        return -1;
    }

    public static boolean AddMatrix() {
        int n = Range("Enter Number of Rows : ", MAX);
        if (n == -1) return false;
        int m = Range("Enter Number of Columns : ", MAX);
        if (m == -1) return false;
        System.out.println(Shape("--> ") + Hint("Hint : If You Mistake("
                + NUMBER_OF_TRY + ") Times Then Value Will Be(0)."));
        System.out.println(Shape("-->") + Hint(" Hint : Type (q) To Quit From Input."));
        List<List<Double>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Double> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int NofTry = NUMBER_OF_TRY;
                do {
                    System.out.print(Shape("# ") +
                            printHandle("Enter The Element In Row(" + (i + 1) + "), Column(" + (j + 1) + ") : "));
                    try {
                        String input = scan.nextLine();
                        Exception e = validateString(input);
                        if (e != null) throw e;
                        list.add(Double.parseDouble(input));
                        break;
                    } catch (QuitException e) {
                        System.out.println(Shape("--> ") + Error(e.toString()));
                        ChooseProcess(); // to make user out to input
                        return false;
                    } catch (Exception e) {
                        System.out.println(Shape("--> ") + Error(e.toString()));
                        if (--NofTry != 0) {
                            System.out.println(Shape("--> ") + Hint("Warning : " +
                                    NofTry + (NofTry == 1 ? " Try" : " Tries") + " Left"));
                        } else {
                            list.add(0.0);
                            System.out.println(Shape("> ") + Error("The Program Add Zero Automatically."));
                        }
                    }
                } while (NofTry != 0);
            }
            lists.add(list);
        }
        matrix.add(lists);
        System.out.println(Shape("> ") + Title("Added Successfully."));
        matrix.display(matrix.size() - 1);
        System.out.println(Shape("> ") + Title("Number Of Matrix (" + matrix.size() + ")"));
        System.out.print(PressEnterKey());
        scan.nextLine();
        return true;
    }

    public static void Edit() {
        if (matrix.size() == 0) {
            System.out.println(Shape("> ") + Error("No Matrix Available."));
            return;
        }
        System.out.println(Shape("--> ") + Hint("Hint : To Display Matrices(d) Or Enter Key To Continue"));
        System.out.print(Shape("> "));
        if (scan.nextLine().trim().equalsIgnoreCase("D")) DisplayAll();
        int index = Range("Choose Number Of Matrix : ", matrix.size());
        if (index-- == -1) return;
        matrix.display(index);
        System.out.print(PressEnterKey());
        scan.nextLine();
        int row = Range("Choose Number Of Row : ", matrix.get(index).size());
        if (row-- == -1) return;
        int column = Range("Choose Number Of Column : ", matrix.get(index, row).size());
        if (column-- == -1) return;
        int NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(Shape("# ") + printHandle("Enter The Number : "));
            try {
                String input = scan.nextLine();
                Exception e = validateString(input);
                if (e != null) throw e;
                double number = Double.parseDouble(input);
                matrix.Edit(index, row, column, number);
                matrix.display(index);
                System.out.println(Shape("> ") + Title("Edit Successfully."));
                System.out.print(PressEnterKey());
                scan.nextLine();
                return;
            } catch (QuitException e) {
                break;
            } catch (Exception e) {
                System.out.println(Shape("--> ") + Error(e.toString()));
                if (--NofTry != 0) {
                    System.out.println(Shape("--> ") + Hint("Warning : " +
                            NofTry + (NofTry == 1 ? " Try" : " Tries") + " Left"));
                }
            }
        } while (NofTry != 0);
        System.out.println(Shape("> ") + Title("Edit Canceled."));
    }

    public static void Delete() {
        if (matrix.size() == 0) {
            System.out.println(Shape("> ") + Error("No Matrix Available."));
            return;
        }
        System.out.println(Line());
        System.out.println(Title2("Delete"));
        System.out.println(Line());
        System.out.println(Choose(1, "Delete One Matrix"));
        System.out.println(Choose(2, "Delete All Matrices"));
        System.out.println(Choose(3, "Back"));
        System.out.println(Choose(4, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1":
                    System.out.print(Shape("--> "));
                    System.out.println(Hint("Hint : To Display Matrices(d) Or Enter Key To Continue"));
                    System.out.print(Shape("> "));
                    if (scan.nextLine().trim().equalsIgnoreCase("D")) DisplayAll();
                    int index = Range("Choose Number Of Matrix : ", matrix.size());
                    if (index-- == -1) return;
                    matrix.display(index);
                    System.out.println(Shape("--> ") + Error("Do You Want Delete This Matrix ?"));
                    System.out.println(Shape("--> ") + Hint("Hint : (y) To Delete Or Enter Key To Quit."));
                    System.out.print(Shape("> "));
                    if (scan.nextLine().trim().equalsIgnoreCase("y")) {
                        matrix.Delete(index);
                        System.out.println(Shape("> ") + Title("Deleted Successfully."));
                    } else {
                        System.out.println(Shape("> ") + Title("Delete Canceled."));
                    }
                    Delete();
                    return;
                case "2":
                    System.out.println(Shape("--> ") + Error("Do You Want Delete All Matrices ?"));
                    System.out.println(Shape("--> ") + Hint("Hint : (y) To Delete Or Enter Key To Quit."));
                    System.out.print(Shape("> "));
                    if (scan.nextLine().trim().equalsIgnoreCase("y")) {
                        matrix.clear();
                        System.out.println(Shape("> ") + Title("Deleted Successfully."));
                    } else {
                        System.out.println(Shape("> ") + Title("Delete Canceled."));
                    }
                    return;
                case "3":
                    return;
                case "4":
                    Main();
                    return;
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
    }

    public static void Find() {
        if (matrix.size() == 0) {
            System.out.println(Shape("> ") + Error("No Matrix Available."));
            return;
        }
        System.out.println(Line());
        System.out.println(Title2("Search"));
        System.out.println(Line());
        System.out.println(Choose(1, "Number Of Matrix"));
        System.out.println(Choose(2, "Number Of Rows"));
        System.out.println(Choose(3, "Number Of Columns"));
        System.out.println(Choose(4, "Number Of Rows and Col"));
        System.out.println(Choose(5, "Display Square Matrices"));
        System.out.println(Choose(6, "Display Matrices"));
        System.out.println(Choose(7, "Back"));
        System.out.println(Choose(8, "Main Menu"));
        System.out.println(Choose(0, "Exit"));
        System.out.println(Line());
        short NofTry = NUMBER_OF_TRY;
        do {
            System.out.print(ChooseNumber());
            String op = scan.nextLine().trim();
            switch (op) {
                case "1":
                    int index = Range("Enter Number Of Matrix : ", matrix.size());
                    if (index-- != -1) {
                        matrix.display(index);
                        System.out.print(PressEnterKey());
                        scan.nextLine();
                    }
                    Find();
                    return;
                case "2":
                    int row = Range("Enter The Number Of Rows Of The Matrix : ", MAX);
                    if (row != -1) Display(matrix.FindByRow(row));
                    Find();
                    return;
                case "3":
                    int column = Range("Enter The Number Of Columns Of The Matrix : ", MAX);
                    if (column != -1) Display(matrix.FindByColumn(column));
                    Find();
                    return;
                case "4":
                    int Row = Range("Enter The Number Of Rows Of The Matrix : ", MAX);
                    if (Row != -1) {
                        int Column = Range("Enter The Number Of Columns Of The Matrix : ", MAX);
                        if (Column != -1) Display(matrix.FindBySize(Row, Column));
                    }
                    Find();
                    return;
                case "5":
                    Display(matrix.Square());
                    Find();
                    return;
                case "6":
                    DisplayAll();
                    Find();
                    return;
                case "7":
                    ChooseProcess();
                    return;
                case "8":
                    Main();
                    return;
                case "0":
                    System.out.println(Exit());
                    System.exit(0);
                default:
                    if (--NofTry != 0) WarningAndError(NofTry, true);
                    break;
            }
        } while (NofTry != 0);
        System.out.println(ErrorMsg(true));
    }

    public static void DisplayAll() {
        int n = matrix.size();
        if (n == 0) {
            System.out.println(Shape("> ") + Error("No Matrix Available."));
            return;
        }
        int m = 0;
        boolean All = false;
        do {
            for (int i = m; m < i + 5 && m < n; m++) {
                System.out.println(Shape("> ") + Title("Matrix (" + (m + 1) + ")"));
                matrix.display(m);
                System.out.println();
            }
            if (n > m && !All) {
                System.out.println(Shape("-- ") + Title("More (" + (n - m) + ")") + Shape(" --"));
                System.out.println(Shape("--> ") + Hint("Hint : (A) Display All, (Q) To Quit."));
                System.out.println(PressEnterKey());
                System.out.print(Shape("> "));
                String option = scan.nextLine().trim().toLowerCase();
                switch (option) {
                    case "a":
                    case "all":
                    case "o":
                    case "ok":
                    case "y":
                    case "yes":
                        All = true;
                        break;
                    case "quit":
                    case "no":
                    case "n":
                    case "q":
                        System.out.println(Shape("> ") + Title("Quit Successfully."));
                        return;
                    default:
                        break;
                }
            }
        } while (m < n);
        System.out.print(PressEnterKey());
        scan.nextLine();
    }

    public static void Display(MatricesWithPair list) {
        int n = list.size();
        if (n == 0) {
            System.out.println(Shape("> ") + Error("No Matrix Available."));
            return;
        }
        int m = 0;
        boolean All = false;
        do {
            for (int i = m; m < i + 5 && m < n; m++) {
                System.out.println(Shape("> ") + Title("Matrix (" + (list.get(m).getKey() + 1) + ")"));
                list.display(m);
                System.out.println();
            }
            if (n > m && !All) {
                System.out.println(Shape("-- ") + Title("More (" + (n - m) + ")") + Shape(" --"));
                System.out.println(Shape("--> ") + Hint("Hint : (A) Display All, (Q) To Quit."));
                System.out.println(PressEnterKey());
                System.out.print(Shape("> "));
                String option = scan.nextLine().trim().toLowerCase();
                switch (option) {
                    case "a":
                    case "all":
                        All = true;
                        break;
                    case "quit":
                    case "q":
                        System.out.print(Shape("> ") + Title("Quit Successfully."));
                        return;
                    default:
                        break;
                }
            }
        } while (m < n);
        System.out.print(PressEnterKey());
        scan.nextLine();
    }
}
