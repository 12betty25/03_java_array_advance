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

public class ArrayEx42_문제 {

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

		
		while(true) {					//계~속 돌아간다 계~속 계~~~~~~~~~~~~~~~~~~~~속
			
			// 화면출력
			for (int i = 0; i < map.length; i++) {			//5만큼		
				for (int j = 0; j < map[i].length; j++) {	//5만큼
					if (map[i][j] == ROAD) 		  	System.out.print("■ "); //만약 map요소가 20이면 왼쪽 모양 출력
					else if (map[i][j] == player) 	System.out.print("P "); //만약 map요소가 0이면 P로 출력
					else 							System.out.print("□ "); //만약 위 두 if문 중 하나도 성립이 되지 않으면 왼쪽 모양 출력
				}
				System.out.println();
			}
			System.out.println();

			
			// 입력받기
			System.out.print("1~3을 입력하세요 : ");
			int move = scan.nextInt();	//이동 수 입력 받기
			
			player += move;				//player(0)에 입력 받은 이동 수만큼 더하기
			
			player %= 16;				//??????????? //player가 원점으로 돌아오면 계속해서 움직이기 위함
			//player = player % 16					  //인데 왜 쓰는지 잘 모르겠음 ^~ㅠ
													  //아 계속 더해지면 숫자가 커지니까 16 이상이되면 나머지로 바꾸고 거기에 더하기
		}

	}

}
