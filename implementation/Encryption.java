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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        int x = (int)Math.floor(Math.sqrt((double)s.length()));
        int y = (int)Math.ceil(Math.sqrt((double)s.length()));
        System.out.println(x);
        System.out.println(y);
        while(x*y<s.length()){
            x++;
        }
        String ans = "";
        char[][] str = new char[x][y];
        int k=0;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(k>s.length()-1){
                    str[i][j]=0;
                    break;
                }
                str[i][j] = s.charAt(k);
                k++;
            }
        }
        
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(str[j][i]!=0)
                    ans = ans+ str[j][i];
            }
            ans = ans + " ";
        }
        ans = ans.trim();
        return ans;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
