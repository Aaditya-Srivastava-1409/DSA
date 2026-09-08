import java.util.*;
public class palindrome {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num,reverse=0, original;
        System.out.println("Enter the no");
        num= sc.nextInt()   ;
        while(num!=0){
            int digit=num%10;
            reverse=reverse*10+digit;
            num=num/10;
        }
        if(num==reverse){
            System.out.println("Number is a palindrome");
        }
        else{
            System.out.println("It'snot a palindrome");
        }
    }
}
