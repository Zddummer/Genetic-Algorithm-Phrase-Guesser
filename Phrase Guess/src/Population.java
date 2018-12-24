import java.util.ArrayList;

/**
 * This class represents a population of DNA and decides which
 * DNA objects are the best and which ones will pass on their 
 * information to the next generation through Natural Selection.
 * 
 * @author Zach Dummer
 *
 * Last modified: Dec 24, 2018
 */
public class Population {

	private DNA[] population;
	private ArrayList<DNA> matingPool;
	private float mutationRate;
	private String target;
	private int numGen = 0;
	private boolean finished= false;
	private int perfectFit = 1;
	
	/**
	 * Constructor method for the population class
	 * 
	 * @param String t is the target phrase
	 * @param float m is the mutation rate
	 * @param int popSize is the population size
	 */
	public Population(String t, float m, int popSize) {
		target = t;
		mutationRate = m;
		population = new DNA[popSize];
		
		for(int i = 0; i < population.length; i++) {
			population[i] = new DNA(target.length());
		}
		calcFitnessPop();
		matingPool = new ArrayList<DNA>();
		
	}
	/**
	 * Calculates and fills the population array with the fitness score of each DNA object
	 */
	public void calcFitnessPop() {
		for(int i = 0; i < population.length; i++) {
			population[i].calcFitnessDNA(target);
		}
	}
	/**
	 * Generates the mating pool to pick the parents for the next generation
	 */
	public void selction() {
		
		//make sure to clear the pool from the last generation
		matingPool.clear();
		
		float maxFitness = 0;
	    for (int i = 0; i < population.length; i++) {
	      if (population[i].fitness > maxFitness) {
	        maxFitness = population[i].fitness;
	      }
	    }
	    
	    //TODO need to decide how I want to add to the pool based on fitness
	    
	}
	/**
	 * Creates the next generation
	 */
	public void createNextGen() {
		//TODO
	}
	/**
	 * Computes the DNA object with the best fitness score
	 * 
	 * @return String which is the closest phrase to the target
	 */
	public String getBest() {
		//TODO
		return "";
	}
	/**
	 * Checks to see is the target phrase has been found
	 * 
	 * @return boolean finished
	 */
	public boolean isFinished() {
		return finished;
	}
	/**
	 * Checks the number of generations
	 * 
	 * @return int numGen
	 */
	public int numGen() {
		return numGen;
	}
	/**
	 * Computes the average fitness score among the DNA objects of the current generation
	 * 
	 * @return float which is the average fitness
	 */
	public float getAvgFit() {
		//TODO
		return 0;
	}
}
