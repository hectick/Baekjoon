import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int N = Integer.parseInt(st.nextToken());   //판의 사이즈
		int r = Integer.parseInt(st.nextToken());   //행
		int c = Integer.parseInt(st.nextToken());   //열
	
		//r행 c열에 적히 수는 내 앞에 몇개의 네모칸을 거쳤는지를 나타낸다
		
		int result = recursion(r, c, N);
		System.out.println(result);

	}

	public static int recursion(int a, int b, int N){
		int res = 0;
		int tmp = (int)Math.pow(2, N-1);
		//a행 b열
		if(a < tmp && b < tmp){ //왼위
			res = 1;
		}else if(a < tmp && b >= tmp){ //오른위
			b -= tmp;
			res = 2;
		}else if(a >= tmp && b < tmp){ //왼아래
			a -= tmp;
			res = 3;
		}else{ //오른아래
			a -= tmp;
			b -= tmp;
			res = 4;
		}
		int sum = tmp * tmp * (res-1);
		if(N > 1){
			sum += recursion(a, b, N-1);
		}else{ //N==1이 될 경우, 즉 4개의 네모만 존재해 Z모양일 경우
			return sum;
		}
		return sum;

	}
}

