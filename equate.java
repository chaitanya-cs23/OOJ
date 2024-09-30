import java.util.Scanner;
public class equate

{
    public static void main(String[] args)
    {
        int a;
        int b;
        int c;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 'a' value: ");
        a= sc.nextInt();
        System.out.print("Enter 'b' value: ");
        b=sc.nextInt();
        System.out.print("Enter 'c' value: ");
        c=sc.nextInt();
        float disc = ((b*b)-4*a*c);
        System.out.println(disc);
        if (a==0)
        {
            System.out.println("Not Quadratic");
        }
        else
        {
            if (disc<0)
            {
            System.out.println("No real roots ");
            }
            else if (disc>0)
            {
            double root1= (-b + Math.sqrt(disc))/(2*a);
            double root2= (-b - Math.sqrt(disc))/(2*a);
            System.out.println("Real roots ");
            System.out.println("Root-1: "+root1);
            System.out.println("Root-2: "+root2);
            }
            else
            {
            double root1=(-b)/(2*a);
	    System.out.println("Real and equal");
		
            System.out.println("Root-1: "+root1);
            System.out.println("Root-2: "+root1);

            
            }
	System.out.println("k.chaitanya");
	System.out.println("1BM23CS144");

        }
    
   
        
    }

}