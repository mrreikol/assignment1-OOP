package geometry;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2, 0, 1);
        Circle c3 = new Circle(0, 0, 0.5);

        System.out.println("c1 = " + c1);
        System.out.println("Area c1 = " + c1.getArea());
        System.out.println("Perimeter c1 = " + c1.getPerimeter());

        System.out.println("c1 contains (0.5,0.5)? " + c1.contains(0.5, 0.5));
        System.out.println("c1 contains c3? " + c1.contains(c3));
        System.out.println("c1 overlaps c2? " + c1.overlaps(c2));
    }
}