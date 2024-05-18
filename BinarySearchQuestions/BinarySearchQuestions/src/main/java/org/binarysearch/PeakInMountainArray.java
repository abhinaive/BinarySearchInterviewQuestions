package org.binarysearch;

public class PeakInMountainArray {

    public static int getMaxValueIndexInAMountainArray(int [] arr){

        int mid;
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            mid = right + (left - right)/2;     // learn this as at leetcode it throws error if done other waty around

            if(arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]){
                return mid;
            }else if (arr[mid - 1] < arr[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        int arr [] = new int []{1,2,3,4,10,7,3,0};
        System.out.println(getMaxValueIndexInAMountainArray(arr));
    }

}
