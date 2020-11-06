package com.company;

import java.util.Arrays;

public class Rank {
    public static String[] rank(String[] input){
        if(input.length==0 || input==null) {
            return new String[0];
        }
        else{
            int i=0;
            int left=0;
            int right=input.length-1;
            while(i<right) {
                if (input[i].equals("r")) {
                    String t1 = input[i];
                    input[i] = input[left];
                    input[left] = t1;
                    i++;
                    left++;
                } else if (input[i].equals("g")) {
                    i++;
                } else if (input[i].equals("b")) {
                    String t2 = input[i];
                    input[i] = input[right];
                    input[right] = t2;
                    right--;
                }
            }
            return input;
        }
    }
    public static void main(String[] args) {
	// write your code here
        String[] array={"r","b","g","r","b","g","b","g"};
        System.out.println(Arrays.asList(rank(array)));
    }
}
