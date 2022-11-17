package Shape;

public class Circle implements Shapes {
    /* --- Attribute --- */
    private double radius;

    /* --- Constructor --- */
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /* --- Get Area Of Circle --- */
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    /* --- Print Area Law --- */
    @Override
    public String areaLaw() {
        return "Area Law Of Circle: PI * Radius * Radius";
    }

    /* --- get perimeter Of Circle --- */
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    /* --- Print Perimeter Law --- */
    @Override
    public String perimeterLaw() {
        return "Perimeter Law Of Circle: 2 * PI * Radius";
    }

    /* --- Info Method --- */
    @Override
    public String toString() {
        return "Radius = " + radius + " cm" +
                "\nArea = " + this.area() + " cm" +
                "\nPerimeter = " + this.perimeter() + " cm";
    }
}
