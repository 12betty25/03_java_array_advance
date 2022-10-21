package step3_01.arrayAdvance;

import java.util.Random;
import java.util.Scanner;

/* 
 * # 1 to 50[3단계] : 1 to 18
 * 
 * 1. 구글에서 1 to 50 이라고 검색한다.
 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
 * 4. 숫자 1~9는 front 배열에 저장하고,
 *    숫자 10~18은 back 배열에 저장한다.
 */

public class ArrayEx26_정답예시 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back  = new int[SIZE];
		
		//번호 넣어주기
		for (int i = 0; i < SIZE; i++) {
			front[i] = i + 1; 		//1~9
			back[i] = SIZE + (i+1); //10~18
		}
		
		//순서 섞기 
		for (int i = 0; i < 1000; i++) {
			int rIdx = ran. nextInt(SIZE); //0~8
			int temp = front[0]; 	//temp에 front[0] (1)를 백업 temp = 1
			front[0] = front[rIdx]; //front[0] (1)에 front[rIdx] 값 저장 ex)rIdx = 4면 요소는 5
			front[rIdx] = temp; 	// 1을 front[rIdx]에 저장
			
//			rIdx = ran.nextInt(SIZE); -> 없어도 되나...?
			temp = back[0];			
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}
		
		int num = 1;
		while (true) {
			
			//답 스포하기
			int answer = 0;
			for (int i = 0; i < SIZE; i++) {
				if (front[i] == num) {		//만약 앞(0~9)의 i번째 요소가 num값과 같다면	
					answer = i;				//답은 i이다
											//ex front[0] = 1
											//1 == 1 성립
											//answer = 1;
				}
			}
			System.out.println(num + "[" + answer + "]"); //답 스포
			//게임판 보여주기
			for (int i=0; i<SIZE; i++) {
				
				if (front[i] == 0) 	System.out.print("\t"); //\t = tab 
				else 				System.out.print(front[i] + "\t");
				
				if (i % 3 == 2) 	System.out.println("\n");
			}
			
			System.out.print("[" + num + "]의 인덱스 입력 : ");
			int numIdx = scan.nextInt();
			
			if (front[numIdx] == num) {
				
				if (1 <= num && num <= SIZE) front[numIdx] = back[numIdx];
				else 						front[numIdx] = 0;
				
				num++;
			}
			
			if (num == 19) {
				break;
			}
			
		}
		scan.close();
	}
	
}
