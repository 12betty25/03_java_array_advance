package step3_01.arrayAdvance;

import java.util.Arrays;

//배열의 주소

public class ArrayEx34 {
	
	public static void main(String[] args) {

		int nVar1 = 10;
		int nVar2 = nVar1; //값을 복사하여 대입 
		
		nVar1 = 999;
		nVar2 = 777;
		
		System.out.println("nVar1: " + nVar1);
		System.out.println("nVar2: " + nVar2);
		
		
		
		System.out.println();

		
		
		int[] arr = {87, 100, 24, 11, 79};
		int[] temp =  arr; //주소값을 대입
		
		System.out.println("arr주소: " + arr);
		System.out.println("temp주소: " + temp);
		
		arr[0] = 0;
		temp[1] = 0;
		arr[2] = 0;
		temp [3] = 0;
		temp[4] = 0;
		
		
		System.out.println("arr: " + Arrays.toString(arr));
		System.out.println("arr: " + Arrays.toString(temp));
		
	}

}
