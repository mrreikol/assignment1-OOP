package geometry;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(0.2, 0.2, 0.5, 0.5);
        Rectangle r3 = new Rectangle(10, 10, 2, 2);

        System.out.println("r1 = " + r1);
        System.out.println("Area r1 = " + r1.getArea());
        System.out.println("Perimeter r1 = " + r1.getPerimeter());

        System.out.println("r1 contains (0.1,0.1)? " + r1.contains(0.1, 0.1));
        System.out.println("r1 contains r2? " + r1.contains(r2));
        System.out.println("r1 overlaps r3? " + r1.overlaps(r3));
    }
}