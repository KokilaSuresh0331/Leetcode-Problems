package com.kokila.leet;

import java.util.Arrays;
import java.util.Scanner;

public class FindMedianSortedArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size of a");
		int m = sc.nextInt();
		int[] a = new int[m];
		System.out.println("Enter the values");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("Enter the array size of b");
		int n = sc.nextInt();
		int[] b = new int[n];
		System.out.println("Enter the values");
		for (int j = 0; j < b.length; j++) {
			b[j] = sc.nextInt();
		}
		 double median = findMedianSortedArrays(a, b);
	        
	        System.out.println("Median of the sorted arrays: " + median);
		
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2){
		int totalLength = nums1.length + nums2.length;
        int medianIndex = totalLength / 2;
        
        int i = 0, j = 0;
        int prev = 0, curr = 0;
        
        while ((i + j) <= medianIndex) {
            prev = curr;
            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }
        
        if (totalLength % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
	   
	}

