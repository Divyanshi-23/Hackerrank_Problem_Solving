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

    public static String funnyString(String s) {
        boolean flag = true;
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        
        StringBuilder str = new StringBuilder(s).reverse();
        
        for(int i=1;i<s.length()-1;i++){
            a1.add(Math.abs(s.charAt(i)-s.charAt(i+1)));
        }
        for(int i=1;i<str.length()-1;i++){
            a2.add(Math.abs(str.charAt(i)-str.charAt(i+1)));
        }
        for(int i=0;i<a1.size();i++){
            if(a1.get(i)!=a2.get(i)){
                return "Not Funny";
            }
        }
        return "Funny";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.funnyString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
