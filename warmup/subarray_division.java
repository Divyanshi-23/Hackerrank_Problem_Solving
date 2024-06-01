import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        int count=0;
        int sum=0;
        if(m > s.size()){
            return 0;
        }
        if(m == s.size()){
            for(int i=0;i<s.size();i++){
                sum = sum + s.get(i);
            }
            if(sum==d){
                return 1;
            }else{
                return 0;
            }
        }
        if(s.size()==1 && m==1){
            if(s.get(0)==d){
                return 1;
            }
        }else{
            for(int i=0;i<=s.size()-m;i++){
                int n = m;
                int j = i;
                while(n>0){
                    sum = sum + s.get(j++);
                    n--;
                }
                if(sum==d){
                    count++;
                }
                sum=0;
            }
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }
