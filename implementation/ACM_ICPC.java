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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
        int knownTopic1 = 0;
        int knownTopic = 0;
        int team = 1;
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ArrayList<Integer> maxTopic = new ArrayList<Integer>();

        for(int i=0;i<topic.size()-1;i++){
            HashSet<Integer> s = new HashSet<>();
            for(int k=0;k<topic.get(i).length();k++){
                if(topic.get(i).charAt(k)=='1'){
                    knownTopic1++;
                    s.add(k);
                }
            }
            for(int j=i+1;j<topic.size();j++){
                knownTopic = knownTopic1;
                for(int k=0;k<topic.get(j).length();k++){
                    if(topic.get(j).charAt(k)=='1' && s.contains(k)==false){
                        knownTopic++;
                    }
                }
                maxTopic.add(knownTopic);
            }
            knownTopic1 = 0;
        }
       Collections.sort(maxTopic);
       
        int k = maxTopic.size()-1;
        while(maxTopic.get(k)==maxTopic.get(k-1)){
            team++;
            k--;
        }
        ar.add(maxTopic.get(k));
        ar.add(team);
       
        return ar;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
