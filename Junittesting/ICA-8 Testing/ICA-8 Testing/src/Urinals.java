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
            if(crt)
                System.out.println(countUrinals(urs));
        }
    }
    public static boolean goodString(String input){
        if( input.matches("\"^[01]+$\""))
            return true;
        return false;
    }

    public static int countUrinals(String urs) {
        StringBuilder ur = new StringBuilder(urs);
        int len = ur.length();
        int s = 0;
        for (int i = 0; i < len; i++) {
            if (i + 3 < len) {
                if (ur.charAt(i) == '0' && ur.charAt(i + 1) == '0' && ur.charAt(i + 2) == '0' && ur.charAt(i + 3) == '0') {
                    ur.setCharAt(i, '1');
                    ur.setCharAt(i + 2, '1');
                    i = i + 1;
                    s = s + 2;
                } else if (ur.charAt(i) == '1' && ur.charAt(i + 1) == '0' && ur.charAt(i + 2) == '0' && ur.charAt(i + 3) == '0') {
                    ur.setCharAt(i + 2, '1');
                    i = i + 1;
                    s = s + 1;
                } else if (ur.charAt(i) == '1' && ur.charAt(i + 1) == '1') {
                    s = -1;
                    break;
                }
            } else if (i + 2 < len) {
                if (ur.charAt(i) == '1' && ur.charAt(i + 1) == '0' && ur.charAt(i + 2) == '0') {
                    ur.setCharAt(i + 2, '1');
                    i = i + 1;
                    s = s + 1;
                } else if (ur.charAt(i) == '0' && ur.charAt(i + 1) == '0' && ur.charAt(i + 2) == '0') {
                    ur.setCharAt(i, '1');
                    ur.setCharAt(i + 2, '1');
                    i = i + 1;
                    s = s + 2;
                } else if (ur.charAt(i) == '0' && ur.charAt(i + 1) == '0' && ur.charAt(i + 2) == '1' && i - 1 >= 0 && ur.charAt(i - 1) != '1') {
                    ur.setCharAt(i, '1');
                    i = i + 1;
                    s = s + 1;
                }
            } else if (i + 1 < len && i - 1 < 0) {
                if (ur.charAt(i) == '0' && ur.charAt(i + 1) == '0') {
                    ur.setCharAt(i + 1, '1');
                    s = s + 1;
                }
            } else {
                if (ur.charAt(i) == '0' && i - 1 < 0) {
                    ur.setCharAt(i, '1');
                    s = s + 1;
                }
            }


        }
        return s;
    }
}
