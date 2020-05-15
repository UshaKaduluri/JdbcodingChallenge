package com.mindtree.discussions.JdbcCodingChallenge.utility;

import java.util.Scanner;

public class ScannerClass {
	public Scanner scanner;
	
	public String scanString()
	{
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public int scanInt()
	{
		scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public Double scanDouble()
	{
		scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
}
