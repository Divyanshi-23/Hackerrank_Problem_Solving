import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        char c = s.charAt(8);
        String ans = s.substring(0, 8);
        String t = s.substring(0, 2);
        int a = Integer.parseInt(t);
        
        if(c=='P' || c=='p'){
            if(a<12){
                a = a + 12;
                String r = a+"";
                ans = s.replaceFirst(t, r);
                ans = ans.substring(0,8);
            } 
        }
        else{
           if(a==12){
                a = 0;
                String r = a+"0";
                ans = s.replaceFirst(t, r);
                ans = ans.substring(0,8);
           }
           
        }
        return ans;
    }
    }
    

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
