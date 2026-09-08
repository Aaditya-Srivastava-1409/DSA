import java.util.*;
public class noofdigits {
    public static void main(String[] args) {
        int counter =0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter teh number :");
        int num= sc.nextInt();
        while (num>0){
            counter++;
            num=num/10;
        }
        System.out.println(counter);
    }
}
