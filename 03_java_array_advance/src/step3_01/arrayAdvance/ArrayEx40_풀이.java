package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 *	# 관리비
*/

public class ArrayEx40_풀이 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] apt = {
				{101, 102, 103},	
				{201, 202, 203},	
				{301, 302, 303}	
			};
			
		int[][] pay = {
			{1000, 2100, 1300},	
			{4100, 2000, 1000},	
			{3000, 1600,  800}
		};
			
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400
		
		for (int i = 0; i < pay.length; i++) {
			int total = 0;
			for (int j = 0; j < pay[i].length; j++) {
				total += pay[i][j];
			}
			System.out.println((i + 1) + "층의 관리비 = " + total + "원");
		}

		// 문제 2) 호를 입력하면 관리비 출력
		// 예    2) 입력 : 202	관리비 출력 : 2000
		
		System.out.println("호수를 입력하세요: ");
		int room = scan.nextInt();
		
		for (int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt[i].length; j++) {
				if(room == apt[i][j]) {
					System.out.println(pay[i][j]);
				}
			}
		}
		
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		
		int idx1 = 0;
		int idx =0;
		
		for (int i = 0; i < apt.length; i++) {
			int max = pay[0][0];
			int min = pay[0][0];
			for(int j = 0; j < apt[i].length; j++) {
				if(max < pay[i][j]) {
					max = pay[i][j];
				}
				else if(min > pay[i][j]) {
					min = pay[i][j];
				}
			}
		}
		
		// 문제 4) 호 2개를 입력하면 관리비 교체

	}

}
