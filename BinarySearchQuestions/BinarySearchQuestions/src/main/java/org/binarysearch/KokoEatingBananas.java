package org.binarysearch;

public class KokoEatingBananas {

    public static int minEatingSpeedToFinishAllBananasIn8Hours(int [] pile, int givenTime){
        int start = 0;
        int end = 0;
        int mid;
        int optimumMinSpeed = 0;

        for(int i = 0; i < pile.length; i++){
            start += pile[i];
            end = Math.max(end,pile[i]);        // End should be max of all pile
        }

        start = start/givenTime;    // start will be optimised to get close to answer

        if(start == 0)  // edge case : if start (sum of all pile ) is still less than given time it will result 0
            start = 1;


        while(start <= end){
            mid = start + (end - start)/2;  // average num of banana koko can eat per hour

            int totalTime  =  0;

            for(int i = 0; i < pile.length; i++){
                totalTime = totalTime + pile[i]/mid;  // gives integer value ignore fractional part

                if(pile[i]%mid != 0){
                    totalTime = totalTime + 1;  // add 1 to answer if there exists a fractional part
                }
            }

            if(totalTime > givenTime){
                start = mid + 1;
            }else{
                optimumMinSpeed = mid;
                end = mid - 1;
            }
        }
        return optimumMinSpeed;
    }

    public static void main(String[] args) {
        int [] pile = new int [] {3,6,7,11};
        int givenTime = 8;

        System.out.println(minEatingSpeedToFinishAllBananasIn8Hours(pile,givenTime));;
    }



}
