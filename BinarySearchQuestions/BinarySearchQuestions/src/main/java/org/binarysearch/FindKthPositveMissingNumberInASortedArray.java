package org.binarysearch;

public class FindKthPositveMissingNumberInASortedArray {

    public static int findIndexOfKthPositiveMissingNumber(int [] arr, int kth){

        int start = 0;
        int end = arr.length - 1;
        int mid;
        int indexOfKthMissingInteger = arr.length;  // Handles edge case if nothing is miss consecutively till end [1,2,3,4]

        while(start <= end){

            mid = end + (start - end)/2;

            // arr[mid] - mid - 1 => gives number of missing +ve integer till index mid
            // array of count of missing +ve integer = []
            if(arr[mid] - mid - 1 >= kth ){
                indexOfKthMissingInteger = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return indexOfKthMissingInteger + kth;  // Return the actual missing kth value in the array
    }

    public static void main(String[] args) {

//        int arr []  = new int []{2,3,4,7,11};
//        int kthMissingNumber = 5;

        int arr []  = new int []{1,2,3,4};
        int kthMissingNumber = 2;

        System.out.println(findIndexOfKthPositiveMissingNumber(arr,kthMissingNumber));
    }
}
