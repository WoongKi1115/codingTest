import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LookAndSay {
    public static String findLn(int n) {
        if (n == 1) {
            return "1";
        }

        String beforeLn = findLn(n-1); // 직전의 수열을 가져오기 위한 재귀

        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        // 새로운 배열 생성(앞의 숫자와 같으면 cnt를 더해주고,
        // 다르면 stringbuilder에 기존의 cnt를 삽입하고, cnt를 1로 초기화해줌.
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
        return sb.toString();
    }



    public static void main(String[] args) throws IOException {
        int n;
        while (true) {
            System.out.println("4 ~ 99 사이의 값을 입력해주세요");
            System.out.print("n = ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(reader.readLine());
            if (n<=3 || n >= 100) {
                System.out.println("입력 범위를 벗어났습니다.");
            } else {
                break;
            }
        }

        // 출력 값의 형식을 맞춰주기 위한 로직
        String line = findLn(n);
        int len = line.length()/2;
        StringBuilder sb = new StringBuilder();
        sb.append(line.charAt(len-1));
        sb.append(line.charAt(len));

        System.out.println("입력 n=" + n + ", 출력 m=" + sb);

    }
}
