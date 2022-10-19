package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 *	# 2차원배열 기본문제[2단계]
*/

public class ArrayEx38_정답예시 {

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
		
//		System.out.print("인덱스1 입력 : ");
//		int idx1 = scan.nextInt();
//		System.out.print("인덱스2 입력 : ");
//		int idx2 = scan.nextInt();
//		
//		System.out.println(arr[idx1][idx2]);
//		
//		
//		
//		// 문제 2) 값을 입력받아 인덱스 2개 출력
//		// 예    2) 값 입력 : 60
//		//		   인덱스1 출력 : 1	인덱스2 출력 : 2
//		
//		System.out.print("값 입력 : ");
//		int data = scan.nextInt();
//		
//		idx1 = 0; //idx1 변수 초기화
//		idx2 = 0; //idx2 변수 초기화
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				if (arr[i][j] == data) { //만약 배열[i][j]값이 입력한 data값과 같다면
//					idx1 = i;			 //idx1 (첫번째 인덱스)값을 [i]와 같게 만들고
//					idx2 = j;			 //idx1 (첫번째 인덱스)값을 [i]와 같게 만든다.
//				}
//			}
//		}
//		System.out.println("인덱스1 : " + idx1);
//		System.out.println("인덱스2 : " + idx2);
//		
//		
//		
//		// 문제 3) 가장 큰 값의 인덱스 2개 출력
//		// 정답 3) 2 2
//		
//		int maxNum = arr[0][0]; //우선 비교를 위해 배열의 젤 첫번째 수인 [0][0]을 맥시멈 값으로 정해두고
//		idx1 = 0;				//인덱스1과
//		idx2 = 0;				//인덱스2를 초기화 시킨다.
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				if (maxNum < arr[i][j]) { //만약 i,j 인덱스 값이 설정해둔 (처음 설정해둔 값은 [0][0]) 값보다 크다면)
//					maxNum = arr[i][j];   //증가하면서 maxnum에 설정해둔 인덱스 값보다 커지면 그 커진 값을 maxnum에 넣는다.
//					idx1 = i;			  //첫번째 배열에 가장 커진 인덱스 i 값은 idx1
//					idx2 = j;			  //두번째 배열에 가장 커진 인덱스 값을 idx2에 넣는다
//				}
//			}
//		}
//		System.out.println("인덱스1 : " + idx1);
//		System.out.println("인덱스2 : " + idx2);
//		
//		
		
		// 문제 4) 값 2개를 입력받아 값 교체 (고른 값들의 서로 위치 바꾸기)
		System.out.print("값1 입력 : ");
		int data1 = scan.nextInt(); //data1 입력
		System.out.print("값2 입력 : ");
		int data2 = scan.nextInt(); //data 2 입력
		
		int idx1_i = 0; //값1의 첫번째 배열 인덱스
		int idx1_j = 0; //값1의 두번째 배열 인덱스
		int idx2_i = 0; //값2의 첫번째 배열 인덱스
		int idx2_j = 0; //값2의 두번째 배열 인덱스
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == data1) { //만약 [i][j]값이 입력한 값1과 같다면
					idx1_i = i;			  //값1의 첫번째 배열 인덱스에 i값을 넣고
					idx1_j = j;			  //값1의 두번째 배열 인덱스에 j값을 넣는다
				}
				if (arr[i][j] == data2) { //만약 [i][j]값이 입력한 값1과 같다면
					idx2_i = i;			  //값2의 첫번째 배열 인덱스에 i값을 넣고
					idx2_j = j;			  //값2의 두번째 배열 인덱스에 j값을 넣는다
				}
			}					//!!무엇을 위해 이러한 동작이 나오는지 적기!!
		}
		
		int temp = arr[idx1_i][idx1_j];   //새로운 temp배열을 호출하여 arr[idx1_i][idx1_j] 값을 저장하고
		arr[idx1_i][idx1_j] = arr[idx2_i][idx2_j]; //arr[idx1_i][idx1_j] (값1)에 arr[idx2_i][idx2_j] (값2)를 넣는다
		arr[idx2_i][idx2_j] = temp;		  // 아 ok
		// arr[idx1_i][idx1_j]와 arr[idx2_i][idx2_j] 이 두 개의 값을 서로 바꿔야하니까
		//우선 1을 새로운 배열 temp에 담아두고
		//2를 1자리에 옮긴 다음
		//다시 temp에 담긴 1을 2에 담아주면 서로 위치가 바뀜
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		scan.close();


	}

}
