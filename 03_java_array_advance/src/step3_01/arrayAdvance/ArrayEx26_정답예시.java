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
		for (int i = 0; i < 1000; i++) {		//어차피 숫자는 중복될 일 없음 계속해서 요소들의 순서가 바뀌는 거니까
			int rIdx = ran. nextInt(SIZE); //0~8
			int temp = front[0]; 	//temp에 front[0] (1)를 백업 temp = 1
			front[0] = front[rIdx]; //front[0] (1)에 front[rIdx] 값 저장 ex)rIdx = 4면 요소는 5
			front[rIdx] = temp; 	// 1을 front[rIdx]에 저장
			
			rIdx = ran.nextInt(SIZE); 
			temp = back[0];			
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}
		
		int num = 1;	//문제 카운트
		while (true) {
			
			//답 스포하기
			int answer = 0;
			for (int i = 0; i < SIZE; i++) {
				if (front[i] == num) {		//만약 앞(0~9)의 i번째 요소가 num값과 같다면	
					answer = i;				//답은 i이다
											//ex front[0] = 1
											//1 == 1 성립
											//answer = 1;
											//num은 올라가지 않고 성립되지 않을 시에 i가 올라가
											//num과 일치하는 요소를 계속해서 찾음 
				}
			}
			System.out.println(num + "[" + answer + "]"); //num과 일치하는 요소를 찾으면 출력 
			
			//게임판 보여주기
			for (int i=0; i<SIZE; i++) {
				
				if (front[i] == 0) 	System.out.print("\t"); //\t = tab 어차피 0 없어서 사용될리 없
				else 				System.out.print(front[i] + " ");
				
				if (i % 3 == 2) 	System.out.println("\n");	//3번 숫자 출력 후 줄바꿈
																//2, 5, 8 (인덱스는 숫자 - 1) 
			}
			
			//답 맞추기
			System.out.print("[" + num + "]의 인덱스 입력 : ");
			int numIdx = scan.nextInt();	//답 입력 
			
			if (front[numIdx] == num) {		//입력한 답이 맞으면	
				
				if (1 <= num && num <= SIZE) front[numIdx] = back[numIdx]; //front 요소(1~9)를 맞히면 맞힌 요소의 인덱스에 back 요소로 교체 
				else 						front[numIdx] = 0; //맞힌 숫자가 사라지지 않음 
				
				num++;										   //문제 번호 하나 올리기 
			}
			
			if (num == 19) { 	//정답을 모두 맞히면 종료 
				break;
			}
			
		}
		scan.close();
	}
	
}
