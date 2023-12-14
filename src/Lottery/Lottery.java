package Lottery;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static int[] createPrise(){
        int[] prise=new int[7];
        Random r=new Random();
        for (int i = 0; i < 6; ) {
            int red=r.nextInt(33)+1;
            if(duplicated(prise,red)){
                prise[i]=red;
                i++;
            }
        }
        prise[6]=r.nextInt(16)+1;
        return prise;
    }
    public static boolean duplicated(int[] prise,int num){
        for (int j : prise) {
            if (j == 0) {
                break;
            }
            if (j == num) {
                return false;
            }
        }
        return true;
    }
    public static int[] user(){
        int[] user=new int[7];
        Scanner input=new Scanner(System.in);
        for (int i = 0; i < 6; ) {
            System.out.print("请输入第"+(i+1)+"个号码：");
            int num=input.nextInt();
            if(num<0||num>33){
                System.out.println("输入有误，重新输入");
            }else{
                if(duplicated(user,num)){
                    user[i]= num;
                    System.out.println(Arrays.toString(user));
                    i++;
                }else{
                    System.out.println("重复输入，重新输入");
                }
            }
        }
        System.out.print("请输入蓝球号码：");
        while(true){
            int blue = input.nextInt();
            if (blue < 0 || blue > 16) {
                System.out.println("输入有误，重新输入");
            } else {
                    user[6] = blue;
                    System.out.println(Arrays.toString(user));
                    break;
            }
        }
        return user;
    }
    public static void prise(int red,int blue){
        if(blue==0){
            switch(red){
                case 4:
                    System.out.println("恭喜你中了五等奖，奖金10元！");
                    break;
                case 5:
                    System.out.println("恭喜你中了四等奖，奖金200元！");
                    break;
                case 6:
                    System.out.println("恭喜你中了二等奖，最高奖金500万元！");
                    break;
                default:
                    System.out.println("很遗憾未中奖");
            }
        }else{
            switch(red){
                case 0:
                case 1:
                case 2:
                    System.out.println("恭喜你中了六等奖，奖金5元！");
                    break;
                case 3:
                    System.out.println("恭喜你中了五等奖，奖金10元！");
                    break;
                case 4:
                    System.out.println("恭喜你中了四等奖，奖金200元！");
                    break;
                case 5:
                    System.out.println("恭喜你中了三等奖，奖金3000元！");
                    break;
                case 6:
                    System.out.println("恭喜你中了一等奖，最高奖金1000万元！");
                    break;
                default:
                    System.out.println("很遗憾未中奖");
            }
        }
    }
    public static void main(String[] args) {
        int[] prise=createPrise();
        int[] user=user();
        int red=0,blue=0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(prise[i]==user[j]){
                    red++;
                    break;
                }
            }
        }
        if(prise[6]==user[6]){
            blue++;
        }
        System.out.println("中奖号码为："+Arrays.toString(prise));
        System.out.println("你的号码为："+Arrays.toString(user));
        prise(red,blue);
    }
}
