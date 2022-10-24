package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * # 숫자이동[2단계]
 * 
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
 * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 5. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 */

public class ArrayEx27_정답예시 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] game = {0,0,1,0,2,0,0,1,0};
		int playerIdx = 0;  			// 캐릭터의 현재 위치
		
		//캐릭터 위치 설정 
		for (int i=0; i < game.length; i++) {
			if (game[i] == 2) playerIdx = i; 	//만약 //만약 i번째 요소가 2(캐릭터)면
												//playerIdx(위치)와 i를 같게 한다.
		}
		
		//게임판 출력 
		while (true) {
			
			for (int i = 0; i < game.length; i++) {
				if (game[i] == 2)	System.out.print("옷 ");	   //2(캐릭터)면 캐릭터 '옷' 출력
				else 				System.out.print(game[i]+" "); //나머지 요소 그대로 출력 
			}
			System.out.println();
			
			System.out.print("왼쪽(1) 오른쪽(2) 종료(0)");
			int move = scan.nextInt();		//사용자한테 이동 입력 받고
			
			//왼쪽 이동
			if (move == 1) {				//만약 1(왼쪽)이면
				
				if (playerIdx - 1 >= 0 ) {			//만약 playerIdx - 1이 0보다 크거나 똑같으면
					if (game[playerIdx-1] == 1) {	//playerIdx - 1번째 요소가 1이면
						System.out.print("격파[3] 입력 : "); //벽 격파
						int punch = scan.nextInt();
						if(punch != 3) continue;			 //3 입력 안 했을 시 계속해서 입력 유도
					}
					
					game[playerIdx - 1] = 2;				 //playerIdx - 1번째 요소 (이동한 곳)를 2(캐릭터)로 바꿔주고
					game[playerIdx] = 0;					 //playerIdx번째 요소 (원래 캐릭터가 있었던 곳)을 0으로 바꿔준다
					playerIdx--;							 //playerIdx를 빼줌 -> 현재 위치에 1 빼줌 
														     //playerIdx가 혹시 이동 수? 아님 현재 위치 수? -> 현재 위치였다 
					
				}	
				
			} 
			//오른쪽 이동
			else if (move == 2) {							 //만약 2(오른쪽)을 입력했으면
			
				if (playerIdx + 1 < 9 ) {					 //만약 playerIdx + 1이 9보다 작으면 (9 이상 못 지나가게 하려고)
					
					if (game[playerIdx + 1] == 1) {			 //playerIdx + 1번째 요소가 1(벽)이면
						System.out.print("격파[3] 입력 : "); //벽 뽀갈내기
						int punch = scan.nextInt();
						if (punch != 3) continue;								
					}
					game[playerIdx+1] = 2;					  // playerIdx + 1번재 요소가 2(캐릭터)로 바꿔주고 (오른쪽으로 이동했으니까 +1)
					game[playerIdx] = 0;					  //원래 있었던 자리 0으로 바꿔준다					
					playerIdx++;							  //현재 위치에 1 더해주기
					
				} 
				
			}
			//종료 
			else if (move == 0) {								//종료 바이~
				System.out.println("종료");
				scan.close();
				break;
			}
			
		}
		
	}
	
}
