package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * 
 * # 배열 컨트롤러[2단계] : 벡터(Vector)
 * 
 * 1. 추가
 * . 값을 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 값 삭제
 * 3. 삭제(값)
 * . 값을 입력받아 삭제
 * . 없는 값 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 값을 입력받아 삽입
 * 
 */



public class ArrayEx35 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] score = null; //주소 변수의 초깃값 null(없음)로 지정
		int elementCnt = 0; //요소의 수 변수를 0으로 지정
		
		while (true) {
			
			for (int i = 0; i < elementCnt; i++) { 
				System.out.print(score[i] + " ");  //score 배열 출력 (처음엔 배열 값이 null이라 아무것도 출력되지 않음)
			}
			System.out.println();
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt(); //메뉴 선택 입력 변수
			
			if (sel == 1) {					//만약 메뉴 선택이 1이라면	
				if (elementCnt == 0) {		//만약 요소 수가 0일 때
					score = new int[elementCnt + 1]; //score 배열 요소의 수에 1 더함
				}
				else if (elementCnt > 0){	//아니면 만약 요소 수가 0보다 클 때
					int[] temp = score;		//temp배열에 score배열의 요소랑 연결해주고
					score = new int[elementCnt + 1]; //score배열을 요소 수 1 늘린 채로 새로 만들어줌 (새로 만드는 것, 기존의 요소의 값은 temp에 백업)
					
					for (int i=0; i<elementCnt; i++) { //?????????????
						score[i] = temp[i];			 //만약 기존 score배열이 요소의 수가 0이고 그 값이 10이라고 하면
													 //그것을 temp 배열에 백업해두고 요소의 수가 2개인 score 배열을 재정의해주는 것
													 //재정의 후에 temp배열에 백업해두었던 요소 0(i)의 값 10을 새로 만든 score 배열에 다시 넣어준다.
					}
					
					temp = null;					 //나중에 다시 추가받게 되면 백업 받아야하니까 temp 배열 초기화
				}
				System.out.print("[추가]성적 입력 : "); 
				int data = scan.nextInt();			 //추가 성적 입력 변수
				
				score[elementCnt] = data;			 //새로운 score배열 elementCnt(요소) 에 입력한 추가 성적 값 연결
				elementCnt++;						 //턴 수 하나 올리기
			}
			else if (sel == 2) {					 //만약 메뉴 선택이 2라면
				System.out.print("[삭제]인덱스 입력 : ");
				int delIdx = scan.nextInt();
				
				if (elementCnt-1 < delIdx || delIdx < 0) { //elementCnt - 1한 수가 입력 인덱스보다 작거나, 입력 인덱스가 0보다 작을 때
														   //그냥 거의 0보다 작을 때 라고 보면 될 듯
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다."); //출력 실패 문구
					continue; //계속 프로그램이 돌아가게 만듦
				}
				
				if (elementCnt == 1) { //만약 요소 수가 1일 때
					score = null;	   //하나 있는 score값을 null로 지정
				}
				else if (elementCnt > 1) { //만약 요소 수가 1보다 클 때
					int[] temp = score;    //백업 배열인 temp배열을 생성하여 score 배열과 연결
					score = new int[elementCnt - 1]; //새로운 score 배열 생성, 요소 하나를 삭제했으니 요소 수를 1 뺌
					
					for (int i=0; i<delIdx; i++) {	//???????????
						score[i] = temp[i];			//새로운 score 배열에 temp배열에 백업해두었던 걸 다시 연결
					}
					for (int i=delIdx; i<elementCnt-1; i++) { 
						score[i] = temp[i + 1];
					}
					temp = null;
				}
				
				elementCnt--; //요소 수가 삭제되었으니 턴 수도 다시 하나 줄인다.
			}
			else if (sel == 3) {
				System.out.print("[삭제]값 입력 : ");
				int delData = scan.nextInt();
				
				int delIdx = -1;
				for (int i=0; i<elementCnt; i++) {
					if (score[i] == delData) {
						delIdx = i;
					}
				}
				
				if (delIdx == -1) {
					System.out.println("[메세지]입력하신 값은 존재하지 않습니다.");
					continue;
				}
				
				if (elementCnt == 1) {
					score = null;
				}
				else if (elementCnt > 1) {
					int[] temp = score;
					score = new int[elementCnt - 1];
					
					int j = 0;
					for (int i=0; i<elementCnt; i++) {
						if (i != delIdx) {
							score[j++] = temp[i];
//							score[j] = temp[i];
//							j++;
						}
					}
					
					temp = null;
				}
				
				elementCnt--;				
			}
			else if (sel == 4) {
				System.out.print("[삽입]인덱스 입력 : ");
				int insertIdx = scan.nextInt();
				
				if (elementCnt < insertIdx || insertIdx < 0) {
					System.out.println("[메세지]해당 위치는 삽입할 수 없습니다.");
					continue;
				}
				
				System.out.print("[삽입]값 입력 : ");
				int insertData = scan.nextInt();
				
				if (elementCnt == 0) {
					score = new int[elementCnt + 1];
				}
				else if (elementCnt > 0) {
					int[] temp = score;
					score = new int[elementCnt + 1];
					
					int j = 0;
					
					for (int i=0; i<elementCnt + 1; i++) {
						if (i != insertIdx) {
							score[i] = temp[j++];
						}
					}
					temp = null;
				}
				
				score[insertIdx] = insertData;
				elementCnt++;
			}
			else if (sel == 0) {
				break;
			}
		}

		scan.close();

	}

}