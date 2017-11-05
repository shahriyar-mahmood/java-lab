package com.archive;

public class Math {
	
	public static void main(String[] args) {
		//sumOfMultiples(3, 5, 1000);
		//sumOfEven(4000000);
		
		System.out.println("Started....");
		long start = System.nanoTime();
		long end = System.nanoTime() - start;
		System.out.println("Run Time: " + end + "ns " + (long) end/1000000 + "ms " + (long) end/1000000000 + "s " + (long) end/1000000000/60 + "min.");
	}

	private static void sumOfMultiples(int mul1, int mul2, int max) {
		int result = 0;
		for (int i = 1; i < max; i++) {
			int mod1 = i % mul1;
			int mod2 = i % mul2;
			if (mod1 == 0 || mod2 == 0) {
				result += i;
				System.out.println(i + "is a multiple of " + mul1 + " or " + mul2);
			}
		}
		System.out.println("Sum of multiples of " + mul1 + " or " + mul2 + " under " + max + " is " + result) ;
	}
	
	private static void sumOfEven(int max) {
		int temp1 = 1;
		int temp2 = 2;
		int result = 1;
		long finalResult = 2;
		while (result < max) {
			if ((result % 2) == 0){ 
				finalResult += result;
				System.out.println(result + " " + finalResult);
			}
			
			result = temp1 + temp2;
			temp1 = temp2;
			temp2 = result;
//			System.out.println("( +" + i + ")" + result);
		}
		System.out.println("Sum of even fibonaci sequence under " + max + " is " + finalResult) ;
	}
	
	private static void primeFactors(int number) {
		for (int i = 1; i <= number; i++) {
			
		}
	}
}
