package Shape;

public class Parallelogram implements Shapes {
    /* --- Attribute --- */
    private double length1;
    private double length2;
    private double height1;

    /* --- Constructor --- */
    public Parallelogram() {
    }

    public Parallelogram(double length1, double length2, double height1) {
        this.length1 = length1;
        this.length2 = length2;
        this.height1 = height1;
    }

    /* --- Get Area Of parallelogram --- */
    @Override
    public double area() {
        return length1 * height1;
    }

    /* --- Print Area Law --- */
    @Override
    public String areaLaw() {
        return "Area Law Of Parallelogram: Length * perpendicular Height";
    }

    /* --- get perimeter Of parallelogram --- */
    @Override
    public double perimeter() {
        return 2 * (length1 + length2);
    }

    /* --- Print Perimeter Law --- */
    @Override
    public String perimeterLaw() {
        return "Perimeter Law Of Parallelogram: 2 * (Length1 + Length2)";
    }

    /* --- Info Method --- */
    @Override
    public String toString() {
        return "Height1 = " + height1 + " cm" +
                "\nLength1 = " + length1 + " cm" +
                "\nLength2 = " + length2 + " cm" +
                "\nArea = " + this.area() + " cm" +
                "\nPerimeter = " + this.perimeter() + " cm";
    }
}
