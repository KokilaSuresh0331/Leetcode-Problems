package com.kokila.leet;

import java.util.Scanner;

public class RegularExpression {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a input stirng");
		String s=sc.nextLine();
		System.out.println("Enter a pattern string");
		String p=sc.nextLine();
		boolean isMatch=isMatch(s,p);
		System.out.println(isMatch);		
	}
	
	
	
	
	
	
public static boolean isMatch(String s, String p) {
	 int sPointer = 0;
	    int pPointer = 0;
	    int sStar = -1;
	    int pStar = -1;
    while (sPointer < s.length()) {
        if (pPointer < p.length() && (s.charAt(sPointer) == p.charAt(pPointer) || p.charAt(pPointer) == '.')) {
            sPointer++;
            pPointer++;
        } else if (pPointer < p.length() && p.charAt(pPointer) == '*') {
            sStar = sPointer;
            pStar = pPointer;
            pPointer++;
        } else if (pPointer < p.length() && p.charAt(pPointer) == '.') {
            sPointer++;
            pPointer++;
        } else if (pStar != -1) {
            pPointer = pStar + 1;
            sPointer = ++sStar;
        } else {
            return false;
        }
    }
    
    while (pPointer < p.length() && p.charAt(pPointer) == '*') {
        pPointer++;
    }
    
    return pPointer == p.length();
}
}