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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        int result = 0;
        int ans = 0;
        int num = 0;
        int count = 0;
        
        for(int i=0;i<arr.size();i++){
            num = arr.get(i);
            if(map.containsKey(num)==false){
                count = 0;
                for(int j=i;j<arr.size();j++){
                    if(num == arr.get(j)){
                        count++;
                    }
                }
                map.put(num,count);
            }   
        }
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
            
        for(Object obj : set){
            Map.Entry<Integer,Integer> next = (Map.Entry)obj;
                if(next.getValue() > result){
                    result = next.getValue();
                    ans = next.getKey();
            }
        } 
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
