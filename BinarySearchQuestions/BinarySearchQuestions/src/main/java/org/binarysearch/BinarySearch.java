package org.binarysearch;

public class BinarySearch {


    public static int findIndexOfElementUsingBinarySearchInAscSortedArr(int start, int end, int [] arr,int element){

        while(start <= end){
            int mid = start + (end - start)/2;

            if(element == arr[mid]){
                return mid ;
            }else if (element < arr[mid]){
                end = mid - 1;
            }else
                start = mid + 1;
        }
        return -1;
    }

    public static int findIndexOfElementUsingBinarySearchInDescSortedArr(int start, int end, int [] arr,int element){

        while(start <= end){
            int mid = start + (end - start)/2;

            if(element == arr[mid]){
                return mid ;
            }else if (element < arr[mid]){
                start = mid + 1;
            }else
                end = mid - 1;
        }
        return -1;
    }

    public static int findIndexOfFirstOccurrenceOfElementUsingBinarySearchInAscSortedArr(int start, int end, int [] arr,int element){

        int res = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(element == arr[mid]){
                res = mid;
                end = mid -1;
            }else if (element < arr[mid]){
                end  = mid - 1;
            }else
                start = mid + 1;
        }
        return res;
    }

    public static int findIndexOfLastOccurrenceOfElementUsingBinarySearchInAscSortedArr(int start, int end, int [] arr,int element){

        int res = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(element == arr[mid]){
                res = mid;
                start = mid + 1;
            }else if (element < arr[mid]){
                end  = mid - 1;
            }else
                start = mid + 1;
        }
        return res;
    }

    public static int findCountOfNoOccurrenceOfElementUsingBinarySearchInAscSortedArr(int start, int end, int [] arr,int element){

        int countNoOfOccurrences;

        int indexOfLastOccurrence = findIndexOfLastOccurrenceOfElementUsingBinarySearchInAscSortedArr(start, end,arr,element);
        int indexOfFirstOccurrence =  findIndexOfFirstOccurrenceOfElementUsingBinarySearchInAscSortedArr(start, end,arr,element);

        return countNoOfOccurrences = indexOfLastOccurrence - indexOfFirstOccurrence + 1;
    }

    public static int howManyTimesSortedArrayIsRotatedSortedArrayUsingBinarySearch(int start, int end, int [] arr){

        /********************************************************************************/
        /* Note :  No of times array is rotated = Index of min element in rotated array */
        /* Min element will be smaller than both of its neighbours in a given array.    */
        /* The min element will always lie in unsorted half of the array for bin search */
        /********************************************************************************/

        while(start <= end){
            int mid = start + (end - start)/2;
            int N = arr.length -1 ;
            int prev = (mid + N - 1)%N;    /* if mid becomes 0th index then mid - 1 = -1, so to avoid this add N and %N */
            int next = (mid + 1)%N;        /* if mid becomes last index then mid + 1 becomes out of bound , so to avoid this %N */

            if(arr[mid] <= arr[prev]  &&  arr[mid] <= arr[next]){  /* Min element will be smaller than both of its neighbours in a given array. */
                return mid;
            }else if (arr[mid] < arr[end]){
                end = mid - 1;
            }else if (arr[start] < arr[mid])
                start = mid + 1;

        }

        return -1;
    }

    public static int findMinElementInRotatedSortedArrayUsingBinarySearch(int start, int end, int [] arr){

        /********************************************************************************/
        /* Note :  No of times array is rotated = Index of min element in rotated array */
        /* Min element will be smaller than both of its neighbours in a given array.    */
        /* The min element will always lie in unsorted half of the array for bin search */
        /********************************************************************************/

        while(start <= end){
            int mid = start + (end - start)/2;
            int N = arr.length -1 ;
            int prev = (mid + N - 1)%N;    /* if mid becomes 0th index then mid - 1 = -1, so to avoid this add N and %N */
            int next = (mid + 1)%N;        /* if mid becomes last index then mid + 1 becomes out of bound , so to avoid this %N */

            if(arr[mid] <= arr[prev]  &&  arr[mid] <= arr[next]){  /* Min element will be smaller than both of its neighbours in a given array. */
                return mid;
            }else if (arr[mid] < arr[end]){
                end = mid - 1;
            }else if (arr[start] < arr[mid])
                start = mid + 1;
        }

        return -1;
    }

    public static int findAnElementInRotatedSortedArrayUsingBinarySearch(int start, int end, int [] arr,int element){

        int indexOfMinElement = findMinElementInRotatedSortedArrayUsingBinarySearch(start,end,arr);

        int foundElementAtIndex1 = findIndexOfElementUsingBinarySearchInDescSortedArr(0,indexOfMinElement -1,arr,element);

        int foundElementAtIndex2 = findIndexOfElementUsingBinarySearchInAscSortedArr(indexOfMinElement,arr.length-1,arr,element);

        if(foundElementAtIndex1 != -1)
            return foundElementAtIndex1;
        else if (foundElementAtIndex2 != -1)
            return foundElementAtIndex2;
        else
            return -1;


    //    return -1;
    }


    public static void main(String[] args) {

        int [] arrAsc = {1,2,8,9,10,11};
        int element1 = 10;
        int elementFoundAtIndex1 = findIndexOfElementUsingBinarySearchInAscSortedArr(0,arrAsc.length -1,arrAsc,element1);
        System.out.printf("Index of <%d> in Asc Sorted array : [%d] \n",element1,elementFoundAtIndex1);

        int [] arrDesc = {11,10,9,8,7,2};
        int element2 = 7;
        int elementFoundAtIndex2 = findIndexOfElementUsingBinarySearchInDescSortedArr(0,arrDesc.length -1,arrDesc,element2);
        System.out.printf("Index of <%d> in Desc Sorted array : [%d] \n",element2,elementFoundAtIndex2);

        int [] arr1st = {1,3,4,10,10,10,10,11};
        int element3 = 10;
        int indexOf1stOccurrence = findIndexOfFirstOccurrenceOfElementUsingBinarySearchInAscSortedArr(0, arr1st.length-1 , arr1st, element3);
        System.out.printf("Index of 1st Occurrence of <%d> in Asc Sorted array : [%d] \n",element3,indexOf1stOccurrence);

        int [] arrLast = {1,3,4,10,10,10,10,11};
        int element4 = 10;
        int indexOfLastOccurrence = findIndexOfLastOccurrenceOfElementUsingBinarySearchInAscSortedArr(0, arrLast.length-1 , arrLast, element4);
        System.out.printf("Index of Last Occurrence of <%d> in Asc Sorted array : [%d] \n",element4,indexOfLastOccurrence);

        int countNoOfOccurrencesOfAnElement = findCountOfNoOccurrenceOfElementUsingBinarySearchInAscSortedArr(0, arr1st.length-1,arr1st,element3);
        System.out.printf("No of Occurrences of <%d> in Asc Sorted array : [%d] \n",element3,countNoOfOccurrencesOfAnElement);

     // There was Problem with this code ---> The code was running in infinite loop
        int [] arrRotated1 = {11,12,15,18,2,5,6,8};        /* Index of Min in array = No of times a sorted array is rotated */
        int noOfRotations = howManyTimesSortedArrayIsRotatedSortedArrayUsingBinarySearch(0, arrRotated1.length-1 , arrRotated1);
        System.out.printf("Number of times a Sorted Array is Rotated : [%d] \n",noOfRotations);


        int elementToSearchFor = 5;
        int [] arrRotated2 = {11,12,15,18,2,5,6,8};
        int foundElementAtIndex = findAnElementInRotatedSortedArrayUsingBinarySearch(0,arrRotated2.length -1, arrRotated2,elementToSearchFor);
        System.out.printf("Search Result for Index of element <%d> in Rotated Sorted array : [%d] \n",elementToSearchFor,foundElementAtIndex);

    }
}
