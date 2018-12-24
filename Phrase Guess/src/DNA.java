/**
 * This class represents the "DNA" or attributes of each object in the population.
 * This is the class that stores the information of each object then decides how
 * likely it is to pass on it's information to the next generation.
 * 
 * @author Zach Dummer
 *
 * Last modified: Dec 22, 2018
 */
public class DNA {

	private char[] genes;
	private float fitness;
	
	/**
	 * Constructor method for DNA
	 * 
	 * @param int numChar is the number of characters in the "String"
	 */
	public DNA(int numChar) {
		genes = new char[numChar];

		//TODO
	}
	/**
	 * 
	 * @return String which is a concatenation of the characters in the array
	 */
	public String getPhrase() {
		return new String(genes);
	}
	/**
	 * Calculates how close this DNA object is to the target phrase
	 * 
	 * @param target is the target phrase
	 */
	public void fitness(String target) {
		//TODO
	}
	/**
	 * Crossover function takes the information from two parents DNA objects and creates a new child DNA
	 * 
	 * @param partner is the other DNA object that this one will share its information with
	 * @return child which is a combination of the parents information
	 */
	public DNA crossover(DNA partner) {
		DNA child = new DNA(genes.length);
		
		//TODO
		
		return child;
	}
	/**
	 * Based on the mutation rate this method randomly introduces a new character to
	 * the genes to ensure variety
	 * 
	 * 
	 * @param mutationRate
	 */
	public void mutate(float mutationRate) {
		//TODO
	}
}
