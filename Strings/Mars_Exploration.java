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
    public static int marsExploration(String s) {
        int ans = 0;
        for(int i=0;i<s.length()-2;i=i+3){
           String str = s.substring(i,i+3);
           if(!str.equals("SOS")){
               if(str.charAt(0)!='S'){
                  ans++;
               }if(str.charAt(1)!='O'){
                    ans++;
               }
                if(str.charAt(2)!='S'){
                    ans++;
                }
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

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
