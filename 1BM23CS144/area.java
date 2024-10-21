import java.util.Scanner;

class InputScanner {
    Scanner scanner = new Scanner(System.in);

   
    public int[] getRectangleDimensions() {
        System.out.print("Enter the length and breadth of the rectangle: ");
        int length = scanner.nextInt();
        int breadth = scanner.nextInt();
        return new int[]{length, breadth};
    }

    public int[] getTriangleDimensions() {
        System.out.print("Enter the base and height of the triangle: ");
        int base = scanner.nextInt();
        int height = scanner.nextInt();
        return new int[]{base, height};
    }

    public int getCircleRadius() {
        System.out.print("Enter the radius of the circle: ");
        return scanner.nextInt();
    }


    public void close() {
        scanner.close();
    }
}

abstract class Shape extends InputScanner {
    int dimension1;
    int dimension2;

   
    Shape(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    abstract void printArea();
}


class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }


    @Override
    void printArea() {
        double area = dimension1 * dimension2; 
        System.out.println("Area of rectangle = " + area);
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    
    @Override
    void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of triangle = " + area);
    }
}


class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0); 
    }

   
    @Override
    void printArea() {
        double area = Math.PI * Math.pow(dimension1, 2); 
        System.out.println("Area of circle = " + area);
    }
}


public class area {
    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner();

      
        int[] rectangleDimensions = inputScanner.getRectangleDimensions();
        Shape rectangle = new Rectangle(rectangleDimensions[0], rectangleDimensions[1]);
        
        int[] triangleDimensions = inputScanner.getTriangleDimensions();
        Shape triangle = new Triangle(triangleDimensions[0], triangleDimensions[1]);
        
        int circleRadius = inputScanner.getCircleRadius();
        Shape circle = new Circle(circleRadius);

  
        System.out.println(); 
        rectangle.printArea();
        triangle.printArea();
        circle.printArea();


        inputScanner.close();
    }
}
