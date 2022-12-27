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


public class ArrayEx26_풀이2 {

	public static void main(String[] args) {
	
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back  = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			front[i] = i + 1;
			back[i] = SIZE + i + 1;
		}

		for (int i = 0; i < 100; i++) {
			
			int rIdx = ran.nextInt(SIZE);
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;
			
			rIdx = ran.nextInt(SIZE);
			temp = back[0];
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}
		
		int num = 1;	//문제 번호
		
		while(true) {
			
			//정답 스포하기
			int answer = 0;
			for (int i = 0; i < SIZE; i++) {
				if(front[i] == num) {
					answer = i;
				}
			}
			System.out.println(num + "[" + answer + "]");
			
			//문제 판 보여주기
			for (int i = 0; i < SIZE; i++) {
				if (front[i] == 0) {
					System.out.println("\t");	//이거 왜 하는지 알아보기
				}
				else {
					System.out.print(front[i] + " ");
				}
				
				if (i % 3 == 2) {
					System.out.println("\n");
				}
			}
			
			//정답 맞추기
			System.out.print(num + "의 인덱스 입력: ");
			int myIdx = scan.nextInt();
			
			if (front[myIdx] == num) {
				
				if(num >= 1 && num <= SIZE) {
					front[myIdx] = back[myIdx];
				}
				else {
					front[myIdx] = 0;
				}
				
				num++;
			}
			
			if (num == 19) {
				break;
			}
		}
		scan.close();
	}
	
}
