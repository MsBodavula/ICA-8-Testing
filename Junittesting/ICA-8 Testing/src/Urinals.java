import java.util.*;
public class Urinals {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 to read input from urinal.dat file /n Enter 1 to read input from console");
        int inputType = sc.nextInt();
        if( inputType == 1)
        {
            System.out.println("Enter input String");
            String urs = sc.next();
            boolean crt = goodString(urs);
        }
    }
    public static boolean goodString(String input){
        System.out.println("====== Vedasree Bodavula == TEST ONE EXECUTED =======");
        return true;
    }
}
