/* Class to check the Availability of Urinals*/
/* Author: Vedasree Bodavula ASU-ID: 1225885273 */

import java.util.*;
import java.io.*;
public class Urinals {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 to read input from urinal.dat file /n Enter 1 to read input from console");
        int inputType = sc.nextInt();
        if(inputType == 0)
        {
            String updated = availabilityFromFileData();
            if(updated.equals(""))
            {
                System.out.println("No inputs found in the input file to calculate output");
            }
            else
                System.out.println("Results got updated in the output file "+ updated);
        }
        else if( inputType == 1)
        {
            System.out.println("Enter input String");
            String urs = sc.next();
            boolean crt = goodString(urs);
            if(crt)
                System.out.println(countUrinals(urs));
        }
        else {
            System.out.println("Invalid input");
        }
    }

    public static String availabilityFromFileData() throws IOException
    {
        String outputFile = "";
        String path = "rule.txt";
        File resourceFile = new File("urinal.dat");
        if(!resourceFile.exists())
            return "";
        File f = new File("rule.txt");
        int count_value = 1;
        if (f.exists()) {
            System.out.println("File rule.txt exists. Checking next file");
            while (true) {
                File f1 = new File("rule" + count_value + ".txt");
                if (f1.exists() && !f1.isDirectory()) {
                    count_value += 1;
                } else {
                    path = "rule"+count_value + ".txt";
                    break;
                }
            }
        }

        if (resourceFile.exists() && !resourceFile.isDirectory()){
            FileWriter writer = null;
            BufferedReader reader1 = new BufferedReader(new FileReader(resourceFile));
            String line;
            if( (line = reader1.readLine()) != null && goodString(line))
            {
                writer = new FileWriter(path);
                writer.write(countUrinals(line) + System.lineSeparator());
                outputFile = path;
            }
            while ((line = reader1.readLine()) != null) {
                if(goodString(line)) {
                    outputFile = path;
                    if(writer != null)
                        writer.write(countUrinals(line) + System.lineSeparator());
                }
            }
            if(writer != null)
                writer.close();
        }

        System.out.println("Writing done..");
        return outputFile;
    }

    public static boolean goodString(String input){
        return (input.matches("[0-1]+"));
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