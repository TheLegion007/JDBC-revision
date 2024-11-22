import java.util.Scanner;

public class ExceptionDemo {

    public static void compare(int v1 , int v2) {
        if(v1>v2)
            System.out.println("The larger number is: " + v1);
        else
            System.out.println("The larger number is: " + v2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Dividend: ");
        int dividend = scanner.nextInt();
        System.out.println("Enter Divisor: ");
        int divisor = scanner.nextInt();
        int[] arr = new int[5];
        try {
            System.out.println("Outer try Block \n");
            arr[6] = 10;
            try {
                int result = dividend/divisor;
                System.out.println("result: " + result);
                System.out.println("Inner try block");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
