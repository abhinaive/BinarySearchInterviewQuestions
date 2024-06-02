package org.binarysearch;

public class PainterPartition {

    /*--------------------------------------------------------------------*/
    /* 1 unit of wall takes 1 unit of time to paint                       */
    /* Assignment of wall must be in continuous order                     */
    /* Total time to Paint all walls is max(time taken by 1, 2, 3, ...)   */
    /*--------------------------------------------------------------------*/

    public static int minUnitOfTimeTakenToPaintAllWallsOfGivenLengths(int [] wallOfVariousLength,int noOfWalls,int noOfPainters){

        int start = 0, end = 0, mid, minTimeToFinishPaintJob = 0;

        for(int i = 0; i < noOfWalls; i++){

            /*--------------------------------------------------------------------------*/
            /* Start should be maximum of array as we have to minimize the time per     */
            /* wall paint job                                                           */
            /*--------------------------------------------------------------------------*/
            start = Math.max(start,wallOfVariousLength[i]);
            /*---------------------------------------------------------------------------*/
            /* End Point Should be sum of all the wall length in the Array as in worst   */
            /* case no. of painters might be 1 so all the walls must be allocated to him */
            /*---------------------------------------------------------------------------*/
            end = end + wallOfVariousLength[i];
        }

        while(start <= end){
            mid = start + (end - start)/2;

            int pages = 0, count = 1; // Start assigning wall with 1st student;

            for(int i = 0; i < noOfWalls; i++){

                pages = pages + wallOfVariousLength[i];   // keep assigning walls to same painter

                if(pages > mid){
                    count++;     // Switch to next painter and start assigning wall to next painter;
                    pages = wallOfVariousLength[i];
                }
            }

            if(count <= noOfPainters){
                minTimeToFinishPaintJob = mid;
                end = mid - 1;  // Move to left array to find minimum possible Time to finish
            }
            else{
                start = mid + 1;
            }
        }

        return minTimeToFinishPaintJob;
    }

    public static void main(String[] args) {

        int [] wallOfVariousLength = new int [] {5,10,30,20,15};
        int noOfWalls = wallOfVariousLength.length;
        int noOfPainters = 3;

        System.out.println(minUnitOfTimeTakenToPaintAllWallsOfGivenLengths(wallOfVariousLength,noOfWalls,noOfPainters));
    }
}
