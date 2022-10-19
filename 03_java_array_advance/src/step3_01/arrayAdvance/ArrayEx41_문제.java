package step3_01.arrayAdvance;
/*
 * # 사다리 게임
 * 
 * 1. 0을 만나면 아래로 내려간다.
 * 2. 1일 때에는 좌우를 검사해 1인 쪽으로 이동 후 아래로 내려간다.
 * 3. x의 위치를 입력받고 사다리를 표현한다.
 * 		x = 0	x = 4
 * 		x = 1	x = 2
 * 		x = 2	x = 1
 * 		x = 3	x = 3
 * 		x = 4	x = 0
 */

import java.util.Scanner;

public class ArrayEx41_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int ladder[][]= {
				{0,0,0,0,0},
				{1,1,0,1,1},
				{0,1,1,0,0},
				{0,0,1,1,0},
				{1,1,0,0,0},
				{0,1,1,0,0},
				{1,1,0,0,0},
				{0,0,0,1,1},
				{0,0,0,0,0}};
		
		
		//사다리 만들기
		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[i].length; j++) {		// 특수문자 : ㅂ + 한자
				if (ladder[i][j] == 0) {						//만약 사다리의 가로세로 요소가 0일 때
					System.out.print(" │ ");
				}
				else if (ladder[i][j] == 1) {					//만약 사다리의 가로세로 요소가 1이고
					if (j != 0 && ladder[i][j-1] == 1) {		//j!= 0 -> 0인 곳에 들어가면 안 되는 '모양' (젤 왼ㅉ이고,
						System.out.print("─┤ ");				//ladder[i][j-1] == 1 -> j보다 한자리 적은(왼쪽의 j)가 1일 때 (그래야 연결 가능)
					}												
					else if (j != ladder[i].length - 1 && ladder[i][j+1] == 1) {   //아니면 만약 j != ladder[i].length - 1 ->  젤 오른쪽 세로 줄이라 사다리 모양이 들어가면 안 되는 곳
								 //왜 이걸 사용?????????????											//ladder[i][j+1] == 1 -> 오른쪽이 1일 때 연결시켜주어야하니까 
																					//arr[i].length는 i의 가로 길이, 갯수가 아닌 길이라 5, 갯수는 4
						System.out.print(" ├─");
						}
				}
			}
			System.out.println();
		}

		//사다리 타기 
		
		int x = 0; int y = 0;
		System.out.print("0~4 입력 : ");
		x = scan.nextInt();					//사다리 선택 (가로줄, 세로(y)는 0으로 통일)
		
		for (int i = 0; i < ladder.length; i++) {
			if (ladder[y][x] == 0) {		//만약 요소가 0이라면 
				y++;						//y를 하나 올린다 (세로)
			}
			else if (ladder[y][x] == 1) {	//만약 요소가 1이고
				if (x != 0 && ladder[y][x-1] == 1) { 	 // 가로가 0이 아니면서 (젤 왼쪽 줄) 왼쪽으로 하나 간 요소가 1이면
					x--;								 //x를 하나 뺀다
				}
				else if(x != 4 && ladder[y][x+1] == 1) { //가로가 4가 아니면서 (젤 오른쪽 줄) 오른쪽으로 하나 간 요소가 1이면
					x++;								 //x를 하나 더한다.
				}
				y++;									 //위 둘 (else if문의 두 if문) 중 하나라도 성립했으면 y를 하나 올린다
			}
		}
		
		System.out.println("x = " + x);
		//System.out.println("y = " + y);

		scan.close();

	}

}
