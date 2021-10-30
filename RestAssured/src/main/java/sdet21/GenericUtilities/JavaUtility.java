package sdet21.GenericUtilities;

import java.util.Random;

public class JavaUtility 
{
	/**
	 * Generates a Random number
	 * @return
	 */
	public int getRandomNumber()
	{
	  Random ran = new Random();
	  int random = ran.nextInt(100);
	  return random;
	}

}
