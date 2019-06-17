package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String wordElement = phrase.toUpperCase();
	    String array1[]= wordElement.split(" |-");
	    String ack = "";
	    
		for (int i = 0; i < array1.length;i++) {
			ack += array1[i].charAt(0);
		}
		return ack;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		String str = string.toUpperCase();
		String[] word = str.split("");
		int count = 0;
		for(int i = 0;i < word.length;i++) {
			switch (word[i])
			  {//A, E, I, O, U, L, N, R, S, T = 1
			    case "A":
			    case "E":
			    case "I":
			    case "O":
			    case "U":
			    case "L":
			    case "N":
			    case "R":
				case "S":
				case "T":
					count += 1;
				    break;
				//D, G = 2
				case "D":
				case "G":
					count += 2;
					break;
				//B, C, M, P = 3
				case "B":
				case "C":
				case "M":
				case "P":
					count += 3;
					break;
				//F, H, V, W, Y = 4
				case "F":
				case "H":
				case "V":
				case "W":
				case "Y":
					count += 4;
					break;
				//K = 5;  
				case "K":
					count += 5;
					break;
				//J, X = 8;
				case "J":
				case "X":
					count +=8;
					break;
				//Q, Z = 10
				case "Q":
				case "Z":
					count += 10;
					break;
			  }
		}
		return count;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		char[] gfg = string.toCharArray(); 
		String dial = "";
		for(int i = 0; i < gfg.length;i++) {
			if(gfg[i] > 47 && gfg[i] < 58) {
				String s=Character.toString(gfg[i]);
					dial += s;
				}
			}
			//System.out.print(dial);
		if(dial.length() != 10) {
			throw new IllegalArgumentException();
		}
			
		return dial;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String[] words = string.split("\\W+");
		Integer word = 1;
	
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		for(int i = 0; i < words.length;i++) {
			Integer count = 0;
			
			if( myMap.containsKey(words[i])) {
				word += 1;
				myMap.replace(words[i], word);
			}else {
				count += 1;
				myMap.put(words[i], count );
			}
		}
		return myMap;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int locaTion = 0;
			 if( t instanceof String) {
				 List<String> list = new ArrayList<>();
					list.addAll((Collection<? extends String>) getSortedList());
					String k = t.toString();
					int neeD = Integer.parseInt(t.toString());
					int min = 0;
					int max = getSortedList().size();

					
					int miDDle = (max + min) / 2;

					while (min <= max) {

						if (Integer.parseInt(list.get(miDDle)) == neeD) {
							return locaTion = miDDle;

						} else if (Integer.parseInt(list.get(miDDle)) > neeD) {
							miDDle -= 1;
						} else if (Integer.parseInt(list.get(miDDle)) < neeD) {
							miDDle += 1;
						}
					}

					return locaTion;
					
				  }
				  else if( t instanceof Integer) {
					  List<Integer> list = new ArrayList<>();
						list.addAll((Collection<? extends Integer>) getSortedList());
						String k = t.toString();
						int neeD = Integer.parseInt(t.toString());
						int min = 0;
						int max = getSortedList().size();

						
						int miDDle = (max + min) / 2;

						while (min <= max) {

							if (list.get(miDDle) == neeD) {
								return locaTion = miDDle;

							} else if (list.get(miDDle) > neeD) {
								miDDle -= 1;
							} else if (list.get(miDDle) < neeD) {
								miDDle += 1;
							}
						}

						return locaTion;
				  }
			return locaTion;
		}
		public Class getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return Integer.class;
                case 3:
                    return Double.class;
                default:
                    return Boolean.class;
            }
        }

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		boolean amStrong = false;
		int power = Integer.toString(input).length();
		String array1[]= Integer.toString(input).split("");
		int word = 0;
		int result = 0;
		
		for(int i =0; i < array1.length;i++ ) {
			int powerr = Integer.parseInt(array1[i]);
			word += Math.pow(powerr, power);
	}
		if(input == word) {
			amStrong = true;
		}
		return amStrong;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> prIme = new ArrayList<>();
        long l1 = l;
 
        for (int i = 2; i <= l1; i++) {
            if (l1 % i == 0) {
                prIme.add((long) i); // prime factor
                l1 /= i;
                i--;
            }
        }
         
        return prIme;
    }


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			String str = string.toUpperCase();
			String[] word = str.split("| ");
			String encode = "";
		
			for(int i = 0;i < word.length;i++) {
				switch (word[i])
				  {
				    case "A":
				    	encode += "z";
				    	break;
				    case "B":
				    	encode += "y";
				    	break;
				    case "C":
				    	encode += "x";
				    	break;
				    case "D":
				    	encode += "w";
				    	break;
				    case "E":
				    	encode += "v";
				    	break;
				    case "F":
				    	encode += "u";
				    	break;
				    case "G":
				    	encode += "t";
				    	break;
				    case "H":
				    	encode += "s";
				    	break;
					case "I":
						encode += "r";
				    	break;
					case "J":
						encode += "q";
				    	break;
					case "K":
						encode += "p";
				    	break;
					case "L":
						encode += "o";
				    	break;
					case "M":
						encode += "n";
				    	break;
					case "N":
						encode += "m";
				    	break;
					case "O":
						encode += "l";
				    	break;
					case "P":
						encode += "k";
				    	break;
					case "Q":
						encode += "j";
				    	break;
					case "R":
						encode += "i";
				    	break;
					case "S":
						encode += "h";
				    	break;
					case "T":
						encode += "g";
				    	break;
					case "U":
						encode += "f";
				    	break;
					case "V":
						encode += "e";
				    	break;
					case "W":
						encode += "d";
				    	break;
					case "X":
						encode += "c";
				    	break;
					case "Y":
						encode += "b";
				    	break;
					case "Z":
						encode += "a";
				    	break;
					case "0":
						encode += "0";
				    	break;
					case "1":
						encode += "1";
				    	break;
					case "2":
						encode += "2";
				    	break;
					case "3":
						encode += "3";
				    	break;
					case "4":
						encode += "4";
				    	break;
					case "5":
						encode += "5";
				    	break;
					case "6":
						encode += "6";
				    	break;
					case "7":
						encode += "7";
				    	break;
					case "8":
						encode += "8";
				    	break;
					case "9":
						encode += "9";
				    	break;
				  }
			}
			encode = encode.replaceAll(".....", "$0 ");
			return encode;
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String str = string.toUpperCase();
			String[] word = str.split("| ");
			String decode = "";
		
			for(int i = 0;i < word.length;i++) {
				switch (word[i])
				  {
				    case "A":
				    	decode += "z";
				    	break;
				    case "B":
				    	decode += "y";
				    	break;
				    case "C":
				    	decode += "x";
				    	break;
				    case "D":
				    	decode += "w";
				    	break;
				    case "E":
				    	decode += "v";
				    	break;
				    case "F":
				    	decode += "u";
				    	break;
				    case "G":
				    	decode += "t";
				    	break;
				    case "H":
				    	decode += "s";
				    	break;
					case "I":
						decode += "r";
				    	break;
					case "J":
						decode += "q";
				    	break;
					case "K":
						decode += "p";
				    	break;
					case "L":
						decode += "o";
				    	break;
					case "M":
						decode += "n";
				    	break;
					case "N":
						decode += "m";
				    	break;
					case "O":
						decode += "l";
				    	break;
					case "P":
						decode += "k";
				    	break;
					case "Q":
						decode += "j";
				    	break;
					case "R":
						decode += "i";
				    	break;
					case "S":
						decode += "h";
				    	break;
					case "T":
						decode += "g";
				    	break;
					case "U":
						decode += "f";
				    	break;
					case "V":
						decode += "e";
				    	break;
					case "W":
						decode += "d";
				    	break;
					case "X":
						decode += "c";
				    	break;
					case "Y":
						decode += "b";
				    	break;
					case "Z":
						decode += "a";
				    	break;
					case "0":
						decode += "0";
				    	break;
					case "1":
						decode += "1";
				    	break;
					case "2":
						decode += "2";
				    	break;
					case "3":
						decode += "3";
				    	break;
					case "4":
						decode += "4";
				    	break;
					case "5":
						decode += "5";
				    	break;
					case "6":
						decode += "6";
				    	break;
					case "7":
						decode += "7";
				    	break;
					case "8":
						decode += "8";
				    	break;
					case "9":
						decode += "9";
				    	break;
				  }
			}
			
			return decode;
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String str = string;      
		str = str.replaceAll("[^-0-9]+", " "); 
		List<String> array1 = Arrays.asList(str.trim().split(" "));
		Pattern p = Pattern.compile("\\d+");
		String value = string;
		
		int a =Integer.parseInt(array1.get(0)) ;
		int b =Integer.parseInt(array1.get(1));
		int answer = 0;
		String realMath = "";
		String[] elements = p.split(value);
		String[] math = value.split(" |-");
		
		for(int i = 0; i< math.length;i++) {
			if(math[i].equals("plus") ||
					math[i].equals("divided")||
					math[i].equals("multiplied")||
					math[i].equals("minus")
					) {
				realMath = math[i];
				switch (realMath)
				  {
				case "plus":
					answer= a + b;
					break;
				case"divided":
					answer=  a/b;
					break;
				case "multiplied":
					answer=  a*b;
					break;
				case "minus":
					answer=  a-b;
					break;
				  }
			}
		}
		return answer;
	}

}
