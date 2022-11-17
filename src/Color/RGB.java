package Color;

public class RGB {
    public static final String Default = "\u001B[1;0m"; // Reset color
    public static final String Digit = "\u001B[36m";
    public static final String Hint = "\u001B[93m"; // Reset color

    public static String Title(String s) {
        return "\u001B[35m" + s + Default;
    }

    public static String Title2(String s) {
        double i = (31.0 - s.length()) / 2.0;
        return String.format(("\u001B[34m|\u001B[35m%" + ((int) i + s.length()) + "s%"
                + (int) Math.ceil(i) + "s\u001B[34m|" + Default), s, "");
    }

    public static String Error(String s) {
        return "\u001B[31m" + s + Default;
    }

    public static String Shape(String s) {
        return "\u001B[34m" + s + Default;
    }

    public static String Choose(int n, String s) {
        return String.format("\u001B[34m|   \u001B[94m%-2d\u001B[34m- \u001B[32m%-24s\u001B[34m|"
                , n, s) + Default;
    }

    public static String Hint(String s) {
        return "\u001B[1;93m" + s + Default;
    }

    public static String PressEnterKey() {
        return "\u001B[34m# \u001B[36mPress Enter Key To Continue...\u001B[1;0;0m";
    }

    public static String ChooseNumber() {
        return "\u001B[34m# \u001B[36mChoose Number \u001B[34m: \u001B[1;0m";
    }

    public static String printHandle(String s) {
        return "\u001B[36m" + s + Default;
    }

    public static String Line() {
        return "\u001B[34m|-------------------------------|\u001B[1;0;0m";
    }

    public static String ErrorMsg(boolean b) {
        return "\u001B[34m--> \u001B[31mError : The Program " +
                (b ? "Back To Previous Page Automatically." : "Out Automatically Your Try's Is Out.");

    }

    public static String OutOfRange() {
        return "\u001B[34m-->\u001B[31m Error : Out Of Range.\u001B[1;0;0m";
    }

    public static void WarningAndError(int NofTry, boolean b) {
        System.out.println(OutOfRange());
        System.out.print(Shape("-->") + "\u001B[1;93m Warning : The Program " + (b ? "Back Previous Page" : "Out"));
        System.out.println(" Automatically After " + NofTry + (NofTry == 1 ? " Try." : " Tries.") + RGB.Default);
    }

    public static String Exit() {
        return "\u001B[34m> \u001B[35mThanks To Use This Program\u001B[34m.";
    }
}
