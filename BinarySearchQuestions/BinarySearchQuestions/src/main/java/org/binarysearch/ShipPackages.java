package org.binarysearch;

public class ShipPackages {

    public static int minCapacityOfShipToShipAllPackagesInGivenDays(int [] weightOfEachParcel,int noOfPackages,int noOfDaysGiven){

        int start = 0 , end = 0, mid,  minSizeOfShip = 0;

        for(int i = 0; i < noOfPackages; i++){

            start = Math.max(start,weightOfEachParcel[i]);

            end = end + weightOfEachParcel[i];
        }

        while(start <= end){

            int count = 1, cumulativeWeight = 0;

            mid = start + (end - start)/2;

            for(int i = 0; i < noOfPackages; i++){

                cumulativeWeight = cumulativeWeight +  weightOfEachParcel[i];

                if(cumulativeWeight > mid){
                    count++;
                    cumulativeWeight = weightOfEachParcel[i];
                }
            }

            if(count <= noOfDaysGiven){
                minSizeOfShip = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return minSizeOfShip;
    }

    public static void main(String[] args) {

        int [] weightOfEachParcel = new int [] {3,2,2,4,1,4};
        int noOfPackages = weightOfEachParcel.length;
        int noOfDaysGiven = 3;

        System.out.println(minCapacityOfShipToShipAllPackagesInGivenDays(weightOfEachParcel,noOfPackages,noOfDaysGiven));
    }
}
