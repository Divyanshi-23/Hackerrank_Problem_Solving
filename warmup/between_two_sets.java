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

class MyComparator implements Comparator{
        public int compare(Object a,Object b){
            Integer a1 = (Integer)a;
            Integer a2 = (Integer)b;
            return a1.compareTo(a2);
        }
    }

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
     
    

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        MyComparator c = new MyComparator();
        a.sort(c);
        b.sort(c);
        int smallestOfA = a.get(0);
        int smallestOfB = b.get(0);
        int result=0;
        boolean flag = true;
        System.out.println(a);
        System.out.println(b);
        for(int i=smallestOfA ;i<=smallestOfB; i++){
            for(Integer x : a){
                if(i%x != 0 ){
                    System.out.println(i);   
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                System.out.println("++++++++");   
                flag=true; 
                continue;
            }
            
            for(Integer x : b){
                if(x%i != 0 ){
                    flag = false;
                    break;
                }
            }
            
            if(flag == true){
                result++;
            }
            flag=true; 
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
