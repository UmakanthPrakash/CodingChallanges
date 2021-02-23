package codilitylessons;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingCounter {

    public static int revampsolution(int[] A){
        //Arrays.sort(A);
        Set<Integer> filteredarr = new TreeSet<>();
        for(int i=0; i<A.length; i++){
            filteredarr.add(A[i]);
        }

        int lm = 1;
        if(!filteredarr.contains(lm)) return lm;
        for(Integer curr : filteredarr){
            if(curr < 0) continue;
            if(lm == curr){
                lm++;
            }else{
                return lm;
            }
        }
        return lm;
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        TreeSet<Integer> hs = Arrays.stream(A).boxed().collect(Collectors.toCollection(TreeSet::new));
        int i = hs.first();
        if(i != 1 && i > 0){
            return 1;
        }
        if(hs.first() < 0 && hs.last() < 0){
            return 1;
        }

        Integer lm = 1;

        for(Integer curr : hs){
            if(curr < 0) continue;
            if(curr != lm){
                return lm;
            }else{
                lm++;
            }
        }
        return  lm;
        /*Integer prevalue = hs.first();
        for(Integer currValue : hs){
            if(currValue == prevalue) continue;
            if( prevalue > 0 && (prevalue+1) != currValue  ){
                return (prevalue+1);
            }
            prevalue = currValue;
        }
        return prevalue+1;*/
    }

    public static void main(String[] args) {
        //int[] a = {1, 3, 6, 4, 1, 2};
        int[] a = {1,2,3};
        //int[] a = {-999,999};
        System.out.println(revampsolution(a));
    }
}


/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */