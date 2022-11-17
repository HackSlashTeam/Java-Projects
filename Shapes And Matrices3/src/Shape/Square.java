package Shape;

public class Square implements Shapes {
    /* --- Attribute --- */
    private double side;

    /* --- constructors --- */
    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    /* --- Get Area Of Square --- */
    @Override
    public double area() {
        return side * side;
    }

    /* --- Print Area Law --- */
    @Override
    public String areaLaw() {
        return "Area Law Of Square: Side * Side";
    }

    /* --- get perimeter Of Square --- */
    @Override
    public double perimeter() {
        return 4 * side;
    }

    /* --- Print Perimeter Law --- */
    @Override
    public String perimeterLaw() {
        return "Perimeter Law Of Square: 4 * Side";
    }

    /* --- Info Method --- */
    @Override
    public String toString() {
        return "Side = " + side + " cm" +
                "\nArea = " + this.area() + " cm" +
                "\nPerimeter = " + this.perimeter() + " cm";
    }
}
