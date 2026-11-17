package com.urlshort.utility;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class Base62 {
	
	/*
	 * Base62 encoding represents binary data or integers using a compact character set. 
	 * You can implement this in Java by creating a function that iteratively divides your input number by 62, 
	 * using the remainder to select a character from a lookup table. This table typically includes digits ‘0’-‘9’, 
	 * lowercase letters ‘a’-‘z’, and uppercase letters ‘A’-‘Z’.
	 * */
	
	public static final char[] Alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	private static final int RADIX = Alphabet.length;
	private static final SecureRandom RNG = new SecureRandom();
	
	public Base62() {}
	
	public static String randomCode(int length) {
		
		int bits = (int)Math.ceil(length * 6.0);
		byte[] buf = new byte[(bits + 7) / 8];
		
		RNG.nextBytes(buf);
		
		return encode(new BigInteger(1, buf)).substring(0, length);
	}

	private static String encode(BigInteger number) {
		// TODO Auto-generated method stub
		if(number.signum() == 0) return "0";
		
		StringBuilder sb = new StringBuilder();
		BigInteger radix = BigInteger.valueOf(RADIX);
		
		while(number.signum() > 0) {
			BigInteger[] divRem = number.divideAndRemainder(radix);
			sb.append(Alphabet[divRem[1].intValue()]);
			number = divRem[0];			
		}
		return sb.reverse().toString();
	}
}
