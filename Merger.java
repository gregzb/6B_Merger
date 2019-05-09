/**
 * Represent a merge operation for sorted lists,
 * as described in README.md
 */

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    ArrayList<String> tempData;

    /**
     Construct an instance from a list of data
     part of which is to be merged. See README
     */
    public Merger(ArrayList<String> list) {
        usersData = list;
        tempData = new ArrayList<>(usersData);
    }


    /**
     Merge the sorted sub-lists.
     */
    public void merge(int start, int middle, int end) {
        int tempInsertIdx = start;
        int originalMid = middle;
        while (tempInsertIdx <= end) {
            if (start >= originalMid) {
                tempData.set(tempInsertIdx++, usersData.get(middle++));
            } else if (middle >= end){
                tempData.set(tempInsertIdx++, usersData.get(start++));
            } else {
                if (usersData.get(start).compareTo(usersData.get(middle)) <= 0) {
                    tempData.set(tempInsertIdx++, usersData.get(start++));
                } else {
                    tempData.set(tempInsertIdx++, usersData.get(middle++));
                }
            }
        }

        ArrayList<String> temp = usersData;
        usersData = tempData;
        tempData = temp;
    }


    /**
     @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
     @return the boolean value of the statement
     "the data in the range are in ascending order"
     */
    public boolean isSorted(int startAt, int endBefore) {
        for (int i = startAt
             ; i < endBefore - 1 // stop early, because comparing to next
                ; i++
        )
            if (usersData.get(i).compareTo(usersData.get(i + 1)) > 0) {
                return false;
            }
        return true;
    }
}