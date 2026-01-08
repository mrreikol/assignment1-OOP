package geometry;

public class Rectangle {
    private double x, y;        // center
    private double width, height;

    public Rectangle() {
        this(0, 0, 1, 1);
    }

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }

    public double getArea() { return width * height; }
    public double getPerimeter() { return 2 * (width + height); }

    public boolean contains(double px, double py) {
        double halfW = width / 2.0;
        double halfH = height / 2.0;
        return px >= x - halfW && px <= x + halfW &&
                py >= y - halfH && py <= y + halfH;
    }

    private Point[] corners() {
        double halfW = width / 2.0;
        double halfH = height / 2.0;
        return new Point[] {
                new Point(x - halfW, y - halfH),
                new Point(x - halfW, y + halfH),
                new Point(x + halfW, y - halfH),
                new Point(x + halfW, y + halfH)
        };
    }

    public boolean contains(Rectangle r) {
        Point[] c = r.corners();
        for (Point p : c) {
            if (!this.contains(p.getX(), p.getY())) return false;
        }
        return true;
    }

    public boolean overlaps(Rectangle r) {
        double halfW1 = this.width / 2.0;
        double halfH1 = this.height / 2.0;
        double halfW2 = r.width / 2.0;
        double halfH2 = r.height / 2.0;

        boolean separated =
                (this.x + halfW1 < r.x - halfW2) ||
                        (this.x - halfW1 > r.x + halfW2) ||
                        (this.y + halfH1 < r.y - halfH2) ||
                        (this.y - halfH1 > r.y + halfH2);

        return !separated;
    }

    @Override
    public String toString() {
        return "Rectangle(center=(" + x + "," + y + "), w=" + width + ", h=" + height + ")";
    }
}