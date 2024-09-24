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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
        int count = 0;
        int maxCount = 1;
        int index = 0;
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        while(a.size()>=1){
            int x = a.get(0);
            a.remove(0);
            ArrayList<Integer> t = new ArrayList<>();
            arr.add(t);
            t.add(x);
            if(a.size()>0){
                while(a.get(0)==x){
                    t.add(x);
                    a.remove(0);
                    if(a.size()==0){
                        break;
                    }
                }        
            }
        }
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).size()>maxCount)
                maxCount = arr.get(i).size();
        }
        
        for(int i=0;i<arr.size()-1;i++){
            int x = arr.get(i).get(0);
            int y = arr.get(i+1).get(0);
            if(x==y || y==x+1){
                count = arr.get(i).size()+arr.get(i+1).size();
            }
            if(maxCount<count){
                maxCount = count;
            }
            count = 0;
        }
        return maxCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
