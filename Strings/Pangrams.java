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
    public static String pangrams(String s) {
        boolean[] arr = new boolean[26];
        boolean rs = true;
        s = s.toLowerCase();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                arr[s.charAt(i)-'a'] = true;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==false){
                rs = false;  
            }
        }
        if(rs){
               return "pangram";
        }else{
            return "not pangram";
        }           
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
