package exception;

public final class Exceptions {
    @Override
    public String toString() {
        return "Exceptions To Generate Custom Exceptions";
    }

    public static class OneCharException extends Exception {
        public OneCharException(String message) {
            super(message);
        }

        @Override
        public String toString() {
            return "Error : You Enter Char(" + super.getMessage() + ").\nPlease Enter Numbers Only.";
        }
    }

    public static class EmptyException extends Exception {
        @Override
        public String toString() {
            return "Error : Your Input Is Empty.";
        }
    }

    public static class NegativeNumberException extends Exception {
        @Override
        public String toString() {
            return "Error : Please Enter Positive Number.";
        }
    }

    public static class StringException extends Exception {
        @Override
        public String toString() {
            return "Error : You Enter String Or Spacial Character.\nPlease Enter Number.";
        }
    }

    public static class MathematicalOperationException extends Exception {
        @Override
        public String toString() {
            return "Error : Not Support Math Operation.";
        }
    }

    public static class SpaceException extends Exception {
        @Override
        public String toString() {
            return "Error : Your Input Include Space.";
        }
    }

    public static class DotException extends Exception {
        @Override
        public String toString() {
            return "Error : Please Enter Double Number With One Dot(.).";
        }
    }

    public static class DoubleException extends Exception {
        @Override
        public String toString() {
            return "Error : Please Enter Integer Number.";
        }
    }

    public static class OutOfRangeException extends Exception {
        public OutOfRangeException(String message) {
            super(message);
        }

        @Override
        public String toString() {
            return "Error : Please Enter Number From 1 to " + super.getMessage();
        }
    }

    public static class QuitException extends Exception {
        @Override
        public String toString() {
            return "Input Canceled.";
        }
    }
}