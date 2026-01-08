package geometry;

public class Triangle {

    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle() {
        p1 = new Point(0, 0);
        p2 = new Point(1, 1);
        p3 = new Point(2, 5);
    }

    public Triangle(Point a, Point b, Point c) {
        p1 = copyPoint(a);
        p2 = copyPoint(b);
        p3 = copyPoint(c);
    }

    public Point getP1() { return copyPoint(p1); }
    public Point getP2() { return copyPoint(p2); }
    public Point getP3() { return copyPoint(p3); }

    public void setP1(Point a) { p1 = copyPoint(a); }
    public void setP2(Point b) { p2 = copyPoint(b); }
    public void setP3(Point c) { p3 = copyPoint(c); }

    private static Point copyPoint(Point p) {
        return new Point(p.getX(), p.getY());
    }

    public double getArea() {
        double doubleArea = cross(p1, p2, p3);
        return Math.abs(doubleArea) / 2.0;
    }

    public double getPerimeter() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        return a + b + c;
    }

    public boolean contains(Point p) {
        double s1 = cross(p1, p2, p);
        double s2 = cross(p2, p3, p);
        double s3 = cross(p3, p1, p);

        boolean hasNegative = (s1 < 0) || (s2 < 0) || (s3 < 0);
        boolean hasPositive = (s1 > 0) || (s2 > 0) || (s3 > 0);

        return !(hasNegative && hasPositive);
    }

    public boolean contains(Triangle t) {
        return this.contains(t.p1) && this.contains(t.p2) && this.contains(t.p3);
    }

    public boolean overlaps(Triangle t) {

        if (this.contains(t.p1) || this.contains(t.p2) || this.contains(t.p3)) return true;

        if (t.contains(this.p1) || t.contains(this.p2) || t.contains(this.p3)) return true;

        Point[] A = { this.p1, this.p2, this.p3 };
        Point[] B = { t.p1, t.p2, t.p3 };

        for (int i = 0; i < 3; i++) {
            Point a1 = A[i];
            Point a2 = A[(i + 1) % 3];

            for (int j = 0; j < 3; j++) {
                Point b1 = B[j];
                Point b2 = B[(j + 1) % 3];

                if (segmentsIntersect(a1, a2, b1, b2)) return true;
            }
        }

        return false;
    }

    private static double cross(Point a, Point b, Point c) {
        double abx = b.getX() - a.getX();
        double aby = b.getY() - a.getY();
        double acx = c.getX() - a.getX();
        double acy = c.getY() - a.getY();
        return abx * acy - aby * acx;
    }

    private static int orientation(Point a, Point b, Point c) {
        double val = cross(a, b, c);
        if (Math.abs(val) < 1e-9) return 0;
        return (val > 0) ? 1 : 2;
    }

    private static boolean onSegment(Point a, Point b, Point p) {
        return p.getX() >= Math.min(a.getX(), b.getX()) - 1e-9 &&
                p.getX() <= Math.max(a.getX(), b.getX()) + 1e-9 &&
                p.getY() >= Math.min(a.getY(), b.getY()) - 1e-9 &&
                p.getY() <= Math.max(a.getY(), b.getY()) + 1e-9;
    }

    private static boolean segmentsIntersect(Point a1, Point a2, Point b1, Point b2) {
        int o1 = orientation(a1, a2, b1);
        int o2 = orientation(a1, a2, b2);
        int o3 = orientation(b1, b2, a1);
        int o4 = orientation(b1, b2, a2);

        if (o1 != o2 && o3 != o4) return true;

        if (o1 == 0 && onSegment(a1, a2, b1)) return true;
        if (o2 == 0 && onSegment(a1, a2, b2)) return true;
        if (o3 == 0 && onSegment(b1, b2, a1)) return true;
        if (o4 == 0 && onSegment(b1, b2, a2)) return true;

        return false;
    }

    @Override
    public String toString() {
        return "Triangle: " + p1 + " " + p2 + " " + p3;
    }
}