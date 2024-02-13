package assignment1;
//Author: Ana Chambers
import java.util.Random;

public class Assignment1 {

	public static void main(String[] args) {
		
		//Test for evenPair method
		int[] array1 = {1, 3, 5, 7, 8};
		System.out.println(evenPair(array1));
		
		//Test for hasDuplicate method
		double[] array2 = {1, 2, 3, 4, 5, 5};
		System.out.println(hasDuplicate(array2));
		
		//test for birthdayTest method
		int birthdayTest = 3;
		System.out.println(birthdaySample(birthdayTest));
		
		//test for estimatedProbability method
		System.out.println(estimateProbability(23, 100000));
		//with 23 people the probability of two people sharing a birthday 
		//based on this function hovers around 50% sometimes a little below, sometimes a little above.
		//which is in line with the Birthday Paradox
		//I ran a few other tests and they are also consistent with the wikipedia page

	}
	public static boolean evenPair(int[] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				int val = values[i] * values[j];
				if (val % 2 == 0) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean hasDuplicate(double[] darr) {
		for (int i = 0; i < darr.length; i++) {
			for (int j = i + 1; j < darr.length; j++) {
				double val1 = darr[i];
				double val2 = darr[j];
				if (val1 == val2) {
					return true;
				}
			}
		}
		return false;
	}
	public static int birthdaySample(int numPeople) {
		Random rand = new Random(); //I looked up how to make random number in Java
									//Source: https://www.geeksforgeeks.org/generating-random-numbers-in-java/
		int[] birthdayArray;
		birthdayArray = new int[numPeople];
		for (int i = 0; i < numPeople; i++) {
			int val = rand.nextInt(365);
			birthdayArray[i] = val;
		}
		for (int i = 0; i < birthdayArray.length; i++) {
			for (int j = i+1; j < birthdayArray.length; j++) {
				if (birthdayArray[i] == birthdayArray[j]) {
					return 1;
				}
			}
		}
		return 0;	
	}
	public static double estimateProbability(int numPeople, int numTrials) {
		double count1 = 0;
		for (int i = 0; i < numTrials; i ++) {
			int val = birthdaySample(numPeople);
			if (val == 1) {
				count1 ++;
			}
		}
		double result = count1 / numTrials;
		return result;
	}
	//with 23 people the probability of two people sharing a birthday 
	//based on this function hovers around 50% sometimes a little below, sometimes a little above.
	//which is in line with the Birthday Paradox
	//I ran a few other tests and they are also consistent with the wikipedia page

}
