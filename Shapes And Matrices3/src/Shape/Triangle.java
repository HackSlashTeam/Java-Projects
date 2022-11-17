package Shape;

public class Triangle implements Shapes {
    /* --- Attribute --- */
    private double Side1;
    private double Side2;
    private double Side3;

    /* --- Constructor --- */
    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.Side1 = side1;
        this.Side2 = side2;
        this.Side3 = side3;
    }

    /* --- Get Area Of Triangle --- */
    @Override
    public double area() {
        double p = 0.5 * (Side1 + Side2 + Side3);
        return p * (p - Side1) * (p - Side2) * (p - Side3);
    }

    /* --- Print Area Law --- */
    @Override
    public String areaLaw() {
        return "Area Law Of Triangle : P * (P - Side1) * (P - Side2) * (P - Side3)\n" +
                "    where P = 0.5 * Perimeter";
    }

    /* --- get perimeter Of Triangle --- */
    @Override
    public double perimeter() {
        return Side1 + Side2 + Side3;
    }

    /* --- Print Perimeter Law --- */
    @Override
    public String perimeterLaw() {
        return "Perimeter Law Of Triangle: Side1 + Side2 + Side3";
    }

    /* --- Info Method --- */
    @Override
    public String toString() {
        return "Side1 = " + Side1 + " cm" +
                "\nSide2 = " + Side2 + " cm" +
                "\nSide3 = " + Side3 + " cm" +
                "\nArea = " + this.area() + " cm" +
                "\nPerimeter = " + this.perimeter() + " cm";
    }

}
