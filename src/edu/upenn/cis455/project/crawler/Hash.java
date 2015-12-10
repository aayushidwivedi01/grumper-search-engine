package edu.upenn.cis455.project.crawler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// TODO: Auto-generated Javadoc
/**
 * The Class Hash.
 */
public class Hash
{
	
	/** The max. */
	private static BigInteger max = new BigInteger(
			"1461501637330902918203684832716283019655932542975");

	/**
	 * Hash key.
	 *
	 * @param key the key
	 * @param rangeSize the range size
	 * @return the int
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 */
	public static int hashKey(String key, int rangeSize)
			throws NoSuchAlgorithmException
	{
		MessageDigest encrypt = MessageDigest.getInstance("SHA-1");
		encrypt.reset();
		encrypt.update(key.getBytes());
		BigInteger hash = new BigInteger(1, encrypt.digest());
		int index = hash.multiply(new BigInteger("" + rangeSize)).divide(max)
				.intValue();
		return index;
	}

	/**
	 * Hash key.
	 *
	 * @param key the key
	 * @return the string
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 */
	public static String hashKey(String key) throws NoSuchAlgorithmException
	{
		MessageDigest encrypt = MessageDigest.getInstance("SHA-1");
		encrypt.reset();
		encrypt.update(key.getBytes());
		BigInteger hash = new BigInteger(1, encrypt.digest());
		return hash.toString(16);
	}
}
