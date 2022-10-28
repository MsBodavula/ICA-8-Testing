import java.util.*;

public class Urinals {
    private String path = System.getProperty("user.dir");
    public static void main(String[] args){
        String path = System.getProperty("user.dir");
        System.out.println(path);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 to read input from urinal.dat file /n Enter 1 to read input from console");
        int inputType = sc.nextInt();
        if( inputType == 1)
        {
            System.out.println("Enter input String");
            String urs = sc.next();
            boolean crt = goodString(urs);
            /*if(crt)
                System.out.println(countUrinals(urs))*/;
        }
    }
    public static boolean goodString(String input){
       if( input.matches("\"^[01]+$\""))
           return true;
        return false;
    }


}
