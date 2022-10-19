package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * 
 * # 나만의 마블
 * 
 * 옷 □ □ □ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ □ □ □ □
 * 
 * 
 * 정답의 소스를 컴파일 해보고 동작을 파악하여 코드를 작성하기.
 * 
 */

public class ArrayEx42_풀이 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		final int ROAD = 20; //테두리를 제외한 길은 사용하지 않으니까 상수로 저장해둔다
		
		int[][] map = {
			{0,   1,  2,  3, 4},	
			{15, 20, 20, 20, 5},
			{14, 20, 20, 20, 6},		//위 상수로 지정해둔 20은 바뀌지 않을 예정
			{13, 20, 20, 20, 7},
			{12, 11, 10,  9, 8}
		};
		
		int player = 0;					

		while (true) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == ROAD) {
						System.out.print("■ ");
					}
					else if (map[i][j] == player) {
						System.out.print("P ");
					}
					else {
						System.out.print("□ ");
					}
				}
				System.out.println( );
			}
			
			
			
			//입력 받기
			
			System.out.println("1~3중 입력해주세요: ");
			int move = scan.nextInt();
			
			player += move;
			
			player %= 16;
			
		}

	}

}
