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
    public static void miniMaxSum(List<Integer> arr) {
    
        long mincount = 9223372036854775807l;
        long maxcount = -9223372036854775808l;
        long count = 0;
        for(int i = 0;i<arr.size();i++){
            for(int j = 0;j<arr.size();j++){
                if(j!=i){
                    count = count + arr.get(j);
                }
            }
            if(count<mincount){
                mincount = count;
            }
            if(count>maxcount){
                maxcount = count;
            }
            count = 0;
        }
        System.out.println(mincount + " " + maxcount);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
