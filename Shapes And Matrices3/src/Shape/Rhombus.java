package Shape;

public class Rhombus implements Shapes {
    /* --- Attribute --- */
    private double length;
    private double height;

    /* --- Constructor --- */
    public Rhombus() {
    }

    public Rhombus(double length, double height) {
        this.length = length;
        this.height = height;
    }

    /* --- Get Area Of Rhombus --- */
    @Override
    public double area() {
        return length * height;
    }

    /* --- Print Area Law --- */
    @Override
    public String areaLaw() {
        return "Area Law Of Rhombus: Length * Height";
    }

    /* --- get perimeter Of Rhombus --- */
    @Override
    public double perimeter() {
        return (4 * length);
    }

    /* --- Print Perimeter Law --- */
    @Override
    public String perimeterLaw() {
        return "Perimeter Law Of Rhombus: 4 * Length";
    }

    /* --- Info Method --- */
    @Override
    public String toString() {
        return "Length = " + length + " cm" +
                "\nHeight = " + height + " cm" +
                "\nArea = " + this.area() + " cm" +
                "\nPerimeter = " + this.perimeter() + " cm";
    }

}
