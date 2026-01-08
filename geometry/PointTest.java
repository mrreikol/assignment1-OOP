package geometry;

public class PointTest {
    public static void main(String[] args) {

        Point p1 = new Point();
        Point p2 = new Point(12, 5);

        System.out.println("p1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("p2: (" + p2.getX() + ", " + p2.getY() + ")");

        System.out.println("Distance p1 to p2: " + p1.distance(p2));

        System.out.println("Distance p2 to (0,0): " + p2.distance(0, 0));
    }
}