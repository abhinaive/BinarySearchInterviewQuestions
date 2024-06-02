package org.binarysearch;

public class BookAllocation {

    public static int minNoOfPagesToBeAllocatedPerStudentForGivenNumberOfBooksAndStudents(
            int [] pagesPerBook,
            int noOfBooks,
            int noOfStudents){

                if(noOfStudents > noOfBooks){
                    return -1;
                }
                /*------------------------------------------------------------------------------*/
                /* Optimum no. of pages such that student with most book allocated gets min no. */
                /* of pages out of all possible combinations.                                   */
                /*------------------------------------------------------------------------------*/

                int start = 0, end = 0, mid, optimumNoPages = 0;

                for(int i = 0; i <  noOfBooks; i++){

                    /*--------------------------------------------------------------------------*/
                    /* Start should be maximum of array as we have to maximize the no. of       */
                    /* pages per student.                                                       */
                    /*--------------------------------------------------------------------------*/
                    start = Math.max(start,pagesPerBook[i]);
                    /*---------------------------------------------------------------------------*/
                    /* End Point Should be sum of all the pages in the Array as in worst case    */
                    /* no. of students might be 1 so all the pages must be allocated to him only */
                    /*---------------------------------------------------------------------------*/
                    end = end + pagesPerBook[i];
                }

                while(start <= end){
                    mid = start + (end - start)/2;

                    int pages = 0, count = 1; // Start assigning pages with 1st student;

                    for(int i = 0; i < noOfBooks; i++){

                        pages = pages + pagesPerBook[i];   // keep assigning pages to same student

                        if(pages > mid){
                            count++;     // Switch to next student and start assigning pages to next student;
                            pages = pagesPerBook[i];
                        }
                    }

                    if(count <= noOfStudents){
                        optimumNoPages = mid;
                        end = mid - 1;  // Move to left array to find minimum possible allocation of pages
                    }
                    else{
                        start = mid + 1;
                    }
                }

                return optimumNoPages;
    }

    public static void main(String[] args) {

        int [] pagesPerBook = new int [] {12,34,67,90};
        int noOfBooks = pagesPerBook.length;
        int noOfStudents = 2;

        System.out.println(minNoOfPagesToBeAllocatedPerStudentForGivenNumberOfBooksAndStudents(pagesPerBook,noOfBooks,noOfStudents));
    }

}
