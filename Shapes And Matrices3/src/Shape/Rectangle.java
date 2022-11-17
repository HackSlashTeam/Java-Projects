package Shape;

public class Rectangle implements Shapes {
    /* --- Attribute --- */
    private double width;
    private double height;

    /* --- Constructor --- */
    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /* --- Get Area Of Rectangle --- */
    @Override
    public double area() {
        return width * height;
    }

    /* --- Print Area Law --- */
    @Override
    public String areaLaw() {
        return "Area The Law Of Rectangle : Width * Height";
    }

    /* --- get perimeter Of Rectangle --- */
    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    /* --- Print Perimeter Law --- */
    @Override
    public String perimeterLaw() {
        return "Perimeter Law Of Rectangle: 2 * (Width + Height)";
    }

    /* --- Info Method --- */
    @Override
    public String toString() {
        return "Width = " + width + " cm" +
                "\nHeight = " + height + " cm" +
                "\nArea = " + this.area() + " cm" +
                "\nPerimeter = " + this.perimeter() + " cm";
    }
}