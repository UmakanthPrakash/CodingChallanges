package codilitylessons;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FrogRiverOne {

    public static int solution(int X, int[] A) {
        // write your code in Java SE 8
        if(A.length == 0 ) return -1;
        if(A.length == 1){
            if(A[0] == 1) return 1;
            else return -1;
        }
        int firstinx = -1;
        for(int i = 0; i<A.length; i++){
            if(A[i] == X){
                firstinx = i;
                    int subval = X-1;
                    boolean resetandcontinue = true;
                    while(resetandcontinue){
                        for(int j=firstinx-1; j >= 0; j--){
                            if(A[j] == subval){
                                subval = subval-1;
                                resetandcontinue = true;
                                continue;
                            }
                        }
                        if(subval == 0){ i=A.length; break;}
                        resetandcontinue = false;
                    }

            }
        }
        return firstinx;
    }

    public static int hashsetsolution(int X, int[] A) {
        HashSet hs = new HashSet();
        for(int j=1; j<=X; j++){
            hs.add(j);
        }

        for(int i =0; i<A.length; i++){
            if(hs.remove(A[i])){
                if(hs.isEmpty()){
                    return i;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] a = {1,3,1,4,2,3,5,4};
        //int[] a = {1,2,3,4,5,3,5,4};
        int[] a = {2};
        //first find X in array
        //in descending order find all previous elements in array
        //if not found check if other index is there
        System.out.println(hashsetsolution(2,a));
    }
}


/*
A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

class Solution { public int solution(int X, int[] A); }
that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
 */