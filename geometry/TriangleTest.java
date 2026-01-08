package geometry;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle(new Point(0, 0), new Point(2, 0), new Point(0, 2));
        Triangle t3 = new Triangle(new Point(0.5, 0.5), new Point(6, 5), new Point(5, 6));

        System.out.println("t1 area = " + t1.getArea());
        System.out.println("t1 perimeter = " + t1.getPerimeter());

        Point p = new Point(4, 5);
        System.out.println("t2 contains " + p + " ? " + t2.contains(p));

        System.out.println("t2 contains t3? " + t2.contains(t3));
        System.out.println("t2 overlaps t3? " + t2.overlaps(t3));
    }
}