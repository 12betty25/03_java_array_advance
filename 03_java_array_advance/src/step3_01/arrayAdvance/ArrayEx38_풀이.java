package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 *	# 2차원배열 기본문제[2단계]
*/

public class ArrayEx38_풀이 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] arr = new int[3][3];
		
		int k = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		
		// 문제 1) 인덱스 2개를 입력받아 값 출력
		// 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
		//		   값 출력 : 60 
		
		System.out.print("인덱스 1 입력: ");
		int idx1 = scan.nextInt();
		System.out.print("인덱스 2 입력: ");
		int idx2 = scan.nextInt();
		
		System.out.println(arr[idx1][idx2]);
		
		
		// 문제 2) 값을 입력받아 인덱스 2개 출력
		// 예    2) 값 입력 : 60
		//		   인덱스1 출력 : 1	인덱스2 출력 : 2
		
		System.out.println("값 입력: ");
		int data = scan.nextInt();
		idx1 = 0;
		idx2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (data ==  arr[i][j]) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.println("인덱스1 : " + idx1);
		System.out.println("인덱스2 : " + idx2);
		
		
		// 문제 3) 가장 큰 값의 인덱스 2개 출력
		// 정답 3) 2 2
		
		int maxNum = arr[0][0];
		
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if (maxNum < arr[i][j]) {
					maxNum = arr[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
			
		}
		System.out.print(idx1 + " ");
		System.out.print(idx2);
		
		System.out.println();
		// 문제 4) 값 2개를 입력받아 값 교체

		System.out.println("서로 위치를 바꿀 두 값 입력");
		System.out.print("값1: ");
		int data1 = scan.nextInt();
		System.out.print("값2: ");
		int data2 = scan.nextInt();
		
		int idx1_i = 0;
		int idx1_j = 0;
		int idx2_i = 0;
		int idx2_j = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == data1) {
					idx1_i = i;
					idx1_j = j;
				}
				else if (arr[i][j] == data2) {
					idx2_i = i;
					idx2_j = j;
				}
			}
		}
		int temp = arr[idx1_i][idx1_j];
		arr[idx1_i][idx1_j] = arr[idx2_i][idx2_j];
		arr[idx2_i][idx2_j] = temp;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			
		}
		scan.close();
		
	}

}
