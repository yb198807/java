import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class fun implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("次线程第"+(i+1)+"次");
        }
    }
}
class fun2 extends Thread{
    public void run(){
        System.out.println("hh");
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程第"+(i+1)+"次");
            if(i==4){
                //Thread thread=new Thread(new fun());
                //thread.start();
                //thread.join();
                fun2 f=new fun2();
                f.start();
                f.join();
            }
        }
    }
    public static void forEach(String[] args) {
        int[] arr={1,2,3,4};
        for (int a : arr) {
            System.out.println(a);
        }
    }
    public static void FindOdd(String[] args) {
        int[] arr={1,2,3,4,5,7,9,0,7,5,9,3,6};
        for (int i = 0; i < arr.length-2; i++) {
            if(arr[i]%2==1){
                if(arr[i+1]%2==1){
                    if(arr[i+2]%2==1){
                        System.out.println("起始下标为"+i+"，值为"+arr[i]);
                        break;
                    }else{
                        i++;
                    }
                }else{
                    i++;
                }
            }
        }
    }
    public static void array(String[] args) {
        int[] arr=new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
            System.out.print(arr[i]+" ");
        }
    }
    public  static int ForSum(int n){
        if(n==1){
            return 1;
        }
        return n+ForSum(n-1);
    }
    public static void forSum(String[] args) {
        System.out.println(ForSum(5));
    }
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return factorial(n-1)*n;
    }
    public static void Factorial(String[] args) {
        System.out.println(factorial(5));
    }
    public static void hanoi(int n,char a,char b,char c){
        if(n==1){
            System.out.print(a+"->"+c+' ');
            return;
        }
        hanoi(n-1,a,c,b);
        System.out.print(a+"->"+c+' ');
        hanoi(n-1,b,a,c);
    }
    public static void Hanoi(String[] args) {
        hanoi(3,'A','B','C');
    }
    public static void func(int n){
        if(n<10){
            System.out.print(n);
        }else{
            func(n/10);
            System.out.print(n%10);
        }
    }
    public static void PrintNum(String[] args) {
        func(2543);
    }
    public static void Fibonacci(String[] args) {
        System.out.print("请输入数字：");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int num1 = 1, num2 = 1, num = 1;
        for (int i = 3; i <= n; i++) {
            num = num1 + num2;
            num1 = num2;
            num2 = num;
        System.out.println("第"+n+"项斐波那契数为："+num);
        }
        input.close();
    }
    public static void Random(String[] args) {
        Random r=new Random();
        int num=r.nextInt(10);
        System.out.println(num);
    }
    public static void PassWord(String[] args) {
        System.out.print("请输入密码：");
        Scanner scan=new Scanner(System.in);
        int i=3;
        while(i!=0){
            String input=scan.nextLine();
            if(input.equals("abc")){
                System.out.println("登录成功");
                break;
            }else{
                i--;
                if(i>0){
                    System.out.print("错误，重新输入：");
                }
            }
            if(i==0){
                System.out.println("错误3次，退出");
            }
        }
        scan.close();
    }
    public static void PrintX(String[] args) {
        System.out.print("请输入行数：");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(i==j||i+j==num-1){
                    System.out.print('*');
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        input.close();
    }
    public static void ForSum(String[] args) {
        double sum=0;
        int flag=1;
        for (double i = 1; i <= 100; i++) {
            sum+=1/i*flag;
            flag*=-1;
        }
        System.out.println(sum);
    }
    public static void Binary(String[] args) {
        System.out.print("请输入数字：");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        System.out.print("二进制偶数位：");
        for (int i = 31; i >= 0; i-=2) {
            System.out.print((num>>i)&1);
        }
        System.out.println();
        System.out.print("二进制奇数位：");
        for (int i = 30; i >= 0; i-=2) {
            System.out.print((num>>i)&1);
        }
        input.close();
    }
    public static void NumFor1(String[] args) {
        System.out.print("请输入数字：");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        int sum=0;
        for (int i = 0; i < 32; i++) {
            if(((num>>i)&1)==1){
                sum++;
            }
        }
        System.out.println(sum);
        input.close();
    }
    public static void NarcissisticNumber(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int num=i,sum=0;
            while(num>0){
                sum+=(int)Math.pow(num%10,3);
                num/=10;
            }
            if(sum==i){
                System.out.println(i);
            }
        }
    }
    public static void GreatestCommonDivisor(String[] args) {
        System.out.print("按大小输入2个数：");
        Scanner input=new Scanner(System.in);
        int num1=input.nextInt();
        int num2=input.nextInt();
        input.close();
        while(num2!=0){
            int num=num1%num2;
            num1=num2;
            num2=num;
        }
        System.out.println("最大公约数为："+num1);
    }
    public static void MultiplicationTable(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%-2d ",j,i,i*j);
            }
            System.out.println();
        }
    }
    public static void LeapYear(String[] args) {
        for (int i = 1000; i <= 2000; i++) {
            if((i%100!=0&&i%4==0)||i%400==0){
                System.out.print(i+" ");
            }
        }
    }
    public static void PrimeNumber2(String[] args) {
        for (int i = 2; i <=100 ; i++) {
            int j=0;
            for (j = 2; j <= Math.sqrt(i); j++) {
                if(i%j==0){
                    break;
                }
            }
            if(j>Math.sqrt(i)){
                System.out.println(i);
            }
        }
    }
    public static void PrimeNumber(String[] args) {
        System.out.print("请输入数字：");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        int i=0;
        for (i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0){
                System.out.println("不是素数");
                break;
            }
        }
        if(i>Math.sqrt(num)){
            System.out.println("是素数");
        }
        input.close();
    }
    public static void HumanAge(String[] args) {
        System.out.print("请输入年龄：");
        Scanner input=new Scanner(System.in);
        int age=input.nextInt();
        if(age>55){
            System.out.print("老年");
        }else if(age<19){
            System.out.print("少年");
        }else if (age<29) {
            System.out.print("青年");
        }else{
            System.out.print("中年");
        }
        input.close();
    }
    public static void GuessNumber(String[] args) {
        Random rand=new Random();
        int num= rand.nextInt(100)+1;
        Scanner input=new Scanner(System.in);
        System.out.print("请猜数字：");
        int scan=0;
        do{
            scan=input.nextInt();
            if(scan>num){
                System.out.print("大了，再猜：");
            }else if(scan<num){
                System.out.print("小了，再猜：");
            }else{
                System.out.println("猜对了");
            }
        }while(scan!=num);
        input.close();
    }
}