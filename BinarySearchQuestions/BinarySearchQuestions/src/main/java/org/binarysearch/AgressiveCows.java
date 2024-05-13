package org.binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class AgressiveCows {

    public static int minDistanceBetweenAnyTwoCowIsAsMaxAsPossible(int [] stalls, int numOfCows){

        int start = 1;   // Assuming that min position for first cow is 1
        int end;
        int mid;
        int minDisWhichIsMax = 0;

        stalls = Arrays.stream(stalls).
                boxed().
                sorted((a, b) -> a.compareTo(b)). // sort ascending
                        mapToInt(i -> i).
                toArray();

        end = stalls[stalls.length - 1] - stalls[0];

        while(start <= end){

            mid = start + (end - start)/2;
            int count = 1;   // 1st cow is already placed at pos[0]
            int pos = stalls[0];  // 1st cow is already placed at pos[0]

            for(int i = 1; i < stalls.length; i++){  // i starts from 1 because 1st cow is already placed at 0

                if(pos + mid <= stalls[i]){
                    count++;
                    pos = stalls[i];
                }
            }
/*
            for(int stall : stalls){
                System.out.print(stall + ", ");
            }
*/

            if(count < numOfCows) {
                end = mid - 1;
            }else{
                minDisWhichIsMax = mid;
                start = mid + 1;
            }
        }

        return minDisWhichIsMax;

    }

    public static void main(String[] args) {

        int [] stalls = new int []{1,2,4,8,9};
        int numOfCows = 3;

        System.out.println(minDistanceBetweenAnyTwoCowIsAsMaxAsPossible(stalls,numOfCows));


    }
}
