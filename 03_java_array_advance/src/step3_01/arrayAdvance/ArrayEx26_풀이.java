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


public class ArrayEx26_풀이 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back  = new int[SIZE];
		
		//숫자 저장하기
		for (int i = 0; i < SIZE; i++) {
			front[i] = i + 1;
			back [i] = SIZE + (i + 1);
		}
		
		//요소 순서 섞기
		for (int i = 0; i < SIZE; i++) {
			
			int rIdx = ran.nextInt(SIZE);
			int temp = front[i];
			front[i] = front[rIdx];
			front[rIdx] = temp;
			
			
			rIdx = ran.nextInt(SIZE);
			temp = back[i];
			back[i] = back[rIdx];
			back[rIdx] = temp;
		}
		
		//답 스포
		int num = 1;
		
		while (true) {
			int answer = 0;
			for (int i = 0; i < SIZE; i++) {
				if (front[i] == num) {
					answer = i;
				}
			}
			System.out.println(num + " [" + answer +"]");
			
			//문제지 만들기
			for (int i = 0; i < SIZE; i++) {
				System.out.print(front[i] + " ");
				
				if (i % 3 ==2) System.out.println();
			}
			
			//답 입력 받기
				System.out.println("입력: ");
				int user = scan.nextInt();
				if (front[user] == num) { //answer은 인덱스 숫자 (요소가 아님) -> user == answer은 성립 
										  //1 [5]
										  //front[5] = 1        num = 1
										  //성립 
					if (num >= 1 && num <= SIZE) {
						front[user] = back[user];
					}
					else {
						front[user] = 0;
					}
				}
				
				num ++;
			
			
			if (num == 19) {
				break;
			}
		}
			scan.close();
	}
	
}
