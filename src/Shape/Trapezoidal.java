package Shape;

public class Trapezoidal implements Shapes {
    /* --- Attribute --- */
    private double side1;
    private double side2;
    private double side3;
    private double side4;
    private double height;

    /* --- Constructor --- */
    public Trapezoidal() {
    }

    public Trapezoidal(double side1, double side2, double side3, double side4, double height) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        this.height = height;
    }

    /* --- Get Area Of Trapezoidal --- */
    @Override
    public double area() {
        return 0.5 * (side1 + side3) * height;
    }

    /* --- Print Area Law --- */
    @Override
    public String areaLaw() {
        return "Area Law Of Trapezoidal: 0.5 * (Side1 + Side3(Is Parallel To The First Side)) * Height";
    }

    /* --- Get Perimeter Of Trapezoidal --- */
    @Override
    public double perimeter() {
        return side1 + side2 + side3 + side4;
    }

    /* --- Print Area Law --- */
    @Override
    public String perimeterLaw() {
        return "Perimeter Law Of Trapezoidal : Side1 + Side2 + Side3 + Side4";
    }

    /* --- Info Method --- */
    public String toString() {
        return "Side1 = " + side1 + " cm" +
                "\nSide2 = " + side2 + " cm" +
                "\nSide3 = " + side3 + " cm" +
                "\nSide4 = " + side4 + " cm" +
                "\nHeight = " + height + " cm" +
                "\nArea = " + this.area() + " cm" +
                "\nPerimeter = " + this.perimeter() + " cm";
    }
}