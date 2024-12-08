import java.util.Scanner;

class Books {
    String name;
    String author;
    int price;
    int numPages;

    Books(String name, String author, int price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    public String toString() {
        return "Book name: " + this.name + "\n" +
               "Author name: " + this.author + "\n" +
               "Price: " + this.price + "\n" +
               "Number of pages: " + this.numPages;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of books");
        int n = s.nextInt();
        s.nextLine();

        Books[] b = new Books[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the book name:");
            String name = s.nextLine();

            System.out.println("Enter the author:");
            String author = s.nextLine();

            System.out.println("Enter the price:");
            int price = s.nextInt();

            System.out.println("Enter the number of pages:");
            int numPages = s.nextInt();
            s.nextLine();

            b[i] = new Books(name, author, price, numPages);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(b[i].toString());
        }
        
        System.out.println("Name:K.chaitanya");
        System.out.println("USN:1BM23CS!144");

        s.close();
    }
}


