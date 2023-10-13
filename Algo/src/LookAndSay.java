import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LookAndSay {
    public static String findLn(int n, Map<Integer, String> map) {
        if (n == 1) {
            return "1";
        }

        // 가져올 값이 map 안에 저장되어 있다면 return
        if (map.containsKey(n)) {
            return map.get(n);
        }

        String beforeLn = findLn(n-1, map); // 직전의 수열을 가져오기 위한 재귀
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        // 새로운 배열 생성
        for (int i = 1; i<beforeLn.length(); i++) {
            if (beforeLn.charAt(i) == beforeLn.charAt(i-1)) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(beforeLn.charAt(i-1));
                cnt = 1;
            }
        }
        sb.append(cnt);
        sb.append(beforeLn.charAt(beforeLn.length()-1));
        map.put(n, sb.toString());
        return sb.toString();
    }



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<Integer, String> map = new HashMap<>(); // 기존의 값들을 저장하고 불러오기 위한 map
        String line = findLn(n, map);
        int len = line.length()/2;
        StringBuilder sb = new StringBuilder();
        sb.append(line.charAt(len-1));
        sb.append(line.charAt(len));

        System.out.println("입력 n=" + n + ", 출력 m=" + sb);

    }
}
