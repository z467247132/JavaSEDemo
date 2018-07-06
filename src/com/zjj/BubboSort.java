package com.zjj;

/**
 * 冒泡排序
 * @author ZJJ
 *
 */
public class BubboSort {

	public static void main(String[] args) {
		int[] arr = {1,3,6,47,9,4,5,6,4};
		printArr(arr);
		bubboSort(arr);
		printArr(arr);
	}
	
	
	public static void bubboSort(int[] arr){
		boolean flag = true;
		for(int x = 0;x<arr.length-1;x++){
			for(int y = 0;y<arr.length-x-1;y++){
				if(arr[y] > arr[y+1]){
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
					flag = false;
				}
			}
			if(flag == true){
				break;
			}
		}
	}	
	
	
	public static void printArr(int[] arr){
		System.out.print("[");
		for(int x = 0;x<arr.length;x++){
			if(x==arr.length-1){
				System.out.println(arr[x]+"]");
			}else{
				System.out.print(arr[x]+",");
			}
		}
	}

}
