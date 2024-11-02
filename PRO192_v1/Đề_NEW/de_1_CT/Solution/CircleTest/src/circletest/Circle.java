/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circletest;

/**
 *
 * @author tranphantrungkien
 */
public class Circle extends Point {

    private double radius;

    // Default constructor
    public Circle() {
        super(); // Calls the default constructor of Point (sets x=0, y=0)
        this.radius = 1; // Sets default radius to 1
    }

    // Constructor with parameters
    public Circle(int x, int y, double radius) {
        super(x, y); // Calls the constructor of Point with given coordinates
        this.radius = radius;
    }

    // Getter and setter for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate and return the diameter
    public double getDiameter() {
        return 2 * radius;
    }

    // Method to calculate and return the circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to calculate and return the area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // toString method override
    @Override
    public String toString() {

        return "Circle{Center {x=" + getX() + ", y=" + getY() + "}, "
                + "radius=" + String.format("%.2f", radius) + ","
                + "diameter=" + String.format("%.2f", getDiameter()) + ","
                + "circumference=" + String.format("%.2f", getCircumference()) + ", "
                + "area=" + String.format("%.2f", getArea()) + "}";
    }
}
