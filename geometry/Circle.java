package geometry;

public class Circle {
    private double x;
    private double y;
    private double radius;

    public Circle() {
        this(0, 0, 1);
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double px, double py) {
        double dx = px - x;
        double dy = py - y;
        return dx * dx + dy * dy <= radius * radius;
    }

    public boolean contains(Circle c) {
        double d = Math.sqrt((c.x - x) * (c.x - x) + (c.y - y) * (c.y - y));
        return d + c.radius <= this.radius;
    }

    public boolean overlaps(Circle c) {
        double d = Math.sqrt((c.x - x) * (c.x - x) + (c.y - y) * (c.y - y));
        return d <= this.radius + c.radius && d >= Math.abs(this.radius - c.radius);
    }

    @Override
    public String toString() {
        return "Circle(center=(" + x + "," + y + "), r=" + radius + ")";
    }
}