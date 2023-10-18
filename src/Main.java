import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum1 = 1, sum2 = 0;
        for (int i = 1; i <= 5; i++) {
            sum1=1;
            for (int j = 1; j <= i; j++) {
                sum1*=j;
            }
            sum2+=sum1;
        }
        System.out.println(sum2);
//        Scanner input=new Scanner(System.in);
//        int a=input.nextInt();
//        System.out.println(a);
    }
}