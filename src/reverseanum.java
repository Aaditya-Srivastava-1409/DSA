import java.util.*;
public class reverseanum {
    public static void main(String[] args) {
        int  n=0;
        int newnum=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int num= sc.nextInt();
        while (num>0){
            n=num%10;
            newnum= newnum*10+n;
            num=num/10;
        }
        System.out.println(newnum);
    }
}
