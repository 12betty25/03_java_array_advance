package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * 
 * # 최대값 구하기[3단계]
 * 
 * 1. 가장 큰 값을 찾아 입력한다.
 * 2. 정답이면 해당 값을 0으로 변경한다.
 * 3. arr배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
 * 예)
 * 11, 87, 42, 100, 24
 * 입력 : 100
 * 
 * 11, 87, 42, 0, 24
 * 입력 : 87
 * 
 * 11, 0, 42, 0, 24
 * 
 */
//22.12.26 22:23 ~ 22:27

public class ArrayEx25_풀이2 {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {11, 87, 42, 100, 24};
		int count = 0;
		
		while (count < 5) {
			
			int maxNum = 0;
			int maxIdx = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (maxNum < arr[i]) {
					maxNum = arr[i];
					maxIdx = i;
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			
			System.out.print("가장 큰 숫자 입력: ");
			int answer = scan.nextInt();
			
			if (answer == maxNum) {
				arr[maxIdx] = 0;
				count++;
			}
		}
	}
}
