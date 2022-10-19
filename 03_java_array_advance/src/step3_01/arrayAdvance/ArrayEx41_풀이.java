package step3_01.arrayAdvance;

import java.util.Scanner;

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


public class ArrayEx41_풀이 {

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
		for (int i = 0; i < ladder.length; i++) { //세로
			for (int j = 0; j < ladder[i].length; j++) {
				if(ladder[i][j] == 0) {
					System.out.print(" │ ");
				}
				else if(ladder[i][j] == 1) {
					if(j!= 4 && ladder[i][j+1] == 1) {
						System.out.print(" ├─");
					}
					else if(j!= 0 && ladder[i][j-1] == 1) {
						System.out.print("─┤ ");
					}
				}
				
			}
			System.out.println();
		}
		
		//사다리타기
		int x = 0;
		int y = 0;
		
		System.out.print("0~4중 선택: ");
		x = scan.nextInt();
		for (int i = 0; i < ladder.length; i++) {
			if (ladder[y][x] == 0) {
				y++;
			}
			else if (ladder[y][x] == 1) {
				if (x!= 4 && ladder[y][x+1] == 1) {
					x++; //가로 오른쪽으로 하나 이동
				}
				else if (x != 0 && ladder[y][x-1] == 1) {
					x--; //가로 왼쪽으로 하나 이동
				}
				y++;
			}
		}
		System.out.println(x);

		scan.close();
	}

}
