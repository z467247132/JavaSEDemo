package com.zjj;
/**
 * 选择排序法
 * @author ZJJ
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {1,3,6,47,9,4,5,6,4};
		printArr(arr);
		selectSort(arr);
		printArr(arr);
	}
	
	public static void selectSort(int[] arr){
		for(int x = 0;x<arr.length-1;x++){
			for(int y = x+1;y<arr.length;y++){
				if(arr[x] > arr[y]){
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
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
